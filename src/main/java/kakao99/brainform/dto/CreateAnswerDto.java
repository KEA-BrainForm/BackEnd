package kakao99.brainform.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAnswerDto {

    @JsonProperty("surveyId")
    private Long surveyId;
    @JsonProperty("answers")
    private ArrayList<CreateAnswerInput> answers;

    //private String type;

}
