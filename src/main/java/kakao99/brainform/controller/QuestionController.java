package kakao99.brainform.controller;

import kakao99.brainform.dto.CreateQuestionDto;
import kakao99.brainform.dto.CreateQuestionInput;
import kakao99.brainform.entity.Survey;
import kakao99.brainform.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/api/new-question")
    public ResponseEntity<?> createQuestion(@RequestBody CreateQuestionDto obj) {
        System.out.println("obj.title = " + obj.getTitle());    // 설문 제목
        System.out.println("obj.getQuestionList = " + obj.getQuestionList());   // 객관식 - 보기 리스트
        System.out.println("obj.getVisibility = " + obj.getVisibility());   // 공개 여부
        System.out.println("obj.getWearable = " + obj.getWearable());       // 기기 착용 필수 여부

        List<CreateQuestionInput> questionList = obj.getQuestionList();

        Survey newSurvey = questionService.createSurvey(obj);
        questionService.createQuestion(newSurvey, questionList);

        return new ResponseEntity<>("설문 생성이 완료되었습니다.", HttpStatus.OK);
    }
}
