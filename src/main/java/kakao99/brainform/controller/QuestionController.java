package kakao99.brainform.controller;

import kakao99.brainform.dto.CreateQuestionDto;

import kakao99.brainform.dto.CreateQuestionInput;
import kakao99.brainform.entity.Member;
import kakao99.brainform.entity.Survey;
import kakao99.brainform.entity.question.MultipleChoiceQuestion;
import kakao99.brainform.entity.question.SubjectiveQuestion;
import kakao99.brainform.entity.question.YesOrNoQuestion;
import kakao99.brainform.service.QuestionService;
import kakao99.brainform.repository.question.MultipleChoiceQuestionRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    // 설문 생성 컨트롤러
    @PostMapping("/api/new-question")
    public ResponseEntity<?> createQuestion(@RequestBody CreateQuestionDto obj, Authentication authentication) {
        System.out.println("obj.questionNum = " + obj.getTitle());    // 설문 제목
        System.out.println("obj.getQuestionList = " + obj.getQuestionList());   // 객관식 - 보기 리스트
        System.out.println("obj.getVisibility = " + obj.getVisibility());   // 공개 여부
        System.out.println("obj.getWearable = " + obj.getWearable());       // 기기 착용 필수 여부
        System.out.println("obj.getSurveyId = " + obj.getSurveyId());
        List<CreateQuestionInput> questionList = obj.getQuestionList();
        //JWT 토큰에서 저장되어있는 유저 정보 가져오기
        Member member = (Member) authentication.getPrincipal();
        System.out.println("member.getId() = " + member.getId());
        System.out.println("member.getNickname() = " + member.getNickname());

        Survey newSurvey = questionService.createSurvey(obj, member);
        questionService.createQuestion(newSurvey, questionList);

        return new ResponseEntity<>(newSurvey.getId(), HttpStatus.OK);
    }

    // survey_id에 해당하는 설문지의 질문들 가져오는 컨트롤러
    @GetMapping("/api/ques/{survey_id}")
    public Survey findQuestionById(@PathVariable("survey_id") Long survey_id) {
        Survey responseSurvey = questionService.findQuestionById(survey_id);
        return responseSurvey;
//        if (!responseSurvey.equals(null)) {
//            return new ResponseEntity<>(responseSurvey, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
//        }
    }



}



