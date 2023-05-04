package kakao99.brainform.entity.anwer;

import jakarta.persistence.*;
import kakao99.brainform.entity.MemberSurvey;
import kakao99.brainform.entity.question.YesOrNoQuestion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "yesorno_answer")
public class YesOrNoAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Long id;


    private Boolean answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private YesOrNoQuestion yesOrNoQuestion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "surveyee_id")
    private MemberSurvey memberSurvey;

    public void setAnswer(Boolean answer) {
    this.answer= answer;
    }
}