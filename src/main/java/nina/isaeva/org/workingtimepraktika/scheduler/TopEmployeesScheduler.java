package nina.isaeva.org.workingtimepraktika.scheduler;

import lombok.RequiredArgsConstructor;
import nina.isaeva.org.workingtimepraktika.entity.Employee;
import nina.isaeva.org.workingtimepraktika.repository.EmployeeRepository;
import nina.isaeva.org.workingtimepraktika.service.EmployeeService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TopEmployeesScheduler {

    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;


    @Scheduled(cron = "0 0 0 * * *")
    @Transactional
    public void updateTopEmployees() {
        List<Employee> allEmployees = employeeService.findAll();

        allEmployees.sort(Comparator.comparing(Employee::getRating));
        if (allEmployees.size() > 10) {
            List<Employee> employeesToDelete = allEmployees.subList(10, allEmployees.size());
            employeeRepository.deleteAll(employeesToDelete);
        }

    }


}
