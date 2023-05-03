package kakao99.brainform.repository;

import kakao99.brainform.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
    Survey save(Survey survey);

    Survey findSurveyById(Long id);
}
