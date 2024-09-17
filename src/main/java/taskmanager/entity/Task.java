package taskmanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Task {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Id Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @NonNull
    private Project project;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "task")
    @NonNull
    private List<Label> label;

    @NonNull
    private Integer priority;

    @NonNull
    private Date dueDate;

    @NonNull
    private String description;
}
