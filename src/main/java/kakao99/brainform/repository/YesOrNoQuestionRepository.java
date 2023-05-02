package kakao99.brainform.repository;

import kakao99.brainform.entity.question.YesOrNoQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YesOrNoQuestionRepository extends JpaRepository<YesOrNoQuestion, Long> {
    List<YesOrNoQuestion> findBySurveyId(Long surveyId);
}
