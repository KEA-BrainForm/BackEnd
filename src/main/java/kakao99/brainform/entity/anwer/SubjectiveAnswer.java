package kakao99.brainform.entity.anwer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import kakao99.brainform.entity.MemberSurvey;
import kakao99.brainform.entity.question.SubjectiveQuestion;
import kakao99.brainform.entity.question.YesOrNoQuestion;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "subjective_answer")
public class SubjectiveAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Long id;


    private String answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "question_id")
    private SubjectiveQuestion subjectiveQuestion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "surveyee_id")
    private MemberSurvey memberSurvey;

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
