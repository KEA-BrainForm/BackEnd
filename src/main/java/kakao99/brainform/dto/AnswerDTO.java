package kakao99.brainform.dto;

import kakao99.brainform.entity.MemberSurvey;
import kakao99.brainform.entity.anwer.MultipleChoiceAnswer;
import kakao99.brainform.entity.anwer.SubjectiveAnswer;
import kakao99.brainform.entity.anwer.YesOrNoAnswer;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDTO {
    private List<MultipleChoiceAnswer> multipleChoiceAnswers = new ArrayList<>();
    private List<SubjectiveAnswer> subjectiveAnswers = new ArrayList<>();
    private List<YesOrNoAnswer> yesOrNoAnswers = new ArrayList<>();

    public void updateAnswer(MemberSurvey memberSurvey) {
        this.multipleChoiceAnswers.addAll(memberSurvey.getMultipleChoiceAnswers());
        this.subjectiveAnswers.addAll(memberSurvey.getSubjectiveAnswers());
        this.yesOrNoAnswers.addAll(memberSurvey.getYesOrNoAnswers());
    }


}
