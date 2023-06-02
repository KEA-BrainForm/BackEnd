package kakao99.brainform.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatchQuestoinDTO{

    @NotNull
    private String title;

    @NotNull
    private List<CreateQuestionInput> questionList;

    private List<SavedQuestionInput> savedquestionList;

    private List<CreateQuestionInput> idDeleteList;
    private List<SavedQuestionInput> numDeleteList;


    @NotNull
    private String visibility;

    @NotNull
    private String wearable;

    @NotNull
    private Long surveyId;
}
