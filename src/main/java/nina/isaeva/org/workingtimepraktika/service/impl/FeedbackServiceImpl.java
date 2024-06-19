package nina.isaeva.org.workingtimepraktika.service.impl;

import lombok.RequiredArgsConstructor;
import nina.isaeva.org.workingtimepraktika.dto.FeedbackDto;
import nina.isaeva.org.workingtimepraktika.entity.Employee;
import nina.isaeva.org.workingtimepraktika.entity.Feedback;
import nina.isaeva.org.workingtimepraktika.repository.FeedbackRepository;
import nina.isaeva.org.workingtimepraktika.service.EmployeeService;
import nina.isaeva.org.workingtimepraktika.service.FeedbackService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository feedbackRepository;

    private final EmployeeService employeeService;


    @Override
    public Feedback add(FeedbackDto feedbackDto) {
        Employee sender = employeeService.findById(feedbackDto.senderId());
        Employee receiver = employeeService.findById(feedbackDto.receiverId());
        Feedback feedback = Feedback.builder()
                .sender(sender)
                .receiver(receiver)
                .text(feedbackDto.text())
                .rating(feedbackDto.rating())
                .build();
        updateEmployeeRating(feedback.getReceiver().getId());
        return feedback;
    }

    private void updateEmployeeRating(Long employeeId) {
        List<Feedback> feedbacks = feedbackRepository.findByReceiverId(employeeId);
        double averageRating = feedbacks.stream()
                .mapToDouble(Feedback::getRating)
                .average()
                .getAsDouble();
        Employee employee = employeeService.findById(employeeId);
        employee.setRating(averageRating);
        employeeService.save(employee);
    }
}
