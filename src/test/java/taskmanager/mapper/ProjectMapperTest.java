package taskmanager.mapper;

import org.junit.jupiter.api.Test;
import taskmanager.dto.ProjectDTO;
import taskmanager.entity.Project;
import taskmanager.entity.Role;
import taskmanager.entity.User;

import static org.assertj.core.api.Assertions.assertThat;

class ProjectMapperTest {

    @Test
    void Should_MapProjectToDto() {
        User user = new User(1L, "testUser", "password123", Role.USER, null, null, null);
        Project project = new Project(1L, "Project A", "Test project", user, null);

        ProjectDTO projectDTO = ProjectMapper.toDto(project);

        assertThat(projectDTO).isNotNull();
        assertThat(projectDTO.getId()).isEqualTo(project.getId());
        assertThat(projectDTO.getName()).isEqualTo(project.getName());
        assertThat(projectDTO.getDescription()).isEqualTo(project.getDescription());
        assertThat(projectDTO.getCreatedById()).isEqualTo(user.getId());
    }

    @Test
    void Should_MapDtoToProject() {
        ProjectDTO projectDTO = new ProjectDTO(1L, "Project A", "Test project", 1L);
        User user = new User(1L, "testUser", "password123", Role.USER, null, null, null);

        Project project = ProjectMapper.toEntity(projectDTO, user);

        assertThat(project).isNotNull();
        assertThat(project.getId()).isEqualTo(projectDTO.getId());
        assertThat(project.getName()).isEqualTo(projectDTO.getName());
        assertThat(project.getDescription()).isEqualTo(projectDTO.getDescription());
        assertThat(project.getCreatedBy().getId()).isEqualTo(user.getId());
    }
}