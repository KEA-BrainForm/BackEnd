package kakao99.brainform.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String username;

    @Column
    @NotNull
    private String nickname;

    @Column
    @NotNull
    private String gender;

    @Column
    @NotNull
    private String age;

    @Column
    @NotNull
    private String job;

    @Column(name = "kakao_id")
    private String kakaoId;

    @Column(name = "google_id")
    private String googleId;

    @Column(name = "naver_id")
    private String naverId;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatedAt;


    @Column(name = "is_active")
    private Boolean isActive;


}


