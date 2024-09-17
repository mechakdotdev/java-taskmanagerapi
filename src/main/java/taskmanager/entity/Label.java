package taskmanager.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "labels")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Label {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Id Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    @NonNull
    private Task task;

    @NonNull
    private String title;

    @NonNull
    private String description;
}
