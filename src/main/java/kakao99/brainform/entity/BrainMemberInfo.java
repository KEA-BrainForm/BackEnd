package kakao99.brainform.entity;


import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrainMemberInfo {

    private String code;
    private Long surveyId;
    private Long memberId;
    private boolean flag;
}
