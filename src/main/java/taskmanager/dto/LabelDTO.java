package taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LabelDTO {
    private Long id;
    private Long taskId;
    private String title;
    private String description;
}
