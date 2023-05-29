package kakao99.brainform.dto;

import kakao99.brainform.entity.Member;
import kakao99.brainform.entity.MemberSurvey;
import kakao99.brainform.entity.Survey;
import kakao99.brainform.entity.anwer.MultipleChoiceAnswer;
import kakao99.brainform.entity.anwer.SubjectiveAnswer;
import kakao99.brainform.entity.anwer.YesOrNoAnswer;

import kakao99.brainform.entity.question.MultipleChoiceQuestion;
import kakao99.brainform.entity.question.SubjectiveQuestion;
import kakao99.brainform.entity.question.YesOrNoQuestion;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SurveyFilterResultDTO {

    private Long id;

    private Member member;

    private List<YesOrNoAnswer> yesOrNoAnswers;

    private List<MultipleChoiceAnswer> multipleChoiceAnswers;

    private List<SubjectiveAnswer> subjectiveAnswers;

//    public SurveyFilterResultDTO toDTO(MemberSurvey survey) {
//        this.id = survey.getId();
//        this.multipleChoiceAnswers = survey.getMultipleChoiceAnswers();
//        this.subjectiveAnswers = survey.getSubjectiveAnswers();
//        this.yesOrNoAnswers = survey.getYesOrNoAnswers();
//        return this;
//    }
}
