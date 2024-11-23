package taskmanager.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class TaskDTO {
    private Long id;
    private Long projectId;
    private List<Long> labelIds;
    private String title;
    private Integer priority;
    private LocalDate dueDate;
    private String description;
}