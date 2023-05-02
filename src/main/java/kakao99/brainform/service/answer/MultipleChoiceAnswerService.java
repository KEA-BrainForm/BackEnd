package kakao99.brainform.service.answer;

import kakao99.brainform.entity.anwer.MultipleChoiceAnswer;
import kakao99.brainform.repository.answer.MultipleChoiceAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MultipleChoiceAnswerService {
    @Autowired
    private MultipleChoiceAnswerRepository multipleChoiceAnswerRepository;

    public MultipleChoiceAnswer createAnswer(MultipleChoiceAnswer answer) {
        return multipleChoiceAnswerRepository.save(answer);
    }

    public Optional<MultipleChoiceAnswer> findById(Long id) {
        return multipleChoiceAnswerRepository.findById(id);
    }
}
