package kakao99.brainform.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import kakao99.brainform.entity.Member;
import kakao99.brainform.entity.MemberSurvey;
import kakao99.brainform.entity.Survey;
import kakao99.brainform.entity.question.MultipleChoiceQuestion;
import kakao99.brainform.entity.question.SubjectiveQuestion;
import kakao99.brainform.entity.question.YesOrNoQuestion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class SurveyDTO {

    private Long id;

    private String title;

    private String isOpen;

    private String isBrainwave;

    private Date answerPeriod;

    private Date createdAt;

    private Date updatedAt;

    private Member member;

    private List<YesOrNoQuestion> yesOrNoQuestions;

    private List<MultipleChoiceQuestion> multipleChoiceQuestions;

    private List<SubjectiveQuestion> subjectiveQuestions;

    public SurveyDTO toDTO(Survey survey) {
        this.id = survey.getId();
        this.title = survey.getTitle();
        this.isBrainwave = survey.getIsBrainwave();
        this.answerPeriod = survey.getAnswerPeriod();
        this.createdAt = survey.getCreatedAt();
        this.updatedAt = survey.getUpdatedAt();
        this.member = survey.getMember();
        this.yesOrNoQuestions = survey.getYesOrNoQuestions();
        this.multipleChoiceQuestions = survey.getMultipleChoiceQuestions();
        this.subjectiveQuestions = survey.getSubjectiveQuestions();

        return this;
    }

    public SurveyDTO filterQuestions(MemberSurvey memberSurvey) {
        log.info("filterQuestions 메소드 실행");
        this.multipleChoiceQuestions = this.multipleChoiceQuestions.stream().map(
                question -> {
                    question.filterAnswer(memberSurvey.getMultipleChoiceAnswers());
                    return question;
                }).collect(Collectors.toList());

        this.yesOrNoQuestions = this.yesOrNoQuestions.stream().map(
                question -> {
                    question.filterAnswer(memberSurvey.getYesOrNoAnswers());
                    return question;
                }).collect(Collectors.toList());

        this.subjectiveQuestions = this.subjectiveQuestions.stream().map(
                question -> {
                    question.filterAnswer(memberSurvey.getSubjectiveAnswers());
                    return question;
                }).collect(Collectors.toList());

        return this;
    }
}
