package nina.isaeva.org.workingtimepraktika.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Builder.Default
    private Double rating = 0.0;

    @OneToMany(
            mappedBy = "receiver",
            cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Feedback> receivedFeedbacks = new HashSet<>();

    @OneToMany(
            mappedBy = "sender",
            cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Feedback> sendFeedbacks = new HashSet<>();

    @CreatedDate
    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY
    )
    private Set<TimeEntry> timeEntries = new HashSet<>();
}
