package kakao99.brainform.service;

import kakao99.brainform.dto.BrainDataDTO;
import kakao99.brainform.entity.BrainMemberInfo;
import kakao99.brainform.entity.BrainwaveResult;
import kakao99.brainform.entity.MemberSurvey;
import kakao99.brainform.entity.Survey;
import kakao99.brainform.repository.BrainWaveCodeRepository;
import kakao99.brainform.repository.BrainWaveRepository;
import kakao99.brainform.repository.MemberSurveyRepository;
import kakao99.brainform.repository.SurveyRepository;
import kakao99.brainform.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BrainWaveService {

    private final BrainWaveCodeRepository codeRepository;
    private final BrainWaveRepository brainWaveRepository;
    private final SurveyRepository surveyRepository;
    private final MemberSurveyRepository memberSurveyRepository;
    private final FileUtil fileUtil;

    @Transactional
    public ResponseEntity<?> saveBrainWave(BrainDataDTO dto) {

        Optional<BrainMemberInfo> byCode = codeRepository.findByCode(dto.getCode());
        if (byCode.isEmpty()) {
            return new ResponseEntity<>("뇌파 측정 코드가 존재하지 않습니다.", HttpStatus.NOT_FOUND);
        }

        BrainMemberInfo brainMemberInfo = byCode.get();

        MemberSurvey memberSurvey = memberSurveyRepository
                .findMemberSurveyBySurveyIdAndMemberID(brainMemberInfo.getSurveyId(), brainMemberInfo.getMemberId());

        BrainwaveResult brainwaveResult = BrainwaveResult.builder()
                .attAvg(dto.getAvgAtt())
                .meditAvg(dto.getAvgMed())
                .img(fileUtil.saveUserImage(dto.getImage()))
                .memberSurvey(memberSurvey)
                .build();

        brainWaveRepository.save(brainwaveResult);
        return new ResponseEntity<>("뇌파 데이터 저장 완료", HttpStatus.OK);
    }
}
