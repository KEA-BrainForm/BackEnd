package kakao99.brainform.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenDTO {

    @Id
    private String accessToken;
}
