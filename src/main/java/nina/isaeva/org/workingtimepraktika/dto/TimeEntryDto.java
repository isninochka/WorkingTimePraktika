package nina.isaeva.org.workingtimepraktika.dto;

public record TimeEntryDto(
        Long employeeId,
        String category,
        Integer hours
) {
}
