package kakao99.brainform.controller;

import kakao99.brainform.dto.AnswerDTO;
import kakao99.brainform.dto.FilterDTO;
import kakao99.brainform.dto.QuestionDTO;
import kakao99.brainform.entity.Member;
import kakao99.brainform.entity.MemberSurvey;
import kakao99.brainform.entity.Survey;
import kakao99.brainform.entity.anwer.MultipleChoiceAnswer;
import kakao99.brainform.entity.question.MultipleChoiceQuestion;
import kakao99.brainform.entity.question.YesOrNoQuestion;
import kakao99.brainform.service.AnswerService;
import kakao99.brainform.service.MemberSurveyService;
import kakao99.brainform.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SurveyController {

    private final QuestionService questionService;
    private final AnswerService answerService;
    private final MemberSurveyService memberSurveyService;

    @GetMapping("/api/data")
    public List<Survey> surveyManagement(Authentication authentication) {
        Member member = (Member) authentication.getPrincipal();
        List<Survey> allQuestionIMade = questionService.findAllSurveyIMade(member);

        return allQuestionIMade;
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
    @PostMapping("/api/statistic/surveys/filter")
    public List<QuestionDTO> GetSurveyDataWithFilter(@RequestBody FilterDTO filterDTO) throws ChangeSetPersister.NotFoundException {
        System.out.println("filter요청 들어옴");

//        return memberSurveyService.getDataWithFilter(filterDTO);
        return memberSurveyService.getDataWithFilter(filterDTO);
//        return answerList;
}


}
