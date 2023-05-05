package kakao99.brainform.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import kakao99.brainform.dto.TokenDTO;
import kakao99.brainform.dto.MemberRegisterDTO;

import kakao99.brainform.entity.BrainData;
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
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

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

    @PostMapping("/{id}/{code}/stop")
    public ResponseEntity<?> stopBrain(@PathVariable(name = "code") String code,
                                       @PathVariable(name = "id") Long surveyId,
                                       Authentication authentication,
                                       HttpServletRequest request) {

        //JWT 토큰에서 저장되어있는 유저 정보 가져오기
        Member member = (Member) authentication.getPrincipal();


        BrainMemberInfo brainMemberInfo = BrainMemberInfo.builder()
                .code(code)
                .surveyId(surveyId)
                .memberId(member.getId())
                .flag(false)
                .build();

        brainWaveCodeRepository.save(brainMemberInfo);

        return new ResponseEntity<>("설문 종료", HttpStatus.OK);
    }

    @PostMapping("/imgInfo")
    public BrainData postBrainData(@RequestParam("braindata") String brainData,
                                   @RequestParam("image") MultipartFile image) throws IOException {
        // byte 배열로 이미지 데이터 변환
        byte[] imageData = image.getBytes();
        BrainData brainDataObj = new ObjectMapper().readValue(brainData, BrainData.class);

        // BrainData 객체의 필드 값을 추출하여 변수에 저장
        String memberID = brainDataObj.getMemberId();
        String surveyId = brainDataObj.getSurveyId();

        // BrainData 객체 생성
        BrainData newBrainDataObj = BrainData.builder()
                .memberId(memberID)
                .surveyId(surveyId)
                .image(imageData)
                .build();

        byte[] img = newBrainDataObj.getImage();
        String filename = "C:\\Users\\USER\\Desktop\\설문조사 BE2\\BackEnd\\src\\main\\resources\\static" + memberID + "_"+surveyId+".png";
        // 바이트 배열로부터 BufferedImage 객체 생성
        InputStream in = new ByteArrayInputStream(img);
        BufferedImage bufferedImage = ImageIO.read(in);

        // BufferedImage 객체를 PNG 파일로 저장
        File outputfile = new File(filename);
        ImageIO.write(bufferedImage, "png", outputfile);
        return newBrainDataObj;
    }

}

