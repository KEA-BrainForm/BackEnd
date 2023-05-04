package kakao99.brainform.controller;
import kakao99.brainform.dto.CreateQuestionDto;
import kakao99.brainform.dto.CreateQuestionInput;
import kakao99.brainform.entity.Survey;
import kakao99.brainform.service.SurveyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SurveyController {

    private final SurveyService surveyService;

    @PostMapping("/api/new-question")
    public ResponseEntity<?> createSurvey(@RequestBody CreateQuestionDto obj) {
        log.info("설문지 생성 요청");
        System.out.println("obj.title = " + obj.getTitle());    // 설문 제목
        System.out.println("obj.getQuestionList = " + obj.getQuestionList());   // 객관식 - 보기 리스트
        System.out.println("obj.getVisibility = " + obj.getVisibility());   // 공개 여부
        System.out.println("obj.getWearable = " + obj.getWearable());       // 기기 착용 필수 여부
        System.out.println("obj.getSurveyId = " + obj.getSurveyId());
        List<CreateQuestionInput> questionList = obj.getQuestionList();

        Survey newSurvey = surveyService.createSurvey(obj);
        surveyService.createQuestion(newSurvey, questionList);

        return new ResponseEntity<>("설문 생성이 완료되었습니다.", HttpStatus.OK);
    }

    @GetMapping("/api/ques/{surveyId}")
    public ResponseEntity<?> findQuestionById(@PathVariable("surveyId") Long surveyId) {
        Survey responseSurvey = surveyService.findQuestionById(surveyId);

        if (!responseSurvey.equals(null)) {
            return new ResponseEntity<>(responseSurvey, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
        }
    }
}



