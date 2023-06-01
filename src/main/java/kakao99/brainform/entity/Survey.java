package kakao99.brainform.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import kakao99.brainform.dto.AnswerDTO;
import kakao99.brainform.dto.SurveyFilterResultDTO;
import kakao99.brainform.entity.anwer.MultipleChoiceAnswer;
import kakao99.brainform.entity.anwer.SubjectiveAnswer;
import kakao99.brainform.entity.anwer.YesOrNoAnswer;
import kakao99.brainform.entity.question.MultipleChoiceQuestion;
import kakao99.brainform.entity.question.SubjectiveQuestion;
import kakao99.brainform.entity.question.YesOrNoQuestion;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.sql.init.dependency.DependsOnDatabaseInitialization;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "survey")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id")
    private Long id;

    private String title;

    @Column(name = "is_open")
    private String isOpen;

    @Column(name = "is_brainwave")
    private String isBrainwave;

    @Column(name = "answer_period")
    private Date answerPeriod;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "surveyor_id")
    private Member member;

    @OneToMany(mappedBy = "survey", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<YesOrNoQuestion> yesOrNoQuestions;

    @OneToMany(mappedBy = "survey", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<MultipleChoiceQuestion> multipleChoiceQuestions;

    @OneToMany(mappedBy = "survey", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<SubjectiveQuestion> subjectiveQuestions;

    public Survey filterQuestions(AnswerDTO answerDTO) {
            this.multipleChoiceQuestions = this.multipleChoiceQuestions.stream().map(
                    question -> {
                        MultipleChoiceQuestion filteredQuestion = question.filterAnswer(answerDTO.getMultipleChoiceAnswers());
                        return filteredQuestion;
                    }).collect(Collectors.toList());
            this.yesOrNoQuestions = this.yesOrNoQuestions.stream().map(
                    question -> {
                        YesOrNoQuestion yesOrNoQuestion = question.filterAnswer(answerDTO.getYesOrNoAnswers());
                        return yesOrNoQuestion;
                    }).collect(Collectors.toList());

            this.subjectiveQuestions = this.subjectiveQuestions.stream().map(
                    question -> {
                        SubjectiveQuestion subjectiveQuestion = question.filterAnswer(answerDTO.getSubjectiveAnswers());
                        return subjectiveQuestion;
                    }).collect(Collectors.toList());

        return this;
    }

}
