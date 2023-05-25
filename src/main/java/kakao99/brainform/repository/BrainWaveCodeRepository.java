package kakao99.brainform.repository;

import kakao99.brainform.entity.BrainMemberInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class BrainWaveCodeRepository {

    private final Map<String, BrainMemberInfo> map;

    public BrainMemberInfo save(BrainMemberInfo brainMemberInfo) {

        map.put(brainMemberInfo.getCode(), brainMemberInfo);

        return brainMemberInfo;
    }

    public BrainMemberInfo findByCode(String code) {
        return map.get(code);
    }
}
