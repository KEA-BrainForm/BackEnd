package kakao99.brainform.service.question;

import kakao99.brainform.dto.MultiQuestionDto;
import kakao99.brainform.entity.question.MultipleChoiceQuestion;
import kakao99.brainform.repository.MultipleChoiceQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MultipleChoiceQuestionService {
    @Autowired
    private MultipleChoiceQuestionRepository multipleChoiceQuestionRepository;

    public MultipleChoiceQuestion createQuestion(MultiQuestionDto questionDto) {
        MultipleChoiceQuestion question = new MultipleChoiceQuestion();
        List<?> options = questionDto.getOptions();
        String[] texts = new String[5];

        for (int i = 0; i < options.size() && i < 5; i++) {
            texts[i] = ((Map<String, String>) ((List<?>) options).get(i)).get("text");
        }

        question.setChoice(texts[0], texts[1], texts[2], texts[3], texts[4]);

        return multipleChoiceQuestionRepository.save(question);
    }

    public Optional<MultipleChoiceQuestion> findById(Long id) {
        return multipleChoiceQuestionRepository.findById(id);
    }}