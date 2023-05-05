package kakao99.brainform.repository;

import kakao99.brainform.dto.RefreshToken;
import kakao99.brainform.entity.MemberSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MemberSurveyRepository  extends JpaRepository<MemberSurvey, Long> {
    MemberSurvey findMemberSurveyByMemberId(Long memberId);
}
