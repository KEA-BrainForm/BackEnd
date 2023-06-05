package kakao99.brainform.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateQuestionDto{

    @NotNull
    private String title;

    @NotNull
    private List<CreateQuestionInput> questionList;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    @NotNull
    private String visibility;

    @NotNull
    private String wearable;

    @NotNull
    private Long surveyId;
}
