package kakao99.brainform.controller;

import kakao99.brainform.dto.CreateQuestionDto;

import kakao99.brainform.dto.CreateQuestionInput;
import kakao99.brainform.dto.MemberRegisterDTO;
import kakao99.brainform.dto.PatchQuestoinDTO;
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
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

    @PatchMapping("/api/patchQuestion/{survey_id}")
    public ResponseEntity<?> updateQuestion(@PathVariable("survey_id") Long survey_id,@RequestBody PatchQuestoinDTO obj,
                                          Authentication authentication,
                                          BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("값을 모두 입력해주세요", HttpStatus.BAD_REQUEST);
        }

        System.out.println("obj.questionNum = " + obj.getTitle());    // 설문 제목
        System.out.println("obj.getQuestionList = " + obj.getQuestionList());   // 객관식 - 보기 리스트
        System.out.println("obj.getSavedquestionList = " + obj.getSavedquestionList());
        System.out.println("obj.getVisibility = " + obj.getVisibility());   // 공개 여부
        System.out.println("obj.getWearable = " + obj.getWearable());       // 기기 착용 필수 여부
        System.out.println("obj.getSurveyId = " + obj.getSurveyId());

        System.out.println("obj.getNumDeleteList = " + obj.getNumDeleteList());       // 삭제할 문항 리스트

        List<CreateQuestionInput> questionList = obj.getQuestionList();
        //JWT 토큰에서 저장되어있는 유저 정보 가져오기
        Member member = (Member) authentication.getPrincipal();
        System.out.println("member.getId() = " + member.getId());
        System.out.println("member.getNickname() = " + member.getNickname());

        try {
            Survey newSurvey = questionService.createSurvey(obj, member, survey_id);
            questionService.createQuestion(newSurvey, questionList); // 수정화면에서 새로 만든 문항

            Survey updatedSurvey = questionService.update(obj, authentication, survey_id);
            questionService.delete(survey_id, obj.getNumDeleteList());
            return new ResponseEntity<>(updatedSurvey.getId(), HttpStatus.OK);
        } catch (UsernameNotFoundException e) {
            return new ResponseEntity<>("Survey not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace(); // add this line
            return new ResponseEntity<>("Server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}





