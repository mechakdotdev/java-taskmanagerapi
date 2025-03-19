package taskmanager.security;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import taskmanager.entity.User;

@Service
@Profile("dev")
public class MockAuthenticationService implements AuthenticationService {

    @Override
    public String generateToken(String username) {
        return "mock-token-" + username;
    }

    @Override
    public boolean validateToken(String token, User user) {
        return token.startsWith("mock-token-");
    }

    @Override
    public String extractUsername(String token) {
        return token.replace("mock-token-", "");
    }
}
