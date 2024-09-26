package taskmanager.mapper;

import taskmanager.dto.LabelDTO;
import taskmanager.entity.Label;
import taskmanager.entity.Task;

public class LabelMapper {
    public static LabelDTO toDto(Label label) {
        return new LabelDTO(
                label.getId(),
                label.getTask().getId(),
                label.getTitle(),
                label.getDescription()
        );
    }

    public static Label toEntity(LabelDTO labelDTO, Task task) {
        Label label = new Label();
        label.setId(labelDTO.getId());
        label.setTask(task);
        label.setTitle(labelDTO.getTitle());
        label.setDescription(labelDTO.getDescription());
        return label;
    }
}