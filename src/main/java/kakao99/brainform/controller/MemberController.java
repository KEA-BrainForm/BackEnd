package kakao99.brainform.controller;

import kakao99.brainform.dto.MemberRegisterDTO;

import kakao99.brainform.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Validated @RequestBody MemberRegisterDTO dto) {

        memberService.register(dto);

        return new ResponseEntity<>("회원가입이 완료되었습니다.", HttpStatus.OK);
    }
}
