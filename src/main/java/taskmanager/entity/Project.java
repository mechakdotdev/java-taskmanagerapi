package taskmanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "projects")
@Getter @Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Project {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Id Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
    @NonNull
    private List<Task> tasks;

    @NonNull
    private String name;

    @NonNull
    private String description;
}
