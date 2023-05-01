package kakao99.brainform.entity.anwer;

import jakarta.persistence.*;
import kakao99.brainform.entity.MemberSurvey;
import kakao99.brainform.entity.question.MultipleChoiceQuestion;
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
@Table(name = "multiplechoice_answer")
public class MultipleChoiceAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Long id;

    private String answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private MultipleChoiceQuestion multipleChoiceQuestion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "surveyee_id")
    private MemberSurvey memberSurvey;

}



