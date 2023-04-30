package kakao99.brainform.entity.question;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

}
