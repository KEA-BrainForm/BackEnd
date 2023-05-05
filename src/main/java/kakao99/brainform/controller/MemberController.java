package kakao99.brainform.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import kakao99.brainform.dto.TokenDTO;
import kakao99.brainform.dto.MemberRegisterDTO;

import kakao99.brainform.entity.BrainMemberInfo;
import kakao99.brainform.entity.Member;
import kakao99.brainform.entity.Survey;
import kakao99.brainform.repository.BrainWaveCodeRepository;
import kakao99.brainform.repository.SurveyRepository;
import kakao99.brainform.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;
    private final BrainWaveCodeRepository brainWaveCodeRepository;

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


    /*
    * 설문 응답하기 전에 입력할 코드 세션에 저장
    * */
    @PostMapping("/{id}/{code}")
    public ResponseEntity<?> getBrainCode(@PathVariable(name = "code") String code,
                               @PathVariable(name = "id") Long surveyId,
                               Authentication authentication,
                               HttpServletRequest request) {

        //JWT 토큰에서 저장되어있는 유저 정보 가져오기
        Member member = (Member) authentication.getPrincipal();


        BrainMemberInfo brainMemberInfo = BrainMemberInfo.builder()
                .code(code)
                .surveyId(surveyId)
                .memberId(member.getId())
                .flag(true)
                .build();

        brainWaveCodeRepository.save(brainMemberInfo);

        return new ResponseEntity<>("설문을 시작해주세요", HttpStatus.OK);
    }

    @GetMapping("/userInfo/{code}")
    public BrainMemberInfo sendMemberInfo(@PathVariable(name = "code") String code,
                                          HttpServletRequest request) throws JsonProcessingException {

        log.info(code);
        BrainMemberInfo brainMemberInfo = brainWaveCodeRepository.findByCode(code);
        String s = objectMapper.writeValueAsString(brainMemberInfo);
        log.info(s);

        return brainMemberInfo;
    }
}

