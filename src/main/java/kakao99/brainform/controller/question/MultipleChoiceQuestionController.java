//package kakao99.brainform.controller.question;
//
//import kakao99.brainform.entity.question.MultipleChoiceQuestion;
//import kakao99.brainform.service.question.MultipleChoiceQuestionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/multiplechoicequestion")
//public class MultipleChoiceQuestionController {
//    @Autowired
//    private MultipleChoiceQuestionService multipleChoiceQuestionService;
//
//    @PostMapping
//    public ResponseEntity<MultipleChoiceQuestion> createQuestion(@RequestBody MultipleChoiceQuestion question) {
//        return ResponseEntity.ok(multipleChoiceQuestionService.createQuestion(question));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<MultipleChoiceQuestion> getQuestion(@PathVariable Long id) {
//        return ResponseEntity.of(multipleChoiceQuestionService.findById(id));
//    }
//}
