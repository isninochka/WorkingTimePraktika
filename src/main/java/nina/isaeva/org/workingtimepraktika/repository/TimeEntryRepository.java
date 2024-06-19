package nina.isaeva.org.workingtimepraktika.repository;

import nina.isaeva.org.workingtimepraktika.entity.TimeEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {
    List<TimeEntry> findByEmployeeIdAndCreatedOnBetween(Long employeeId, LocalDate start, LocalDate end);
}
