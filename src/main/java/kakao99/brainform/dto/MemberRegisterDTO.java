package kakao99.brainform.dto;

import kakao99.brainform.entity.Member;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberRegisterDTO implements Serializable {

    private String username;

    private String gender;

    private String email;

    private String age;

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
