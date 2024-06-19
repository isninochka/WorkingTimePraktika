package nina.isaeva.org.workingtimepraktika.service;

import nina.isaeva.org.workingtimepraktika.dto.TimeEntryDto;
import nina.isaeva.org.workingtimepraktika.entity.TimeEntry;

import java.time.LocalDate;
import java.util.List;

public interface TimeEntryService {

    TimeEntry add(TimeEntryDto timeEntryDto);

    List<TimeEntry> findForEmployee(Long employeeId, LocalDate startDate, LocalDate endDate);

}

