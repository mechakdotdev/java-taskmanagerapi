package taskmanager.mapper;

import taskmanager.dto.ProjectDTO;
import taskmanager.entity.Project;
import taskmanager.entity.Task;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectMapper {
    public static ProjectDTO toDto(Project project) {
        return new ProjectDTO(
                project.getId(),
                project.getTasks().stream().map(Task::getId).collect(Collectors.toList()),
                project.getName(),
                project.getDescription()
        );
    }

    public static Project toEntity(ProjectDTO projectDTO, List<Task> tasks) {
        Project project = new Project();
        project.setId(projectDTO.getId());
        project.setTasks(tasks);
        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        return project;
    }
}