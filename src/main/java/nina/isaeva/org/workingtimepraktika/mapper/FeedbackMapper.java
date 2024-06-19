package nina.isaeva.org.workingtimepraktika.mapper;

import nina.isaeva.org.workingtimepraktika.dto.FeedbackDto;
import nina.isaeva.org.workingtimepraktika.entity.Feedback;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {
    Feedback toFeedback(FeedbackDto feedbackDto);

    FeedbackDto toFeedbackDto(Feedback feedback);
}
