//package kakao99.brainform.controller.question;
//
//import kakao99.brainform.entity.question.SubjectiveQuestion;
//import kakao99.brainform.service.question.SubjectiveQuestionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/subjectivequestion")
//public class SubjectiveQuestionController {
//    @Autowired
//    private SubjectiveQuestionService subjectiveQuestionService;
//
//    @PostMapping
//    public ResponseEntity<SubjectiveQuestion> createQuestion(@RequestBody SubjectiveQuestion question) {
//        return ResponseEntity.ok(subjectiveQuestionService.createQuestion(question));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<SubjectiveQuestion> getQuestionById(@PathVariable Long id) {
//        Optional<SubjectiveQuestion> question = subjectiveQuestionService.findById(id);
//        return question.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//}
