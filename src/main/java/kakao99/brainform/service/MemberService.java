package kakao99.brainform.service;

import kakao99.brainform.dto.TokenDTO;
import kakao99.brainform.dto.MemberRegisterDTO;
import kakao99.brainform.entity.Member;
import kakao99.brainform.jwt.TokenProvider;
import kakao99.brainform.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    private final TokenProvider tokenProvider;

    @Transactional
    public TokenDTO join(MemberRegisterDTO dto, Authentication authentication) {
        Member member = (Member) authentication.getPrincipal();

        Member savedMember = memberRepository.save(member.register(dto));

        String accessToken = tokenProvider.createAccessToken(savedMember);
        String refreshToken = tokenProvider.createRefreshToken(savedMember);

        return new TokenDTO(accessToken, refreshToken);
    }


}
