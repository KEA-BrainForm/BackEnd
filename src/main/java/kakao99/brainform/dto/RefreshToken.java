package kakao99.brainform.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "RefreshToken", timeToLive = 60)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RefreshToken {

    @Id
    private Long memberId;

    private String refreshToken;

}
