package kakao99.brainform.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilterDTO {
    private Long surveyId;
    private List<String> genders;
    private List<String> ages;
    private List<String> occupations;
}
