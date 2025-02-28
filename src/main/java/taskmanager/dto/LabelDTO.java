package taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LabelDTO {
    private Long id;
    private String title;
    private String description;
    private Long createdById;
}
