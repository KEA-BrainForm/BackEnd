package kakao99.brainform.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kakao99.brainform.dto.CreateQuestionDto;
import kakao99.brainform.dto.CreateQuestionInput;
import kakao99.brainform.entity.Member;
import kakao99.brainform.entity.Survey;
import kakao99.brainform.entity.question.MultipleChoiceQuestion;
import kakao99.brainform.entity.question.SubjectiveQuestion;
import kakao99.brainform.entity.question.YesOrNoQuestion;
import kakao99.brainform.repository.MemberSurveyRepository;
import kakao99.brainform.repository.question.MultipleChoiceQuestionRepository;
import kakao99.brainform.repository.question.SubjectiveQuestionRepository;
import kakao99.brainform.repository.SurveyRepository;
import kakao99.brainform.repository.question.YesOrNoQuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionService {
    private final MultipleChoiceQuestionRepository multipleChoiceQuestionRepository;
    private final YesOrNoQuestionRepository yesOrNoQuestionRepository;
    private final SubjectiveQuestionRepository subjectiveQuestionRepository;
    private final SurveyRepository surveyRepository;
    private final MemberSurveyRepository memberSurveyRepository;
    private final ObjectMapper mapper;
    public Survey createSurvey(CreateQuestionDto obj, Member member) {
        Survey survey = new Survey();
        survey.setId(obj.getSurveyId());
        survey.setIsOpen(obj.getVisibility());
        survey.setIsBrainwave(obj.getWearable());
        survey.setTitle(obj.getTitle());
        survey.setMember(member);

        return surveyRepository.save(survey);
    }
    public void createQuestion(Survey survey, List<CreateQuestionInput> questionList) {
        int length = questionList.toArray().length;

        for (int i = 0; i < length; i++) {
            if (questionList.get(i).getType().equalsIgnoreCase("multipleChoice")) {
                MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion();
                multipleChoiceQuestion.setSurvey(survey);
                multipleChoiceQuestion.setNum(questionList.get(i).getId());
                multipleChoiceQuestion.setQuestion(questionList.get(i).getTitle());
                List<Object> options = questionList.get(i).getOptions();
                String[] texts = new String[5];

                for (int j = 0; j < options.size() && j < 5; j++) {
                    texts[j] = ((Map<String, String>) ((List<?>) options).get(j)).get("text");
                }
                multipleChoiceQuestion.setChoice(texts[0], texts[1] , texts[2] , texts[3] , texts[4]);
                multipleChoiceQuestion.setCount(options.size());
                multipleChoiceQuestionRepository.save(multipleChoiceQuestion);

            } else if (questionList.get(i).getType().equalsIgnoreCase("shortAnswer")) {
                SubjectiveQuestion subjectiveQuestion = new SubjectiveQuestion();
                subjectiveQuestion.setSurvey(survey);
                subjectiveQuestion.setNum(questionList.get(i).getId());
                subjectiveQuestion.setQuestion(questionList.get(i).getTitle());
                subjectiveQuestionRepository.save(subjectiveQuestion);

            } else if (questionList.get(i).getType().equalsIgnoreCase("yesOrNo")) {
                YesOrNoQuestion yesOrNoQuestion = new YesOrNoQuestion();
                yesOrNoQuestion.setSurvey(survey);
                yesOrNoQuestion.setNum(questionList.get(i).getId());
                yesOrNoQuestion.setQuestion(questionList.get(i).getTitle());

                yesOrNoQuestionRepository.save(yesOrNoQuestion);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public Survey findQuestionById(Long id) {
        //surveyRepository.findById(survey_id);
        Optional<Survey> findSurvey = surveyRepository.findById(id);
        if (findSurvey.isPresent()) {
            return findSurvey.get();
        }
        return null;
}

    public List<Survey> findAllSurveyIMade(Member member) {
        List<Survey> allSurveyByMember = surveyRepository.findAllByMember(member);
        return allSurveyByMember;
    }

    public List<Survey> findAllSurveyIAnswered(Member member) {
        List<Survey> memberSurveyByMemberId = memberSurveyRepository.findMemberSurveyByMemberId(member.getId());
        log.info("응답 내용 개수={}",memberSurveyByMemberId.size());
        return memberSurveyByMemberId;
    }

    public Survey getSurveyStatistic(Long surveyId) {
        Optional<Survey> survey = surveyRepository.findById(surveyId);
        if (!survey.isPresent()) {
            // 에러 처리
        }
                return survey.get();

//        Survey survey = surveyRepository.findSurveyById(surveyId);
//        return survey;

    }
//    public MultipleChoiceQuestion getSurveyStatisticTest(Long surveyId) {
//
//        Optional<YesOrNoQuestion> bySurvey = yesOrNoQuestionRepository.findBySurveyId(surveyId);
//        Optional<MultipleChoiceQuestion> bySurveyId = multipleChoiceQuestionRepository.findBySurveyId(surveyId);
//        return bySurveyId.get();
//
//    }
}

