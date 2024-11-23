package taskmanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
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
    @JoinColumn(name = "projectId")
    @NonNull
    private Project project;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "task")
    @NonNull
    private List<Label> labels;

    @NonNull
    private String title;

    @NonNull
    private Integer priority;

    @NonNull
    private LocalDate dueDate;

    @NonNull
    private String description;
}
