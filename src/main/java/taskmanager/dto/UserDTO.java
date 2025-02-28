package taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import taskmanager.entity.Role;

@Data
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private Role role;
}
