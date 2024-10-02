package taskmanager.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class TaskDTO {
    private Long id;
    private Long projectId;
    private List<Long> labelIds;
    private String title;
    private Integer priority;
    private Date dueDate;
    private String description;
}