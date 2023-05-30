package kakao99.brainform.entity.question;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import kakao99.brainform.entity.Survey;
import kakao99.brainform.entity.anwer.MultipleChoiceAnswer;
import kakao99.brainform.entity.anwer.SubjectiveAnswer;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;

@Entity
@Getter
@Setter
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
    @JsonBackReference
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @OneToMany(mappedBy = "subjectiveQuestion", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<SubjectiveAnswer> subjectiveAnswers;

    public void setQuestion(String title) {
        this.question = title;
    }

    public SubjectiveQuestion filterAnswer(List<SubjectiveAnswer> answers) {
        SubjectiveQuestion subjectiveQuestion = SubjectiveQuestion.builder()
                .id(this.id)
                .num(this.num)
                .question(this.question)
                .subjectiveAnswers(answers)
                .build();

        return subjectiveQuestion;
    }
}
