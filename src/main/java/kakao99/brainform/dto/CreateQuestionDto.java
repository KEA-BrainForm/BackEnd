package kakao99.brainform.dto;

import jakarta.validation.constraints.NotNull;
import kakao99.brainform.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateQuestionDto implements Serializable {

    @NotNull
    private String title;

    @NotNull
    private List<?> questionList;

    @NotNull
    private String visibility;

    @NotNull
    private String wearable;
}
