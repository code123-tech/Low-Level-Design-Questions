package Questions.StackOverflowLLD.patterns.strategy;

import java.util.List;

import Questions.StackOverflowLLD.models.Question;

public interface SearchingStrategy {

    List<Question> filter(List<Question> questions);
}
