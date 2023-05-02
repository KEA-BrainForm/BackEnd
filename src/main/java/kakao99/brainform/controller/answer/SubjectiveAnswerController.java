package kakao99.brainform.controller.answer;

import kakao99.brainform.entity.anwer.SubjectiveAnswer;
import kakao99.brainform.service.answer.SubjectiveAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subjectiveanswer")
public class SubjectiveAnswerController {
    @Autowired
    private SubjectiveAnswerService subjectiveAnswerService;

    @PostMapping
    public ResponseEntity<SubjectiveAnswer> createAnswer(@RequestBody SubjectiveAnswer answer) {
        return ResponseEntity.ok(subjectiveAnswerService.createAnswer(answer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectiveAnswer> getAnswer(@PathVariable Long id) {
        return ResponseEntity.of(subjectiveAnswerService.findById(id));
    }
}
