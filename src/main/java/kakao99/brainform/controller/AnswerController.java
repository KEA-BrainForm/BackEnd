package kakao99.brainform.controller;

import kakao99.brainform.dto.CreateAnswerDto;

import kakao99.brainform.dto.CreateAnswerInput;
import kakao99.brainform.dto.CreateQuestionInput;
import kakao99.brainform.entity.Survey;
import kakao99.brainform.entity.question.MultipleChoiceQuestion;
import kakao99.brainform.entity.question.SubjectiveQuestion;
import kakao99.brainform.entity.question.YesOrNoQuestion;
import kakao99.brainform.service.AnswerService;
import kakao99.brainform.service.QuestionService;
import kakao99.brainform.repository.question.MultipleChoiceQuestionRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService; // Add this line

    @PostMapping("/api/answer")
    public ResponseEntity<?> createAns(@RequestBody CreateAnswerDto obj) {

        System.out.println("obj.surveyId = " + obj.getSurveyId());    // 설문 제목
        System.out.println("obj.answer = " + obj.getAnswers());   // 객관식 - 보기 리스트
        // System.out.println("obj.type = " + obj.getType());   // 공개 여부
        ArrayList questionList = obj.getAnswers();
//        //int SurveyId = obj.getSurveyId();
        answerService.createAns(questionList); // Change this line
        return new ResponseEntity<>("설문 응답이 제출되었습니다.", HttpStatus.OK);

    }
}
