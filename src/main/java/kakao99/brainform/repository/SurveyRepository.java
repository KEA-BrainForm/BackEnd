package kakao99.brainform.repository;

import kakao99.brainform.entity.Member;
import kakao99.brainform.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
    Survey save(Survey survey);

    Optional<Survey> findSurveyById(Long id);

    List<Survey> findAllByMember(Member member);

//    List<Survey> findByIdAndMember(Long surveyId, List<Member> jobs);

    void deleteSurveyById(Long id);


}
