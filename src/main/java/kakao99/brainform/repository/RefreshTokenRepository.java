package kakao99.brainform.repository;

import kakao99.brainform.dto.RefreshToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends CrudRepository<RefreshToken, Long> {

    RefreshToken save(RefreshToken refreshToken);

}
