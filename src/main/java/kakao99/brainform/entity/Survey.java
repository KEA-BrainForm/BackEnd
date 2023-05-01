package kakao99.brainform.entity;

import jakarta.persistence.*;
import kakao99.brainform.entity.question.MultipleChoiceQuestion;
import kakao99.brainform.entity.question.SubjectiveQuestion;
import kakao99.brainform.entity.question.YesOrNoQuestion;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Getter
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
    private Boolean isOpen;

    @Column(name = "is_brainwave")
    private Boolean isBrainwave;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "surveyor_id")
    private Member member;

    @OneToMany(mappedBy = "survey", fetch = FetchType.LAZY)
    private List<YesOrNoQuestion> yesOrNoQueQuestions;

    @OneToMany(mappedBy = "survey", fetch = FetchType.LAZY)
    private List<MultipleChoiceQuestion> multipleChoiceQuestions;

    @OneToMany(mappedBy = "survey", fetch = FetchType.LAZY)
    private List<SubjectiveQuestion> subjectiveQuestions;
}
