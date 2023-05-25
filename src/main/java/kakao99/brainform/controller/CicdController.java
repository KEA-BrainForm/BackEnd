package kakao99.brainform.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CicdController {

    @GetMapping("/cicd/first")
    public String first() {
        return "You've succeeded in deploying.";
        //
    }
}
