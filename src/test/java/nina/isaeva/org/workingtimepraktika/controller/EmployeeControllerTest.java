package nina.isaeva.org.workingtimepraktika.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import nina.isaeva.org.workingtimepraktika.dto.EmployeeDto;
import nina.isaeva.org.workingtimepraktika.entity.Employee;
import nina.isaeva.org.workingtimepraktika.mapper.EmployeeMapper;
import nina.isaeva.org.workingtimepraktika.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private EmployeeService employeeService;

    @Mock
    private EmployeeMapper employeeMapper;



    @Test
    @SneakyThrows
    void addEmployee() {
        EmployeeDto employeeDto = new EmployeeDto(
                "Alice",
                "Smith",
                "alice@gmail.com",
                "password");
        Employee employee = Employee.builder()
                .id(1L)
                .firstName("Alice")
                .lastName("Smith")
                .email("alice@gmail.com")
                .password("password")
                .rating(0.0)
                .build();

        when(employeeMapper.toEmployee(employeeDto)).thenReturn(employee);
        when(employeeService.save(employee)).thenReturn(employee);

        mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employeeDto)))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(employee.getId());
        assertEquals(employee.getFirstName(), employeeDto.firstName());
        assertEquals(employee.getLastName(), employeeDto.lastName());
        assertEquals(employee.getEmail(), employeeDto.email());
        assertEquals(employee.getPassword(), employeeDto.password());


    }

    @Test
    @SneakyThrows
    void topEmployees() {
        Employee employee1 = Employee.builder()
                .id(1L)
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@example.com")
                .rating(4.5)
                .build();

        Employee employee2 = Employee.builder()
                .id(2L)
                .firstName("Jane")
                .lastName("Smith")
                .email("jane.smith@example.com")
                .rating(4.7)
                .build();

        List<Employee> topEmployees = Arrays.asList(employee1, employee2);
        when(employeeService.findTopEmployees()).thenReturn(topEmployees);


        mockMvc.perform(get("/employees/top")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }
}