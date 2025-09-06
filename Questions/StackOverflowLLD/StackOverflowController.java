package Questions.StackOverflowLLD;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import Questions.StackOverflowLLD.Enums.VoteType;
import Questions.StackOverflowLLD.models.Answer;
import Questions.StackOverflowLLD.models.Post;
import Questions.StackOverflowLLD.models.Question;
import Questions.StackOverflowLLD.models.Tag;
import Questions.StackOverflowLLD.models.User;
import Questions.StackOverflowLLD.patterns.observer.Observer;
import Questions.StackOverflowLLD.patterns.observer.ReputationObserver;
import Questions.StackOverflowLLD.patterns.strategy.SearchingStrategy;

public class StackOverflowController {

    private static final StackOverflowController instance = new StackOverflowController();

    private final Map<String, User> users = new ConcurrentHashMap<>();
    private final Map<String, Question> questions = new ConcurrentHashMap<>();
    private final Map<String, Answer> answers = new ConcurrentHashMap<>();
    private final Observer reputationObserver = new ReputationObserver();

    private StackOverflowController() {}

    public static StackOverflowController getInstance() {
        return instance;
    }

    public User createUser(String name, String email){
        User user = new User(name, email);
        users.put(user.getId(), user);
        return user;
    }

    public Question postQuestion(String title, String content, Set<Tag> tags, String author) {

        User authorUser = users.get(author);
        Question question = new Question(title, content, authorUser, tags);
        question.addPostObserver(reputationObserver);
        questions.put(question.getId(), question);
        return question;
    }


    public Answer postAnswer(String content, String questionId, String userId) {

        User authorUser = users.get(userId);
        Question question = questions.get(questionId);
        Answer answer = new Answer(content, authorUser);
        answer.addPostObserver(reputationObserver);
        answers.put(answer.getId(), answer);
        question.addAnswer(answer);
        return answer;
    }


    public void vote(String postId, String userId, VoteType voteType) {
        User voter = users.get(userId);
        Post post = findByPostId(postId);
        post.vote(voter, voteType);
    }


    public void acceptAnswer(String questionId, String answerId) {

        Question question = questions.get(questionId);
        Answer answer = answers.get(answerId);
        question.acceptAnswer(answer);
    }


    public List<Question> searchQuestions(List<SearchingStrategy> searchingStrategies) {

        List<Question> results = new ArrayList<>(questions.values());

        for(SearchingStrategy searchingStrategy : searchingStrategies) {
            results = searchingStrategy.filter(results);
        }
        return results;
    }

    private Post findByPostId(String postId) {
        
        if(questions.containsKey(postId)) {
            return questions.get(postId);
        }
        if(answers.containsKey(postId)) {
            return answers.get(postId);
        }

        throw new NoSuchElementException("Post not found");
    }
}
