package taskmanager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import taskmanager.dto.request.AuthenticationRequest;
import taskmanager.dto.request.RegisterRequest;
import taskmanager.entity.Role;
import taskmanager.entity.User;
import taskmanager.repository.UserRepository;
import taskmanager.security.AuthenticationService;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
class AuthenticationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthenticationService authenticationService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Test
    void should_ReturnSuccess_When_AttemptingToRegisterNewUser() throws Exception {
        // Arrange
        RegisterRequest request = new RegisterRequest("newUser", "password");

        when(userRepository.findByUsername("newUser")).thenReturn(Optional.empty());
        when(passwordEncoder.encode("password")).thenReturn("hashedPassword");
        when(userRepository.save(any(User.class))).thenReturn(new User(12345L, "newUser", "hashedPassword", Role.USER, null, null, null));

        // Act
        // Assert
        mockMvc.perform(post("/authenticate/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().string("User registered successfully"));
    }

    @Test
    void should_ReturnBadRequest_When_AttemptingToRegisterExistingUser() throws Exception {
        var request = new RegisterRequest("existingUser", "password");

        when(userRepository.findByUsername("existingUser")).thenReturn(Optional.of(new User(54321L, "existingUser", "hashedPassword", Role.USER, null, null, null)));

        // Act
        // Assert
        mockMvc.perform(post("/authenticate/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Username already exists"));
    }

    @Test
    void should_ReturnMockToken_When_AttemptingToLogInWithValidCredentials() throws Exception {
        // Arrange
        var request = new AuthenticationRequest("validUser", "password");

        when(authenticationService.generateToken("validUser")).thenReturn("mock-token-validUser");

        // Act
        // Assert
        mockMvc.perform(post("/authenticate/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("mock-token-validUser"));
    }
}