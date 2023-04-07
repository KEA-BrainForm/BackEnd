package kakao99.brainform.service;

import kakao99.brainform.dto.MemberRegisterDTO;
import kakao99.brainform.entity.Member;
import kakao99.brainform.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member register(MemberRegisterDTO dto) {
        Member member = dto.toEntity();

        return memberRepository.save(member);
    }
}
