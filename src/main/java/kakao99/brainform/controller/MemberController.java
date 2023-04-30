package kakao99.brainform.controller;

import kakao99.brainform.dto.MemberLoginDTO;
import kakao99.brainform.dto.MemberRegisterDTO;

import kakao99.brainform.entity.Member;
import kakao99.brainform.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/register")
    public ResponseEntity<?> register(@RequestBody MemberRegisterDTO dto) {

        log.info(dto.toString());
        memberService.register(dto);

        return new ResponseEntity<>("회원가입이 완료되었습니다.", HttpStatus.OK);
    }

    @PostMapping("/user/login")
    public String login(@RequestBody MemberLoginDTO loginDTO) {

        log.info("로그인 시도");

        String token = memberService.login(loginDTO);

        log.info("로그인 완료");
        return token;
    }

    @GetMapping("/user/jwt")
    public Member memberInfo(Authentication authentication) {

        Member member = (Member) authentication.getPrincipal();

        return member;
    }
}
