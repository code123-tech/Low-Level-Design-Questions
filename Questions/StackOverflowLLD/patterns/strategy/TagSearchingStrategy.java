package Questions.StackOverflowLLD.patterns.strategy;

import java.util.List;
import java.util.stream.Collectors;

import Questions.StackOverflowLLD.models.Question;

public class TagSearchingStrategy implements SearchingStrategy {

    private final String tagName;

    public TagSearchingStrategy(String tagName) {
        this.tagName = tagName.toLowerCase();
    }

    @Override
    public List<Question> filter(List<Question> questions) {
        return questions.stream().filter(question -> 
            question.getTags().stream().anyMatch(tag -> tag.getName().toLowerCase().equals(tagName))
        )
        .collect(Collectors.toList());
    }
}
