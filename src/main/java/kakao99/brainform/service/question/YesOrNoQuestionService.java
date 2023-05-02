//package kakao99.brainform.service.question;
//
//import kakao99.brainform.entity.question.YesOrNoQuestion;
//import kakao99.brainform.repository.question.YesOrNoQuestionRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class YesOrNoQuestionService {
//    @Autowired
//    private YesOrNoQuestionRepository yesOrNoQuestionRepository;
//
//    public YesOrNoQuestion createQuestion(YesOrNoQuestion question) {
//        return yesOrNoQuestionRepository.save(question);
//    }
//
//    public YesOrNoQuestion getQuestionById(Long id) {
//        Optional<YesOrNoQuestion> question = yesOrNoQuestionRepository.findById(id);
//        return question.orElse(null);
//    }
//
//    public List<YesOrNoQuestion> getQuestionsBySurveyId(Long surveyId) {
//        return yesOrNoQuestionRepository.findBySurveyId(surveyId);
//    }
//}
