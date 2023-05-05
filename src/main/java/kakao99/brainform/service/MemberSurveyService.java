package kakao99.brainform.service;

import kakao99.brainform.entity.Member;
import kakao99.brainform.entity.MemberSurvey;
import kakao99.brainform.entity.Survey;
import kakao99.brainform.repository.MemberSurveyRepository;
import kakao99.brainform.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberSurveyService {

    private final SurveyRepository surveyRepository;
    private final MemberSurveyRepository memberSurveyRepository;

    public MemberSurvey createMemberSurvey(Member member, Long surveyId) {
        Survey survey = surveyRepository.findSurveyById(surveyId);  //
        MemberSurvey memberSurvey = new MemberSurvey();
        memberSurvey.setMember(member);
        memberSurvey.setSurvey(survey);

        return memberSurveyRepository.save(memberSurvey);
    }
}
