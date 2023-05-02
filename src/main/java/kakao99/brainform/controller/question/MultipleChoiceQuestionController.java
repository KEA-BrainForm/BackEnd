package kakao99.brainform.controller.question;

import kakao99.brainform.dto.MultiQuestionDto;
import kakao99.brainform.entity.question.MultipleChoiceQuestion;
import kakao99.brainform.service.question.MultipleChoiceQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/multiplechoicequestion")
public class MultipleChoiceQuestionController {
    @Autowired
    private MultipleChoiceQuestionService multipleChoiceQuestionService;

    @PostMapping
    public ResponseEntity<MultipleChoiceQuestion> createQuestion(@RequestBody MultiQuestionDto dto) {
        MultipleChoiceQuestion question = new MultipleChoiceQuestion();
        System.out.println("obj.id = " + dto.getId());
        System.out.println("obj.title = " + dto.getTitle());
        System.out.println("obj.type = " + dto.getType());
        System.out.println("obj.options = " + dto.getOptions());



        return ResponseEntity.ok(multipleChoiceQuestionService.createQuestion(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MultipleChoiceQuestion> getQuestion(@PathVariable Long id) {
        return ResponseEntity.of(multipleChoiceQuestionService.findById(id));
    }
}