package kakao99.brainform.dto;

import jakarta.validation.constraints.NotNull;
import kakao99.brainform.entity.Gender;
import kakao99.brainform.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberRegisterDTO implements Serializable {

    @NotNull
    private String username;

    @NotNull
    private String gender;

    @NotNull
    private String age;

    @NotNull
    private String job;

    public Member toEntity() {
        return Member.builder()
                .username(username)
                .gender(gender)
                .age(age)
                .job(job)
                .build();
    }
}
