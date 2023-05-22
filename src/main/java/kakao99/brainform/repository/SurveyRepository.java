package kakao99.brainform.repository;

import kakao99.brainform.entity.Member;
import kakao99.brainform.entity.Survey;
import kakao99.brainform.entity.question.MultipleChoiceQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
    Survey save(Survey survey);

    Optional<Survey> findById(Long id);

    Survey findSurveyById(Long id);

    List<Survey> findAllByMember(Member member);

//    List<Survey> findByIdAndMember(Long surveyId, List<Member> jobs);

    List<Survey> findByMember_Job(String job);
}
