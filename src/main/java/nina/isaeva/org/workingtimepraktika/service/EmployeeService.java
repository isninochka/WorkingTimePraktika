package nina.isaeva.org.workingtimepraktika.service;


import nina.isaeva.org.workingtimepraktika.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);

    List<Employee> findAll();

    Employee findById(Long id);

    List<Employee> findTopEmployees();
}
