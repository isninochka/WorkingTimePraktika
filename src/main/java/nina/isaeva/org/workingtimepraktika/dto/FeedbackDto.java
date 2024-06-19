package nina.isaeva.org.workingtimepraktika.dto;

public record FeedbackDto(
        Long receiverId,
        Long senderId,
        Double rating,
        String text
) {
}

