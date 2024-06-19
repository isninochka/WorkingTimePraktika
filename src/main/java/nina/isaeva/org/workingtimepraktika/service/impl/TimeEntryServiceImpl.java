package nina.isaeva.org.workingtimepraktika.service.impl;

import lombok.RequiredArgsConstructor;
import nina.isaeva.org.workingtimepraktika.dto.TimeEntryDto;
import nina.isaeva.org.workingtimepraktika.entity.Employee;
import nina.isaeva.org.workingtimepraktika.entity.TimeEntry;
import nina.isaeva.org.workingtimepraktika.repository.TimeEntryRepository;
import nina.isaeva.org.workingtimepraktika.service.EmployeeService;
import nina.isaeva.org.workingtimepraktika.service.TimeEntryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
@RequiredArgsConstructor
public class TimeEntryServiceImpl implements TimeEntryService {
    private final TimeEntryRepository timeEntryRepository;

    private final EmployeeService employeeService;

    @Override
    public TimeEntry add(TimeEntryDto timeEntryDto) {
        Employee employee = employeeService.findById(timeEntryDto.employeeId());
        TimeEntry timeEntry = TimeEntry.builder()
                .employee(employee)
                .category(timeEntryDto.category())
                .hours(timeEntryDto.hours())
                .build();
        return timeEntryRepository.save(timeEntry);
    }

    @Override
    public List<TimeEntry> findForEmployee(Long employeeId, LocalDate startDate, LocalDate endDate) {
        return timeEntryRepository.findByEmployeeIdAndCreatedOnBetween(employeeId, startDate, endDate);
    }
}
