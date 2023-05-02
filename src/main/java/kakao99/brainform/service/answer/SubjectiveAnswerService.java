package kakao99.brainform.service.answer;

import kakao99.brainform.entity.anwer.SubjectiveAnswer;
import kakao99.brainform.repository.answer.SubjectiveAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectiveAnswerService {
    @Autowired
    private SubjectiveAnswerRepository subjectiveAnswerRepository;

    public SubjectiveAnswer createAnswer(SubjectiveAnswer answer) {
        return subjectiveAnswerRepository.save(answer);
    }

    public Optional<SubjectiveAnswer> findById(Long id) {
        return subjectiveAnswerRepository.findById(id);
    }
}
