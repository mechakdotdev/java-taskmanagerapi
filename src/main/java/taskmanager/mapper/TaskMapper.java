package taskmanager.mapper;

import taskmanager.dto.TaskDTO;
import taskmanager.entity.Label;
import taskmanager.entity.Project;
import taskmanager.entity.Task;

import java.util.List;
import java.util.stream.Collectors;

public class TaskMapper {
    public static TaskDTO toDto(Task task) {
        return new TaskDTO(
                task.getId(),
                task.getProject().getId(),
                task.getLabels().stream().map(Label::getId).collect(Collectors.toList()),
                task.getTitle(),
                task.getPriority(),
                task.getDueDate(),
                task.getDescription()
        );
    }

    public static Task toEntity(TaskDTO taskDTO, Project project, List<Label> labels) {
        Task task = new Task(
                project,
                labels,
                taskDTO.getTitle(),
                taskDTO.getPriority(),
                taskDTO.getDueDate(),
                taskDTO.getDescription()
        );
        task.setId(taskDTO.getId());
        return task;
    }
}