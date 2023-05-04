package kakao99.brainform.repository.question;

import kakao99.brainform.entity.Survey;
import kakao99.brainform.entity.question.MultipleChoiceQuestion;
import kakao99.brainform.entity.question.YesOrNoQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MultipleChoiceQuestionRepository extends JpaRepository<MultipleChoiceQuestion, Long> {

    MultipleChoiceQuestion save(MultipleChoiceQuestion multipleChoiceQuestion);
    Optional<MultipleChoiceQuestion> findBySurveyId(Long id);

//    Iterable<YesOrNoQuestion> saveAll(Iterable<YesOrNoQuestion> yesOrNoQuestions);


//    void save(QuestionInterface questionInterface);
}
