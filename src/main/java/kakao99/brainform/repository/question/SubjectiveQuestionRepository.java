package kakao99.brainform.repository.question;

import kakao99.brainform.entity.question.MultipleChoiceQuestion;
import kakao99.brainform.entity.question.SubjectiveQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectiveQuestionRepository extends JpaRepository<SubjectiveQuestion, Long> {
    SubjectiveQuestion save(SubjectiveQuestion subjectiveQuestion);
    Optional<SubjectiveQuestion> findBySurvey(Long id);

    SubjectiveQuestion findSubjectiveQuestionById(Long id);
}
