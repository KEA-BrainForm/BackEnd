package kakao99.brainform.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class TokenDTO {

    private String accessToken;
    private String refreshToken;
}
