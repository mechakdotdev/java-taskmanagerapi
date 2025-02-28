package taskmanager.mapper;

import org.junit.jupiter.api.Test;
import taskmanager.dto.LabelDTO;
import taskmanager.entity.Label;
import taskmanager.entity.Role;
import taskmanager.entity.User;

import static org.assertj.core.api.Assertions.assertThat;

class LabelMapperTest {

    @Test
    void shouldMapLabelToDto() {
        User user = new User(1L, "testUser", "password123", Role.USER, null, null, null);
        Label label = new Label(1L, "Bug", "Issue label", user, null);

        LabelDTO labelDTO = LabelMapper.toDto(label);

        assertThat(labelDTO).isNotNull();
        assertThat(labelDTO.getId()).isEqualTo(label.getId());
        assertThat(labelDTO.getTitle()).isEqualTo(label.getTitle());
        assertThat(labelDTO.getDescription()).isEqualTo(label.getDescription());
        assertThat(labelDTO.getCreatedById()).isEqualTo(user.getId());
    }

    @Test
    void shouldMapDtoToLabel() {
        LabelDTO labelDTO = new LabelDTO(1L, "Bug", "Issue label", 1L);
        User user = new User(1L, "testUser", "password123", Role.USER, null, null, null);

        Label label = LabelMapper.toEntity(labelDTO, user);

        assertThat(label).isNotNull();
        assertThat(label.getId()).isEqualTo(labelDTO.getId());
        assertThat(label.getTitle()).isEqualTo(labelDTO.getTitle());
        assertThat(label.getDescription()).isEqualTo(labelDTO.getDescription());
        assertThat(label.getCreatedBy().getId()).isEqualTo(user.getId());
    }
}