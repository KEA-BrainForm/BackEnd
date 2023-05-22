package kakao99.brainform.service;

import kakao99.brainform.dto.AnswerDTO;
import kakao99.brainform.dto.FilterDTO;
import kakao99.brainform.dto.QuestionDTO;
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
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberSurveyService {

    private final SurveyRepository surveyRepository;
    private final MemberSurveyRepository memberSurveyRepository;
    private final QuestionService questionService;
    private final YesOrNoQuestionRepository yesOrNoQuestionRepository;
    private final MultipleChoiceQuestionRepository multipleChoiceQuestionRepository;
    private final SubjectiveQuestionRepository subjectiveQuestionRepository;
    private final MemberRepository memberRepository;
    public MemberSurvey createMemberSurvey(Member member, Long surveyId) {
        Survey survey = surveyRepository.findSurveyById(surveyId);  //
        MemberSurvey memberSurvey = new MemberSurvey();
        memberSurvey.setMember(member);
        memberSurvey.setSurvey(survey);

        return memberSurveyRepository.save(memberSurvey);
    }

    public List<QuestionDTO> getDataWithFilter(FilterDTO filterDTO) {
        System.out.println("filterDTO = " + filterDTO);
        System.out.println("filterDTO.getAges() = " + filterDTO.getAges());
        System.out.println("filterDTO.getOccupations() = " + filterDTO.getOccupations());
        System.out.println("filterDTO.getGenders() = " + filterDTO.getGenders());
        System.out.println("filterDTO.getSurveyId() = " + filterDTO.getSurveyId());
        System.out.println("filterDTO.getOccupations().toString().get(0): "+ filterDTO.getOccupations().get(0));
        System.out.println("filterDTO.getOccupations().toString().get(0): "+ filterDTO.getOccupations().get(0).getClass().getName());

        Long surveyId = Long.valueOf(filterDTO.getSurveyId());

        Survey surveyById = surveyRepository.findSurveyById(surveyId);
        List<MultipleChoiceQuestion> multipleChoiceQuestions = surveyById.getMultipleChoiceQuestions();

        // 직업 1개 처리 코드
        List<MemberSurvey> memberSurveys = memberSurveyRepository.findMemberSurveyByMemberJobAndSurveyId(filterDTO.getOccupations().get(0), surveyId);
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        for (MemberSurvey memberSurvey : memberSurveys) {

            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO.setSurveyeeId(memberSurvey.getMember().getId());
            questionDTO.setMultipleChoiceQuestions(multipleChoiceQuestions);

            System.out.println("MultipleDChoice Answers:");
            for (MultipleChoiceAnswer answer : memberSurvey.getMultipleChoiceAnswers()) {
                questionDTO.setId(answer.getMultipleChoiceQuestion().getId());
                questionDTO.setNum(answer.getMultipleChoiceQuestion().getNum());
                questionDTO.setMultipleChoiceAnswers(memberSurvey.getMultipleChoiceAnswers());
            }

            // Print subjectiveAnswers
            System.out.println("Subjective Answers:");
            for (SubjectiveAnswer answer : memberSurvey.getSubjectiveAnswers()) {
                questionDTO.setId(answer.getSubjectiveQuestion().getId());
                questionDTO.setNum(answer.getSubjectiveQuestion().getNum());
                questionDTO.setSubjectiveAnswers(memberSurvey.getSubjectiveAnswers());
            }

            // Print yesOrNoAnswers
            System.out.println("Yes/No Answers:");
            for (YesOrNoAnswer answer : memberSurvey.getYesOrNoAnswers()) {
                questionDTO.setId(answer.getYesOrNoQuestion().getId());
                questionDTO.setNum(answer.getYesOrNoQuestion().getNum());
                questionDTO.setYesOrNoAnswers(memberSurvey.getYesOrNoAnswers());

            }
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
