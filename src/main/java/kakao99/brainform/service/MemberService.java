package kakao99.brainform.service;

import kakao99.brainform.dto.MemberLoginDTO;
import kakao99.brainform.dto.MemberRegisterDTO;
import kakao99.brainform.dto.TokenDTO;
import kakao99.brainform.entity.Member;
import kakao99.brainform.jwt.JwtFilter;
import kakao99.brainform.jwt.TokenProvider;
import kakao99.brainform.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    
    private final TokenProvider tokenProvider;


    public Member join(MemberRegisterDTO dto, Authentication authentication) {
        Member member = (Member) authentication.getPrincipal();

        return memberRepository.save(member.register(dto));
    }
    
    public String login(MemberLoginDTO loginDTO) {

        TokenDTO tokenDTO = getTokenDTOResponseEntity(loginDTO);

        return tokenDTO.getToken();
        
    }

    private TokenDTO getTokenDTOResponseEntity(MemberLoginDTO loginDTO) {

        Optional<Member> findUserByEmail = memberRepository.findByEmail(loginDTO.getEmail());

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(findUserByEmail.get().getEmail(), loginDTO.getPassword());
        log.info(authenticationToken.getName());


        String jwt = tokenProvider.createToken(findUserByEmail.get());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return new TokenDTO(jwt);
    }
}
