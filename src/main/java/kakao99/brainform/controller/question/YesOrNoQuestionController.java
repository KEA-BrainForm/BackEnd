package kakao99.brainform.controller.question;

import kakao99.brainform.entity.question.YesOrNoQuestion;
import kakao99.brainform.service.question.YesOrNoQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions/yesorno")
public class YesOrNoQuestionController {
    @Autowired
    private YesOrNoQuestionService yesOrNoQuestionService;

    @PostMapping
    public ResponseEntity<YesOrNoQuestion> createQuestion(@RequestBody YesOrNoQuestion question) {
        return ResponseEntity.ok(yesOrNoQuestionService.createQuestion(question));
    }

    @GetMapping("/{id}")
    public ResponseEntity<YesOrNoQuestion> getQuestionById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(yesOrNoQuestionService.getQuestionById(id));
    }

    @GetMapping("/survey/{surveyId}")
    public ResponseEntity<List<YesOrNoQuestion>> getQuestionsBySurveyId(@PathVariable("surveyId") Long surveyId) {
        return ResponseEntity.ok(yesOrNoQuestionService.getQuestionsBySurveyId(surveyId));
    }
}
