package kakao99.brainform.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import kakao99.brainform.entity.BrainwaveResult;
import kakao99.brainform.entity.QBrainwaveResult;
import kakao99.brainform.entity.QMemberSurvey;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class BrainWaveRepository {

    private final EntityManager em;
    private final JPAQueryFactory query;

    private QBrainwaveResult brainwaveResult = QBrainwaveResult.brainwaveResult;
    private QMemberSurvey memberSurvey = QMemberSurvey.memberSurvey;
    public BrainwaveResult save(BrainwaveResult brainwaveResult) {
        em.persist(brainwaveResult);
        return brainwaveResult;
    }

    public BrainwaveResult findByMemberIdAndSurveyId(Long surveyId, Long memberId) {
        return query
                .select(brainwaveResult)
                .from(memberSurvey)
                .where(memberSurvey.survey.id.eq(surveyId).and(memberSurvey.member.id.eq(memberId)))
                .fetchOne(); // 단일 결과를 반환하도록 수정
    }
}
