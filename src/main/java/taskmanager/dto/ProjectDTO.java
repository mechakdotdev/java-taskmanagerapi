package taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProjectDTO {
    private Long id;
    private List<Long> taskIds;
    private String name;
    private String description;
}
