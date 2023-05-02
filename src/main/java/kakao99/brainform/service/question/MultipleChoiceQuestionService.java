//package kakao99.brainform.service.question;
//
//import kakao99.brainform.entity.question.MultipleChoiceQuestion;
//import kakao99.brainform.repository.question.MultipleChoiceQuestionRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class MultipleChoiceQuestionService {
//    @Autowired
//    private MultipleChoiceQuestionRepository multipleChoiceQuestionRepository;
//
//    public MultipleChoiceQuestion createQuestion(MultipleChoiceQuestion question) {
//        return multipleChoiceQuestionRepository.save(question);
//    }
//
//    public Optional<MultipleChoiceQuestion> findById(Long id) {
//        return multipleChoiceQuestionRepository.findById(id);
//    }
//}
