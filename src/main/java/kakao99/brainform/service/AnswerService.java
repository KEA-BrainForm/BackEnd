package kakao99.brainform.service;

import kakao99.brainform.dto.CreateAnswerInput;
import kakao99.brainform.dto.CreateQuestionInput;
import kakao99.brainform.dto.FilterDTO;
import kakao99.brainform.entity.Member;
import kakao99.brainform.entity.MemberSurvey;
import kakao99.brainform.entity.Survey;
import kakao99.brainform.entity.anwer.MultipleChoiceAnswer;
import kakao99.brainform.entity.anwer.SubjectiveAnswer;
import kakao99.brainform.entity.anwer.YesOrNoAnswer;
import kakao99.brainform.entity.question.MultipleChoiceQuestion;
import kakao99.brainform.entity.question.SubjectiveQuestion;
import kakao99.brainform.entity.question.YesOrNoQuestion;
import kakao99.brainform.repository.MemberSurveyRepository;
import kakao99.brainform.repository.SurveyRepository;
import kakao99.brainform.repository.answer.MultipleChoiceAnswerRepository;
import kakao99.brainform.repository.answer.SubjectiveAnswerRepository;
import kakao99.brainform.repository.answer.YesOrNoAnswerRepository;
import kakao99.brainform.repository.question.MultipleChoiceQuestionRepository;
import kakao99.brainform.repository.question.SubjectiveQuestionRepository;
import kakao99.brainform.repository.question.YesOrNoQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final MultipleChoiceAnswerRepository multipleChoiceAnswerRepository;
    private final MultipleChoiceQuestionRepository multipleChoiceQuestionRepository;
    private final SubjectiveAnswerRepository subjectiveAnswerRepository;
    private final SubjectiveQuestionRepository subjectiveQuestionRepository;
    private final YesOrNoAnswerRepository yesOrNoAnswerRepository;
    private final YesOrNoQuestionRepository yesOrNoQuestionRepository;
    private final MemberSurveyRepository memberSurveyRepository;
    private final SurveyRepository surveyRepository;

    public void createAns(ArrayList<CreateAnswerInput> questionList, MemberSurvey memberSurvey) {
        int length = questionList.toArray().length;


        for (int i = 0; i < length; i++) {
            Long questionId = questionList.get(i).getQuestionId();
            if (questionList.get(i).getType().equalsIgnoreCase("multipleChoiceQuestions")) {

//                MultipleChoiceAnswer multipleChoiceAnswer = new MultipleChoiceAnswer();
//                multipleChoiceAnswer.setAnswer(questionList.get(i).getAnswer());

                MultipleChoiceQuestion multipleChoiceQuestion = multipleChoiceQuestionRepository.findMultipleChoiceQuestionById(questionId);
                MultipleChoiceAnswer multipleChoiceAnswer = MultipleChoiceAnswer.builder()
                        .answer(questionList.get(i).getAnswer())
                        .multipleChoiceQuestion(multipleChoiceQuestion)
                        .memberSurvey(memberSurvey)
                        .build();
//                multipleChoiceAnswer.setMultipleChoiceQuestion(multipleChoiceQuestion);
//                multipleChoiceAnswer.setMemberSurvey(memberSurvey);
                multipleChoiceAnswerRepository.save(multipleChoiceAnswer);

            } else if (questionList.get(i).getType().equalsIgnoreCase("subjectiveQuestions")) {
//                SubjectiveAnswer subjectiveAnswer = new SubjectiveAnswer();
//                subjectiveAnswer.setAnswer(questionList.get(i).getAnswer());
                SubjectiveQuestion subjectiveQuestion = subjectiveQuestionRepository.findSubjectiveQuestionById(questionId);
                SubjectiveAnswer subjectiveAnswer = SubjectiveAnswer.builder()
                        .answer(questionList.get(i).getAnswer())
                        .subjectiveQuestion(subjectiveQuestion)
                        .memberSurvey(memberSurvey)
                        .build();
//                subjectiveAnswer.setSubjectiveQuestion(subjectiveQuestion);
//                subjectiveAnswer.setMemberSurvey(memberSurvey);
                subjectiveAnswerRepository.save(subjectiveAnswer);

            } else if (questionList.get(i).getType().equalsIgnoreCase("yesOrNoQuestions")) {
//                YesOrNoAnswer yesOrNoAnswer = new YesOrNoAnswer();
//                yesOrNoAnswer.setAnswer(Boolean.parseBoolean(questionList.get(i).getAnswer()));
                YesOrNoQuestion yesOrNoQuestion = yesOrNoQuestionRepository.findYesOrNoQuestionById(questionId);
//                yesOrNoAnswer.setYesOrNoQuestion(yesOrNoQuestion);
//                yesOrNoAnswer.setMemberSurvey(memberSurvey);

                YesOrNoAnswer yesOrNoAnswer = YesOrNoAnswer.builder()
                        .answer(Boolean.parseBoolean(questionList.get(i).getAnswer()))
                        .yesOrNoQuestion(yesOrNoQuestion)
                        .memberSurvey(memberSurvey)
                        .build();
                yesOrNoAnswerRepository.save(yesOrNoAnswer);
            }
        }

    }

}