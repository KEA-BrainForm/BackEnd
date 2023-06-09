package kakao99.brainform.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kakao99.brainform.dto.*;
import kakao99.brainform.entity.Member;
import kakao99.brainform.entity.MemberSurvey;
import kakao99.brainform.entity.Survey;
import kakao99.brainform.entity.anwer.MultipleChoiceAnswer;
import kakao99.brainform.entity.question.MultipleChoiceQuestion;
import kakao99.brainform.entity.question.YesOrNoQuestion;
import kakao99.brainform.service.AnswerService;
import kakao99.brainform.service.MemberSurveyService;
import kakao99.brainform.service.QuestionService;
import kakao99.brainform.service.SurveyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SurveyController {

    private final QuestionService questionService;
    private final AnswerService answerService;
    private final MemberSurveyService memberSurveyService;
    private final SurveyService surveyService;
    private final ObjectMapper mapper;

    @GetMapping("/api/data")    //  생성한 설문지 조회
    public List<Survey> surveyManagement(Authentication authentication) {
        Member member = (Member) authentication.getPrincipal();
        List<Survey> allQuestionIMade = questionService.findAllSurveyIMade(member);

        return allQuestionIMade;
    }

    @GetMapping("/api/data/answered")   // 응답한 설문지 조회
    public List<Survey> ManagementAnsweredSurveyList(Authentication authentication) {
        Member member = (Member) authentication.getPrincipal();
        List<Survey> allSurveyIAnswered = questionService.findAllSurveyIAnswered(member);

        return allSurveyIAnswered;
    }

    @DeleteMapping("/api/survey/{id}")
    public ResponseEntity<?> deleteSurvey(
            @PathVariable(name = "id") Long id,
            Authentication authentication
    ) {
        try {

            Member member = (Member) authentication.getPrincipal();

            return surveyService.deleteSurvey(id, member);
        } catch (NullPointerException e) {
            return new ResponseEntity<>("토큰이 유효하지 않습니다.", HttpStatus.BAD_REQUEST);
        }
    }

    // surveyId에 해당하는 설문지의 통계 결과 가져오기
    @GetMapping("/api/statistic/surveys/{surveyId}")
    public Survey surveyStatistic(@PathVariable("surveyId") Long surveyId) {

//        Member member = (Member) authentication.getPrincipal();
        System.out.println("surveyId = " + surveyId);
        Survey questionOfSurvey = questionService.getSurveyStatistic(surveyId);

        return questionOfSurvey;
    }

    // filter 처리 컨트롤러 메소드
    @GetMapping("/api/statistic/surveys/filter")
    public Survey GetSurveyDataWithFilter(
            @RequestParam(value = "id", required = true) String surveyId,
            @RequestParam(value = "gender", required = false) List<String> genders,
            @RequestParam(value = "age", required = false) List<String> ages,
            @RequestParam(value = "job", required = false) List<String> jobs,
            @RequestParam(value = "isActive", required = false) String active) throws ChangeSetPersister.NotFoundException, JsonProcessingException {


        log.info("filter요청 들어옴");
        log.info("활성화 요청 파라미터={}", active);
        FilterDTO filterDTO = new FilterDTO(Long.parseLong(surveyId), genders, ages, jobs, active);
        log.info(mapper.writeValueAsString(filterDTO));
        Survey dataWithFilter = memberSurveyService.getDataWithFilter(filterDTO);
        log.info("resposne={}", mapper.writeValueAsString(dataWithFilter));

        return dataWithFilter;
    }
}
