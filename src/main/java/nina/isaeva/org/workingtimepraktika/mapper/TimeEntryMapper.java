package nina.isaeva.org.workingtimepraktika.mapper;

import nina.isaeva.org.workingtimepraktika.dto.TimeEntryDto;
import nina.isaeva.org.workingtimepraktika.entity.TimeEntry;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TimeEntryMapper {
    TimeEntry toTimeEntry(TimeEntryDto timeEntryDto);

    TimeEntryDto toTimeEntryDto(TimeEntry timeEntry);
}
