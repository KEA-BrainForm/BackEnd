package kakao99.brainform.controller.answer;

import kakao99.brainform.entity.anwer.MultipleChoiceAnswer;
import kakao99.brainform.service.answer.MultipleChoiceAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/multiplechoiceanswer")
public class MultipleChoiceAnswerController {
    @Autowired
    private MultipleChoiceAnswerService multipleChoiceAnswerService;

    @PostMapping
    public ResponseEntity<MultipleChoiceAnswer> createAnswer(@RequestBody MultipleChoiceAnswer answer) {
        return ResponseEntity.ok(multipleChoiceAnswerService.createAnswer(answer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MultipleChoiceAnswer> getAnswer(@PathVariable Long id) {
        return ResponseEntity.of(multipleChoiceAnswerService.findById(id));
    }
}
