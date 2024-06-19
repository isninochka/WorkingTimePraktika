package nina.isaeva.org.workingtimepraktika.service.impl;

import lombok.RequiredArgsConstructor;
import nina.isaeva.org.workingtimepraktika.entity.Employee;
import nina.isaeva.org.workingtimepraktika.exception.EmployeeNotFoundException;
import nina.isaeva.org.workingtimepraktika.mapper.EmployeeMapper;
import nina.isaeva.org.workingtimepraktika.repository.EmployeeRepository;
import nina.isaeva.org.workingtimepraktika.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;


    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("Employee not found"));
    }

    @Override
    public List<Employee> findTopEmployees() {
        return employeeRepository.findTop10ByOrderByRatingDesc();
    }
}