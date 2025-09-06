package Questions.StackOverflowLLD.patterns.strategy;

import java.util.List;
import java.util.stream.Collectors;

import Questions.StackOverflowLLD.models.Question;

public class KeyworkSearchingStrategy implements SearchingStrategy {

    private final String keyword;

    public KeyworkSearchingStrategy(String keyword) {
        this.keyword = keyword.toLowerCase();
    }

    @Override
    public List<Question> filter(List<Question> questions) {

        return questions.stream()
            .filter(question -> question.getContent().toLowerCase().contains(keyword) 
                    || question.getTitle().toLowerCase().contains(keyword))
        .collect(Collectors.toList());
    }
}
