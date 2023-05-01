package kakao99.brainform.entity.question;

import jakarta.persistence.*;
import kakao99.brainform.entity.Survey;
import kakao99.brainform.entity.anwer.MultipleChoiceAnswer;
import kakao99.brainform.entity.anwer.YesOrNoAnswer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "multiplechoice_question")
public class MultipleChoiceQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;


    private Integer num;
    private Integer count;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private String choice5;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @OneToMany(mappedBy = "multipleChoiceQuestion", fetch = FetchType.LAZY)
    private List<MultipleChoiceAnswer> multipleChoiceAnswers;
}
