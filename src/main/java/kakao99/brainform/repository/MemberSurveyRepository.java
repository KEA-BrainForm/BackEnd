package kakao99.brainform.repository;

import kakao99.brainform.dto.RefreshToken;
import kakao99.brainform.entity.MemberSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemberSurveyRepository  extends JpaRepository<MemberSurvey, Long> {
    MemberSurvey findMemberSurveyByMemberId(Long memberId);

//    @Query("SELECT s FROM MemberSurvey s JOIN s.member m WHERE m.job = :job")
    List<MemberSurvey> findMemberSurveyByMemberJobAndSurveyId(String job, Long surveyId);
}
