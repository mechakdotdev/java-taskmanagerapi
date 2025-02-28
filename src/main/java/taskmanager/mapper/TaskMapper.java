package taskmanager.mapper;

import taskmanager.dto.TaskDTO;
import taskmanager.entity.*;

import java.util.List;
import java.util.stream.Collectors;

public class TaskMapper {
    public static TaskDTO toDto(Task task) {
        List<Long> labelIds = task.getLabels().stream()
                .map(Label::getId)
                .collect(Collectors.toList());

        return new TaskDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority().name(),
                task.getCreatedBy().getId(),
                task.getProject().getId(),
                labelIds
        );
    }

    public static Task toEntity(TaskDTO taskDTO, User createdBy, Project project, List<Label> labels) {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        task.setPriority(Priority.valueOf(taskDTO.getPriority()));
        task.setCreatedBy(createdBy);
        task.setProject(project);
        task.setLabels(labels);
        return task;
    }
}