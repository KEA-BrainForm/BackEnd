package kakao99.brainform.controller.answer;

import kakao99.brainform.entity.anwer.YesOrNoAnswer;
import kakao99.brainform.service.answer.YesOrNoAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/yesornoanswer")
public class YesOrNoAnswerController {
    @Autowired
    private YesOrNoAnswerService yesOrNoAnswerService;
    @GetMapping("/{id}")
    public ResponseEntity<YesOrNoAnswer> getAnswerById(@PathVariable Long id) {
        Optional<YesOrNoAnswer> answer = yesOrNoAnswerService.findById(id);
        if (answer.isPresent()) {
            return ResponseEntity.ok(answer.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<YesOrNoAnswer> createAnswer(@RequestBody YesOrNoAnswer answer) {
        return ResponseEntity.ok(yesOrNoAnswerService.createAnswer(answer));
    }



//    @GetMapping("/get")
//    public ResponseEntity<String> test() {
//        System.out.println("GET 요청이 들어왔습니다.");
//        return ResponseEntity.ok("Hello, this is the test endpoint for YesOrNoAnswerController!");
//    }
}
