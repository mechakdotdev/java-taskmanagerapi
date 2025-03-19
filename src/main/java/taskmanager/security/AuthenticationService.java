package taskmanager.security;

import taskmanager.entity.User;

public interface AuthenticationService {
    String generateToken(String username);

    boolean validateToken(String token, User user);

    String extractUsername(String token);
}
