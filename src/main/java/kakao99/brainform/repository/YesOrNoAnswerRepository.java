package kakao99.brainform.repository;

import kakao99.brainform.entity.anwer.YesOrNoAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface YesOrNoAnswerRepository extends JpaRepository<YesOrNoAnswer, Long> {
    Optional<YesOrNoAnswer> findById(Long id);

}
