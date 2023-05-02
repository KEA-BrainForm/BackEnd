package kakao99.brainform.repository.answer;

import kakao99.brainform.entity.anwer.SubjectiveAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectiveAnswerRepository extends JpaRepository<SubjectiveAnswer, Long> {
}
