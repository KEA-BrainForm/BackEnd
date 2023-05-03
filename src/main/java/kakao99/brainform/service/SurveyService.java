package kakao99.brainform.service;

import kakao99.brainform.dto.CreateQuestionDto;
import kakao99.brainform.dto.CreateQuestionInput;
import kakao99.brainform.entity.Survey;
import kakao99.brainform.entity.question.MultipleChoiceQuestion;
import kakao99.brainform.entity.question.SubjectiveQuestion;
import kakao99.brainform.entity.question.YesOrNoQuestion;
import kakao99.brainform.repository.question.MultipleChoiceQuestionRepository;
import kakao99.brainform.repository.question.SubjectiveQuestionRepository;
import kakao99.brainform.repository.SurveyRepository;
import kakao99.brainform.repository.question.YesOrNoQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SurveyService {
    private final MultipleChoiceQuestionRepository multipleChoiceQuestionRepository;
    private final YesOrNoQuestionRepository yesOrNoQuestionRepository;
    private final SubjectiveQuestionRepository subjectiveQuestionRepository;
    private final SurveyRepository surveyRepository;

    public Survey createSurvey(CreateQuestionDto obj) {
        Survey survey = new Survey();
        survey.setIsOpen(obj.getVisibility());
        survey.setIsBrainwave(obj.getWearable());
        survey.setTitle(obj.getTitle());
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

    public Survey findSurveyById(Long id) {
        return surveyRepository.findSurveyById(id);
    }
}
