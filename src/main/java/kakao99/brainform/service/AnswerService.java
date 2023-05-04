package kakao99.brainform.service;

import kakao99.brainform.dto.CreateAnswerInput;
import kakao99.brainform.dto.CreateQuestionInput;
import kakao99.brainform.entity.anwer.MultipleChoiceAnswer;
import kakao99.brainform.entity.anwer.SubjectiveAnswer;
import kakao99.brainform.entity.anwer.YesOrNoAnswer;
import kakao99.brainform.entity.question.MultipleChoiceQuestion;
import kakao99.brainform.entity.question.SubjectiveQuestion;
import kakao99.brainform.entity.question.YesOrNoQuestion;
import kakao99.brainform.repository.answer.MultipleChoiceAnswerRepository;
import kakao99.brainform.repository.answer.SubjectiveAnswerRepository;
import kakao99.brainform.repository.answer.YesOrNoAnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final MultipleChoiceAnswerRepository multipleChoiceAnswerRepository;
    private final SubjectiveAnswerRepository subjectiveAnswerRepository;
    private final YesOrNoAnswerRepository yesOrNoAnswerRepository;

    public void createAns(   ArrayList<CreateAnswerInput> questionList) {
        int length = questionList.toArray().length;

        for (int i = 0; i < length; i++) {
            if (questionList.get(i).getType().equalsIgnoreCase("multipleChoiceQuestions")) {

                MultipleChoiceAnswer multipleChoiceAnswer = new MultipleChoiceAnswer();
                multipleChoiceAnswer.setAnswer(questionList.get(i).getAnswer());

                multipleChoiceAnswerRepository.save(multipleChoiceAnswer);

            } else if (questionList.get(i).getType().equalsIgnoreCase("subjectiveQuestions")) {
                SubjectiveAnswer subjectiveAnswer = new SubjectiveAnswer();
                subjectiveAnswer.setAnswer(questionList.get(i).getAnswer());

                subjectiveAnswerRepository.save(subjectiveAnswer);

            } else if (questionList.get(i).getType().equalsIgnoreCase("yesOrNoQueQuestions")) {
                YesOrNoAnswer yesOrNoAnswer = new YesOrNoAnswer();
                yesOrNoAnswer.setAnswer(Boolean.parseBoolean(questionList.get(i).getAnswer()));

                yesOrNoAnswerRepository.save(yesOrNoAnswer);

            }
        }}}