package kakao99.brainform.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrainDataResultDTO {

    private Float avgAtt;
    private Float avgMedit;
    private String image;
}
