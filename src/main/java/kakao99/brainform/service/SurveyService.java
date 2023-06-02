package kakao99.brainform.service;

import io.swagger.v3.oas.annotations.servers.Server;
import kakao99.brainform.entity.Member;
import kakao99.brainform.entity.MemberSurvey;
import kakao99.brainform.entity.Survey;
import kakao99.brainform.repository.MemberSurveyRepository;
import kakao99.brainform.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SurveyService {

    private final SurveyRepository surveyRepository;
    private final MemberSurveyRepository memberSurveyRepository;

    @Transactional
    public ResponseEntity<?> deleteSurvey(Long id, Member member) {

        Optional<Survey> surveyById = surveyRepository.findSurveyById(id);

        if (surveyById.isEmpty()) {
            return new ResponseEntity<>("설문이 존재 하지 않습니다.", HttpStatus.NOT_FOUND);
        }

        if (!surveyById.get().getMember().getId().equals(member.getId())) {
            return new ResponseEntity<>("삭제할 권한이 없습니다.", HttpStatus.FORBIDDEN);
        }
        surveyRepository.deleteSurveyById(id);
        return new ResponseEntity<>("설문이 삭제 되었습니다.", HttpStatus.OK);

    }
}
