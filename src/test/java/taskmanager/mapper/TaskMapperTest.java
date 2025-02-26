package taskmanager.mapper;

import org.junit.jupiter.api.Test;
import taskmanager.dto.TaskDTO;
import taskmanager.entity.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TaskMapperTest {

    @Test
    void shouldMapTaskToDto() {
        User user = new User(1L, "testUser", "password123", Role.USER, null, null, null);
        Project project = new Project(1L, "Project A", "Test project", user, null);
        Label label1 = new Label(1L, "Label1", "Description1", user, null);
        Label label2 = new Label(2L, "Label2", "Description2", user, null);
        Task task = new Task(1L, "Task A", "Task description", LocalDateTime.now(), Priority.HIGH, user, project, List.of(label1, label2));

        TaskDTO taskDTO = TaskMapper.toDto(task);

        assertThat(taskDTO).isNotNull();
        assertThat(taskDTO.getId()).isEqualTo(task.getId());
        assertThat(taskDTO.getTitle()).isEqualTo(task.getTitle());
        assertThat(taskDTO.getDescription()).isEqualTo(task.getDescription());
        assertThat(taskDTO.getDueDate()).isEqualTo(task.getDueDate());
        assertThat(taskDTO.getPriority()).isEqualTo(task.getPriority().name());
        assertThat(taskDTO.getCreatedById()).isEqualTo(user.getId());
        assertThat(taskDTO.getProjectId()).isEqualTo(project.getId());
        assertThat(taskDTO.getLabelIds()).containsExactlyInAnyOrder(1L, 2L);
    }

    @Test
    void shouldMapDtoToTask() {
        TaskDTO taskDTO = new TaskDTO(1L, "Task A", "Task description", LocalDateTime.now(), "HIGH", 1L, 1L, List.of(1L, 2L));
        User user = new User(1L, "testUser", "password123", Role.USER, null, null, null);
        Project project = new Project(1L, "Project A", "Test project", user, null);
        Label label1 = new Label(1L, "Label1", "Description1", user, null);
        Label label2 = new Label(2L, "Label2", "Description2", user, null);

        Task task = TaskMapper.toEntity(taskDTO, user, project, List.of(label1, label2));

        assertThat(task).isNotNull();
        assertThat(task.getId()).isEqualTo(taskDTO.getId());
        assertThat(task.getTitle()).isEqualTo(taskDTO.getTitle());
        assertThat(task.getDescription()).isEqualTo(taskDTO.getDescription());
        assertThat(task.getPriority()).isEqualTo(Priority.HIGH);
        assertThat(task.getCreatedBy().getId()).isEqualTo(user.getId());
        assertThat(task.getProject().getId()).isEqualTo(project.getId());
        assertThat(task.getLabels()).containsExactlyInAnyOrder(label1, label2);
    }
}