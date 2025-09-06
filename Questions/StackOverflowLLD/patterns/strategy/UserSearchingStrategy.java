package Questions.StackOverflowLLD.patterns.strategy;

import java.util.List;
import java.util.stream.Collectors;

import Questions.StackOverflowLLD.models.Question;

public class UserSearchingStrategy implements SearchingStrategy {

    private final String userId;

    public UserSearchingStrategy(String userId) {
        this.userId = userId;
    }

    @Override
    public List<Question> filter(List<Question> questions) {

        return questions.stream()
            .filter(q -> q.getAuthor().getId().equals(userId))
            .collect(Collectors.toList());
    }
    
}
