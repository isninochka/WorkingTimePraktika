package nina.isaeva.org.workingtimepraktika.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nina.isaeva.org.workingtimepraktika.dto.TimeEntryDto;
import nina.isaeva.org.workingtimepraktika.entity.TimeEntry;
import nina.isaeva.org.workingtimepraktika.service.TimeEntryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/time-entries")
@RequiredArgsConstructor
public class TimeEntryController {

    private final TimeEntryService timeEntryService;


    @PostMapping
    public TimeEntry addTimeEntry(@RequestBody TimeEntryDto timeEntryDto) {
        log.info("Adding time entry: {}", timeEntryDto);
        return timeEntryService.add(timeEntryDto);
    }

    @GetMapping("/{employeeId}")
    public List<TimeEntry> findTimeEntriesForEmployee(@PathVariable Long employeeId,
                                                      @RequestParam LocalDate startDate,
                                                      @RequestParam LocalDate endDate) {
        log.info("Finding time entries for employee id: {}", employeeId);
        return timeEntryService.findForEmployee(employeeId, startDate, endDate);
    }
}
