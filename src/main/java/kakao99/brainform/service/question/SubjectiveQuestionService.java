package kakao99.brainform.service.question;

import kakao99.brainform.entity.question.SubjectiveQuestion;
import kakao99.brainform.repository.SubjectiveQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectiveQuestionService {
    @Autowired
    private SubjectiveQuestionRepository subjectiveQuestionRepository;

    public SubjectiveQuestion createQuestion(SubjectiveQuestion question) {
        return subjectiveQuestionRepository.save(question);
    }

    public Optional<SubjectiveQuestion> findById(Long id) {
        return subjectiveQuestionRepository.findById(id);
    }
}
