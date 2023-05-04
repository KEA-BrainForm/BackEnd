package kakao99.brainform.controller;

import kakao99.brainform.dto.CreateQuestionDto;

import kakao99.brainform.dto.CreateQuestionInput;
import kakao99.brainform.entity.Survey;
import kakao99.brainform.entity.question.MultipleChoiceQuestion;
import kakao99.brainform.entity.question.SubjectiveQuestion;
import kakao99.brainform.entity.question.YesOrNoQuestion;
import kakao99.brainform.service.QuestionService;
import kakao99.brainform.repository.question.MultipleChoiceQuestionRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/api/new-question")
    public ResponseEntity<?> createQuestion(@RequestBody CreateQuestionDto obj) {
        System.out.println("obj.questionNum = " + obj.getTitle());    // 설문 제목
        System.out.println("obj.getQuestionList = " + obj.getQuestionList());   // 객관식 - 보기 리스트
        System.out.println("obj.getVisibility = " + obj.getVisibility());   // 공개 여부
        System.out.println("obj.getWearable = " + obj.getWearable());       // 기기 착용 필수 여부
        System.out.println("obj.getSurveyId = " + obj.getSurveyId());
        List<CreateQuestionInput> questionList = obj.getQuestionList();

        Survey newSurvey = questionService.createSurvey(obj);
        questionService.createQuestion(newSurvey, questionList);

        return new ResponseEntity<>("설문 생성이 완료되었습니다.", HttpStatus.OK);
    }

//    @GetMapping("/api/ques/{id}")
//    public ResponseEntity<Survey> findById(@PathVariable("id") Long id) {
//        return questionService.findById(id)
//                .map(survey -> ResponseEntity.ok(survey))
//                .orElse(ResponseEntity.notFound().build());
//    }

    @GetMapping("/api/ques/{survey_id}")
    public Survey findQuestionById(@PathVariable("survey_id") Long survey_id) {
        Survey responseSurvey = questionService.findQuestionById(survey_id);
        return responseSurvey;
//        if (!responseSurvey.equals(null)) {
//            return new ResponseEntity<>(responseSurvey, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
//        }
    }

//    @ExceptionHandler(IllegalStateException.class)
//    public ResponseEntity<String> handleIllegalStateException(IllegalStateException ex) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + ex.getMessage());
//    }
//
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + ex.getMessage());
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleException(Exception ex) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + ex.getMessage());
//    }




}



