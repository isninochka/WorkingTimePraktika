package nina.isaeva.org.workingtimepraktika.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nina.isaeva.org.workingtimepraktika.dto.EmployeeDto;
import nina.isaeva.org.workingtimepraktika.entity.Employee;
import nina.isaeva.org.workingtimepraktika.mapper.EmployeeMapper;
import nina.isaeva.org.workingtimepraktika.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;


    @PostMapping
    public Employee addEmployee(@RequestBody EmployeeDto employeeDto) {
        log.info("Adding employee : {}", employeeDto);
        return employeeService.save(employeeMapper.toEmployee(employeeDto));
    }

    @GetMapping("/top")
    public List<Employee> topEmployees() {
        log.info("Top employees");
        return employeeService.findTopEmployees();
    }
}
