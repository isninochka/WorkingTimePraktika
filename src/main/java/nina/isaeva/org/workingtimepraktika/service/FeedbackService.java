package nina.isaeva.org.workingtimepraktika.service;

import nina.isaeva.org.workingtimepraktika.dto.FeedbackDto;
import nina.isaeva.org.workingtimepraktika.entity.Feedback;

public interface FeedbackService {

    Feedback add(FeedbackDto feedbackDto);

}
