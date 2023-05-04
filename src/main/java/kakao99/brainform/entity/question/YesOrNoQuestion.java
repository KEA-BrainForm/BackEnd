package kakao99.brainform.entity.question;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import kakao99.brainform.entity.Survey;
import kakao99.brainform.entity.anwer.YesOrNoAnswer;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "yesorno_question")
public class YesOrNoQuestion {
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

    @OneToMany(mappedBy = "yesOrNoQuestion", fetch = FetchType.LAZY)
    private List<YesOrNoAnswer> yesOrNoAnswer;

    public void setQuestion(String title) {
        this.question = title;
    }
}
