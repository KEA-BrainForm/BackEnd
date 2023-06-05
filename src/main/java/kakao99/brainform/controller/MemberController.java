package kakao99.brainform.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

import kakao99.brainform.dto.TokenDTO;
import kakao99.brainform.dto.MemberRegisterDTO;

import kakao99.brainform.entity.Member;
import kakao99.brainform.repository.MemberRepository;
import kakao99.brainform.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberRepository memberRepository;

    private final MemberService memberService;

    private final ObjectMapper objectMapper;


    @SneakyThrows
    @PostMapping("/api/register")
    public ResponseEntity<?> register(@RequestBody @Validated MemberRegisterDTO dto,
                                      Authentication authentication,
                                      BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("값을 모두 입력해주세요", HttpStatus.BAD_REQUEST);
        }

        TokenDTO token = memberService.join(dto, authentication);

        return new ResponseEntity<>(token.getAccessToken(), HttpStatus.OK);
    }

    @PatchMapping("/api/patchmember")
    public ResponseEntity<?> updateMember(@RequestBody @Validated MemberRegisterDTO dto,
                                          Authentication authentication,
                                          BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("값을 모두 입력해주세요", HttpStatus.BAD_REQUEST);
        }

        try {
            Member updatedMember = memberService.update(dto, authentication);

            if(updatedMember != null) {
                return new ResponseEntity<>(updatedMember, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("회원 정보 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } catch(Exception e) {
            return new ResponseEntity<>("서버 에러", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/api/members")
    public Member getMember(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Map<String, Object> data = new HashMap<String, Object>();
        Member member = (Member) authentication.getPrincipal();
        System.out.println(member);

        return member;
    }
}

