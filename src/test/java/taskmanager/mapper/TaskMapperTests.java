package taskmanager.mapper;

import org.junit.jupiter.api.Test;

import taskmanager.dto.TaskDTO;
import taskmanager.entity.Label;
import taskmanager.entity.Project;
import taskmanager.entity.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskMapperTests {

    @Test
    void Should_MapTaskEntityToDto() {
        // Arrange
        Task task = getTask();
        List<Long> taskLabelIds = getLabelIds(task.getLabels());

        // Act
        TaskDTO taskDTO = TaskMapper.toDto(task);

        // Assert
        assertNotNull(taskDTO);
        assertEquals(task.getId(), taskDTO.getId());
        assertEquals(task.getProject().getId(), taskDTO.getProjectId());
        assertEquals(taskLabelIds, taskDTO.getLabelIds());
        assertEquals(task.getTitle(), taskDTO.getTitle());
        assertEquals(task.getPriority(), taskDTO.getPriority());
        assertEquals(task.getDueDate(), taskDTO.getDueDate());
        assertEquals(task.getDescription(), taskDTO.getDescription());
    }

    @Test
    void Should_MapTaskDtoToTaskEntity() {
        // Arrange
        var project = new Project();
        project.setId(23456L);

        List<Label> labels = getLabelList(List.of(34567L, 45678L));
        TaskDTO taskDto = getTaskDto(project, labels);

        // Act
        Task taskEntity = TaskMapper.toEntity(taskDto, project, labels);

        // Assert
        assertNotNull(taskEntity);
        assertEquals(taskDto.getId(), taskEntity.getId());
        assertEquals(project, taskEntity.getProject());
        assertEquals(labels, taskEntity.getLabels());
        assertEquals(taskDto.getTitle(), taskEntity.getTitle());
        assertEquals(taskDto.getPriority(), taskEntity.getPriority());
        assertEquals(taskDto.getDueDate(), taskEntity.getDueDate());
        assertEquals(taskDto.getDescription(), taskEntity.getDescription());
    }

    private static List<Label> getLabelList(List<Long> labelIds) {
        List<Label> labels = new ArrayList<>();

        for (Long labelId : labelIds) {
            var label = new Label();
            label.setId(labelId);
            labels.add(label);
        }

        return labels;
    }

    private static Task getTask() {
        var project = new Project();
        project.setId(12345L);

        List<Label> labels = getLabelList(List.of(34567L, 45678L));

        Task task = new Task(
                project,
                labels,
                "Sample Task One",
                5,
                LocalDate.of(2024, 1, 1),
                "This is the first sample task."
        );
        task.setId(10L);

        return task;
    }

    private static TaskDTO getTaskDto(Project project, List<Label> labels) {
        List<Long> labelIds = getLabelIds(labels);

        return new TaskDTO(
                12345L,
                project.getId(),
                labelIds,
                "Sample Task Two",
                5,
                LocalDate.of(2024, 1, 1),
                "This is the second sample task."
        );
    }

    private static List<Long> getLabelIds(List<Label> labels) {
        return labels.stream().map(Label::getId).toList();
    }
}
