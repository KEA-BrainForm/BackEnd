package kakao99.brainform.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import kakao99.brainform.dto.BrainDataDTO;
import kakao99.brainform.entity.BrainMemberInfo;
import kakao99.brainform.entity.Member;
import kakao99.brainform.repository.BrainWaveCodeRepository;
import kakao99.brainform.service.BrainWaveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@RestController
@Slf4j
@RequiredArgsConstructor
public class BrainWaveController {
    private final ChatController chatController;
    private final BrainWaveCodeRepository brainWaveCodeRepository;
    private final BrainWaveService brainWaveService;

    /**
     * 설문 응답 전 뇌파 측정 코드, 설문 pk, 유저 정보 메모리에 저장
     * @param code: 뇌파 측정 코드
     * @param surveyId: Survey 엔티티 PK
     * @param authentication: 측정하는 사용자 JWT 토큰
     * @return 저장이 완료 되었으면 설문 시작
     */
    @PostMapping("/api/{id}/{code}")
    public ResponseEntity<?> getBrainCode(@PathVariable(name = "code") String code,
                                          @PathVariable(name = "id") Long surveyId,
                                          Authentication authentication) {

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


    /**
     * 뇌파를 측정하면서 설문 응답중인지 체크
     * @param code: 뇌파 측정 코드
     * @return 뇌파 측정 코드, Survey ID, Member ID, flag
     */
    @GetMapping("/api/userInfo/{code}")
    public BrainMemberInfo sendMemberInfo(@PathVariable(name = "code") String code) {

        BrainMemberInfo brainMemberInfo = brainWaveCodeRepository.findByCode(code).get();

        return brainMemberInfo;
    }


    /**
     * 설문 종료 후 뇌파 정보 저장
     * @param brainData: 집중도 평균, 안정도 평균
     * @param image:
     * @return 저장이 완료되면 설문 응답 종료
     * @throws IOException
     */
    @PostMapping("api/imgInfo")
    public BrainDataDTO postBrainData(@RequestParam("braindata") String brainData,
                                      @RequestParam("image") MultipartFile image) throws IOException {

        log.info("뇌파 이미지={}", image.getOriginalFilename());
        BrainDataDTO brainDataDTO = new ObjectMapper().readValue(brainData, BrainDataDTO.class);
        brainDataDTO.setImage(image);
        log.info("뇌파 이미지={}", brainDataDTO.getImage().getOriginalFilename());
        ResponseEntity<?> response = chatController.sendFinished(); // 소켓으로 완료 요청 보냄
        System.out.println("response 내용: " + response);
        brainWaveService.saveBrainWave(brainDataDTO);

        return brainDataDTO;
    }


    @PostMapping("api/{id}/{code}/stop")
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

        log.info("뇌파 측정 종료");
        return new ResponseEntity<>("설문 종료", HttpStatus.OK);
    }
}
