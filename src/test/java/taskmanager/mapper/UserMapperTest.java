package taskmanager.mapper;

import org.junit.jupiter.api.Test;
import taskmanager.dto.UserDTO;
import taskmanager.entity.Role;
import taskmanager.entity.User;

import static org.assertj.core.api.Assertions.assertThat;

class UserMapperTest {

    @Test
    void shouldMapUserToDto() {
        User user = new User(1L, "testUser", "password123", Role.USER, null, null, null);

        UserDTO userDTO = UserMapper.toDto(user);

        assertThat(userDTO).isNotNull();
        assertThat(userDTO.getId()).isEqualTo(user.getId());
        assertThat(userDTO.getUsername()).isEqualTo(user.getUsername());
        assertThat(userDTO.getPassword()).isEqualTo(user.getPassword());
        assertThat(userDTO.getRole()).isEqualTo(user.getRole());
    }

    @Test
    void shouldMapDtoToUser() {
        UserDTO userDTO = new UserDTO(1L, "testUser", "password123", Role.USER);

        User user = UserMapper.toEntity(userDTO);

        assertThat(user).isNotNull();
        assertThat(user.getId()).isEqualTo(userDTO.getId());
        assertThat(user.getUsername()).isEqualTo(userDTO.getUsername());
        assertThat(user.getPassword()).isEqualTo(userDTO.getPassword());
        assertThat(user.getRole()).isEqualTo(Role.USER);
    }
}