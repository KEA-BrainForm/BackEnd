package kakao99.brainform.dto;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrainDataDTO {
    private Long memberId;
    private Long surveyId;
    private String code;
    private MultipartFile image;

    private Float avgAtt;

    private Float avgMed;

}
