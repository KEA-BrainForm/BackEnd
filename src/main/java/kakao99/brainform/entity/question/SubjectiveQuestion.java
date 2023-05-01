package kakao99.brainform.entity.question;

import jakarta.persistence.*;
import kakao99.brainform.entity.Survey;
import kakao99.brainform.entity.anwer.MultipleChoiceAnswer;
import kakao99.brainform.entity.anwer.SubjectiveAnswer;
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
@Table(name = "subjective_question")
public class SubjectiveQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;

    private Integer num;
    private String question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @OneToMany(mappedBy = "subjectiveQuestion", fetch = FetchType.LAZY)
    private List<SubjectiveAnswer> subjectiveAnswers;
}
