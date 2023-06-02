package kakao99.brainform.repository.question;

import kakao99.brainform.entity.question.MultipleChoiceQuestion;
import kakao99.brainform.entity.question.YesOrNoQuestion;
import kakao99.brainform.service.QuestionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface YesOrNoQuestionRepository extends JpaRepository<YesOrNoQuestion, Long> {

    List<QuestionService.Question> findNumBySurveyId(Long surveyId);
    YesOrNoQuestion save(YesOrNoQuestion yesOrNoQuestion);

    Optional<YesOrNoQuestion> findBySurveyId(Long surveyId);

    YesOrNoQuestion findYesOrNoQuestionById(Long id);

    YesOrNoQuestion findAllBySurveyId(Long surveyId);
}
