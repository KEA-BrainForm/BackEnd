package kakao99.brainform.repository;

import jakarta.persistence.EntityManager;
import kakao99.brainform.entity.BrainwaveResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BrainWaveRepository {

    private final EntityManager em;

    public BrainwaveResult save(BrainwaveResult brainwaveResult) {
        em.persist(brainwaveResult);
        return brainwaveResult;
    }
}
