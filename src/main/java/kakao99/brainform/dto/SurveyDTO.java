package kakao99.brainform.dto;

import kakao99.brainform.entity.question.MultipleChoiceQuestion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SurveyDTO {
    private List<QuestionDTO> questionDTOS = new ArrayList<>();
}
