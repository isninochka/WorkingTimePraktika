package nina.isaeva.org.workingtimepraktika.mapper;

import nina.isaeva.org.workingtimepraktika.dto.EmployeeDto;
import nina.isaeva.org.workingtimepraktika.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee toEmployee(EmployeeDto employeeDto);

    EmployeeDto toEmployeeDto(Employee employee);
}