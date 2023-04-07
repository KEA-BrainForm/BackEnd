package kakao99.brainform.repository;

import kakao99.brainform.dto.MemberRegisterDTO;
import kakao99.brainform.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member save(Member member);
}
