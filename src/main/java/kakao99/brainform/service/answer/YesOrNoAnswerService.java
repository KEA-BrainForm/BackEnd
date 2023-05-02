package kakao99.brainform.service.answer;

import kakao99.brainform.entity.anwer.YesOrNoAnswer;
import kakao99.brainform.repository.answer.YesOrNoAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class YesOrNoAnswerService {
    @Autowired
    private YesOrNoAnswerRepository yesOrNoAnswerRepository;

    public Optional<YesOrNoAnswer> findById(Long id) {
        return yesOrNoAnswerRepository.findById(id);
    }

    public YesOrNoAnswer createAnswer(YesOrNoAnswer answer) {
        return yesOrNoAnswerRepository.save(answer);
    }
}
