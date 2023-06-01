package kakao99.brainform.entity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrainData {
    private String memberId;
    private String surveyId;
    private String code;
    private byte[] image;

    private double avgAtt;

    private double avgMed;


}
