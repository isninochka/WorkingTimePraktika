package nina.isaeva.org.workingtimepraktika.repository;

import nina.isaeva.org.workingtimepraktika.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findTop10ByOrderByRatingDesc();
}
