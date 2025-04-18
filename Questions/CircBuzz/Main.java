package Questions.CircBuzz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Questions.CircBuzz.enums.PlayerType;
import Questions.CircBuzz.models.Person;
import Questions.CircBuzz.models.Player;
import Questions.CircBuzz.models.Team;
import Questions.CircBuzz.models.MatchTypes.MatchType;
import Questions.CircBuzz.models.MatchTypes.T20Match;

public class Main {

    public static void main(String[] args) {
        
        Main ob = new Main();

        Team teamA = ob.addTeam("India");
        Team teamB = ob.addTeam("Pakistan");

        MatchType matchType = new T20Match();

        Match match = new Match(teamA, teamB, new Date(), "Dharmshala stadium", matchType);
        match.startMatch();
    }

    private Team addTeam(String teamName){

        Queue<Player> players = new LinkedList<>();
        for(int i = 0; i <= 6; i++){
            Player player = addPlayer(teamName + (i+1), PlayerType.BATSMAN);
            players.add(player);
        }

        List<Player> bowlers = new ArrayList<>();
        
        Player allRounder1 = addPlayer(teamName + 8, PlayerType.ALLROUNDER);
        Player allRounder2 = addPlayer(teamName + 9, PlayerType.ALLROUNDER);
        players.add(allRounder1);
        players.add(allRounder2);

        bowlers.add(allRounder1);
        bowlers.add(allRounder2);
        
        
        for(int i = 9; i <= 10; i++){
            Player player = addPlayer(teamName + (i+1), PlayerType.BOWLER);
            players.add(player);
            bowlers.add(player);
        }

        Player extraPlayer = addPlayer(teamName + 12, PlayerType.BATSMAN);

        Team team = new Team(teamName, players, Arrays.asList(extraPlayer), bowlers);
        return team;
    }

    private Player addPlayer(String playerName, PlayerType playerType){
        
        Person person = new Person();
        person.name = playerName;
        person.age = 25;
        person.address = "sdfdsds";

        return new Player(person, playerType);
    }
    
}
