package nina.isaeva.org.workingtimepraktika.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nina.isaeva.org.workingtimepraktika.dto.FeedbackDto;
import nina.isaeva.org.workingtimepraktika.entity.Feedback;
import nina.isaeva.org.workingtimepraktika.service.FeedbackService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/feedbacks")
@RequiredArgsConstructor
public class FeedbackController {

    private final FeedbackService feedbackService;

    @PostMapping
    public Feedback createFeedback(@RequestBody FeedbackDto feedback) {
        log.info("Create Feedback");
        return feedbackService.add(feedback);
    }
}
