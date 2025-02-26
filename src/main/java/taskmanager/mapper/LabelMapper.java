package taskmanager.mapper;

import taskmanager.dto.LabelDTO;
import taskmanager.entity.Label;
import taskmanager.entity.User;

public class LabelMapper {
    public static LabelDTO toDto(Label label) {
        return new LabelDTO(
                label.getId(),
                label.getTitle(),
                label.getDescription(),
                label.getCreatedBy().getId()
        );
    }

    public static Label toEntity(LabelDTO labelDTO, User createdBy) {
        Label label = new Label();
        label.setId(labelDTO.getId());
        label.setTitle(labelDTO.getTitle());
        label.setDescription(labelDTO.getDescription());
        label.setCreatedBy(createdBy);
        return label;
    }
}