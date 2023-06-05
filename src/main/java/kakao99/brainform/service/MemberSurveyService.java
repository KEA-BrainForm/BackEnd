package kakao99.brainform.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import kakao99.brainform.dto.*;
import kakao99.brainform.entity.Member;
import kakao99.brainform.entity.MemberSurvey;
import kakao99.brainform.entity.Survey;
import kakao99.brainform.entity.anwer.MultipleChoiceAnswer;
import kakao99.brainform.entity.anwer.SubjectiveAnswer;
import kakao99.brainform.entity.anwer.YesOrNoAnswer;
import kakao99.brainform.entity.question.MultipleChoiceQuestion;
import kakao99.brainform.entity.question.SubjectiveQuestion;
import kakao99.brainform.entity.question.YesOrNoQuestion;
import kakao99.brainform.repository.MemberRepository;
import kakao99.brainform.repository.MemberSurveyRepository;
import kakao99.brainform.repository.SurveyRepository;
import kakao99.brainform.repository.question.MultipleChoiceQuestionRepository;
import kakao99.brainform.repository.question.SubjectiveQuestionRepository;
import kakao99.brainform.repository.question.YesOrNoQuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberSurveyService {

    private final SurveyRepository surveyRepository;
    private final MemberSurveyRepository memberSurveyRepository;
    private final QuestionService questionService;
    private final YesOrNoQuestionRepository yesOrNoQuestionRepository;
    private final MultipleChoiceQuestionRepository multipleChoiceQuestionRepository;
    private final SubjectiveQuestionRepository subjectiveQuestionRepository;
    private final MemberRepository memberRepository;
    private final ObjectMapper mapper;
    private final EntityManager em;
    public MemberSurvey createMemberSurvey(Member member, Long surveyId) {
        Survey survey = surveyRepository.findSurveyById(surveyId).get();  //
        MemberSurvey memberSurvey = new MemberSurvey();
        memberSurvey.setMember(member);
        memberSurvey.setSurvey(survey);

        return memberSurveyRepository.save(memberSurvey);
    }

    @Transactional
    public Survey getDataWithFilter(FilterDTO filterDTO) throws JsonProcessingException {

        log.info("필터링 진입");
        Survey surveyById = surveyRepository.findSurveyById(filterDTO.getSurveyId()).get();

        log.info("필터링 진행");
        List<MemberSurvey> memberSurveyFilter = memberSurveyRepository.getMemberSurveyFilter(filterDTO);
        //log.info("필터링 길이={}",memberSurveyFilter.get(0).getMember().getUsername());

        AnswerDTO answerDTO = new AnswerDTO();
        for (MemberSurvey memberSurvey : memberSurveyFilter) {

            log.info("응답 내용={}",memberSurvey.getMultipleChoiceAnswers().size());
            answerDTO.updateAnswer(memberSurvey);
        }

        String answerDTOtoString = mapper.writeValueAsString(answerDTO);
        log.info("응답 내용 통합={}", answerDTOtoString);

        log.info("필터링 완료");
        Survey survey = surveyById.filterQuestions(answerDTO);


        log.info("필터링 된 dto={}", mapper.writeValueAsString(survey));

        return survey;
    }
}
