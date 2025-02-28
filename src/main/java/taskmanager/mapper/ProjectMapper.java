package taskmanager.mapper;

import taskmanager.dto.ProjectDTO;
import taskmanager.entity.Project;
import taskmanager.entity.User;

public class ProjectMapper {
    public static ProjectDTO toDto(Project project) {
        return new ProjectDTO(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getCreatedBy().getId()
        );
    }

    public static Project toEntity(ProjectDTO projectDTO, User createdBy) {
        Project project = new Project();
        project.setId(projectDTO.getId());
        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        project.setCreatedBy(createdBy);
        return project;
    }
}