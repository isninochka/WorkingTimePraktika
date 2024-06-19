package nina.isaeva.org.workingtimepraktika.repository;

import nina.isaeva.org.workingtimepraktika.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {


    @Query("SELECT f FROM Feedback f WHERE f.receiver.id = :employeeId")
    List<Feedback> findByReceiverId(@Param("employeeId") Long employeeId);

    @Query("SELECT f FROM Feedback f WHERE f.sender.id = :employeeId")
    List<Feedback> findBySenderId(@Param("employeeId") Long employeeId);
}
