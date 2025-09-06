package Questions.StackOverflowLLD;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Questions.StackOverflowLLD.Enums.VoteType;
import Questions.StackOverflowLLD.models.Answer;
import Questions.StackOverflowLLD.models.Question;
import Questions.StackOverflowLLD.models.Tag;
import Questions.StackOverflowLLD.models.User;
import Questions.StackOverflowLLD.patterns.strategy.SearchingStrategy;
import Questions.StackOverflowLLD.patterns.strategy.TagSearchingStrategy;
import Questions.StackOverflowLLD.patterns.strategy.UserSearchingStrategy;

public class Main {

    public static void main(String[] args) {
        
        StackOverflowController stackOverflowController = StackOverflowController.getInstance();

        // Users
        User user1 = stackOverflowController.createUser("user1",  "user1@gmail.com");
        User user2 = stackOverflowController.createUser("user2",  "user2@gmail.com");
        User user3 = stackOverflowController.createUser("user3",  "user3@gmail.com");


        // User1 posts a question
        System.out.println("User1 posts a question");
        Tag tag1 = new Tag("tag1");
        Tag tag2 = new Tag("tag2");

        Set<Tag> tags = new HashSet<>();
        tags.add(tag1);
        tags.add(tag2);

        Question questionPostedByUser1 = stackOverflowController.postQuestion("What is user1's question?", "Content of user1's posted question", tags, user1.getId());
        printReputations(user1, user2, user3);
 
        // User2 and User3 post answers on user1's question
        System.out.println("User2 and User3 post answers on user1's question");

        Answer answerByUser2 = stackOverflowController.postAnswer("Answer by user2", questionPostedByUser1.getId(), user2.getId());
        Answer answerByUser3 = stackOverflowController.postAnswer("Answer by user3", questionPostedByUser1.getId(), user3.getId());
        printReputations(user1, user2, user3);
        
        // Voting
        System.out.println("-----Voting starts-----");
        stackOverflowController.vote(questionPostedByUser1.getId(), user1.getId(), VoteType.UPVOTE);
        stackOverflowController.vote(answerByUser3.getId(), user2.getId(), VoteType.UPVOTE);
        stackOverflowController.vote(answerByUser2.getId(), user1.getId(), VoteType.DOWNVOTE);
        printReputations(user1, user2, user3);

        // User 1 accepts user 3's answer
        System.out.println("User 1 accepts user 3's answer");
        stackOverflowController.acceptAnswer(questionPostedByUser1.getId(), answerByUser3.getId());
        printReputations(user1, user2, user3);

        // Search
        System.out.println("---- Searching by user: 'User1' and tag: 'tag2'----");
    
        List<SearchingStrategy> searchingStrategies = new ArrayList<>();
        searchingStrategies.add(new UserSearchingStrategy(user1.getId()));
        searchingStrategies.add(new TagSearchingStrategy(tag2.getName()));

        List<Question> searchResults = stackOverflowController.searchQuestions(searchingStrategies);
        searchResults.forEach(question -> System.out.println(" - Found: " + question.getTitle()));
    }


    private static void printReputations(User... users) {
        System.out.println("--- Current Reputations ---");
        for(User user : users) {
            System.out.printf("%s: %d\n", user.getName(), user.getReputation());
        }
    }

}
