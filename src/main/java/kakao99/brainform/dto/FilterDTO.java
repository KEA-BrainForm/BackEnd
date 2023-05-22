package kakao99.brainform.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class FilterDTO {
    private List<String> genders;
    private List<String> ages;
    private List<String> occupations;
    private String surveyId;
}
