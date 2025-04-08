package io.Main;

import io.businesslogic.Match;
import io.businesslogic.Participant;
import io.businesslogic.Player;
import io.businesslogic.Tournament;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Alice", 1500, "USA");
        Player player2 = new Player("Bob", 1600, "Canada");
        Player player3 = new Player("Charlie", 1550, "UK");
        Player player4 = new Player("Diana", 1700, "Germany");
        Player player5 = new Player("Eve", 1650, "France");
        Player player6 = new Player("Frank", 1580, "Italy");
        Player player7 = new Player("Grace", 1620, "Spain");
        Player player8 = new Player("Heidi", 1720, "Netherlands");
        Tournament tournament = new Tournament();
        tournament.addPlayer(player1);
        tournament.addPlayer(player2);
        tournament.addPlayer(player3);
        tournament.addPlayer(player4);
        tournament.addPlayer(player5);
        tournament.addPlayer(player6);
        tournament.addPlayer(player7);
        tournament.addPlayer(player8);
        tournament.Tour();
        System.out.println("Tournament matches: ");
        for (Match match : tournament.getMatches()) {
            String m = match.toString();
            System.out.println(m);        }
        tournament.results();
        System.out.println("Standings: ");
        for (Participant player : tournament.scoreTable()) {
            System.out.println(player.player().getName() + " - " + player.player().getElo() + " (" + player.player().getCounty() +" " + player.score()+")");
        }
        tournament.Tour();
        System.out.println("Tournament matches: ");
        for (Match match : tournament.getMatches()) {
            String m = match.toString();
            System.out.println(m);        }
        tournament.results();
        System.out.println("Standings: ");
        for (Participant player : tournament.scoreTable()) {
            System.out.println(player.player().getName() + " - " + player.player().getElo() + " (" + player.player().getCounty() +" " + player.score()+")");
        }
        tournament.Tour();
        System.out.println("Tournament matches: ");
        for (Match match : tournament.getMatches()) {
            String m = match.toString();
            System.out.println(m);
        }
        tournament.results();
        System.out.println("Standings: ");
        for (Participant player : tournament.scoreTable()) {
            System.out.println(player.player().getName() + " - " + player.player().getElo() + " (" + player.player().getCounty() +" " + player.score()+")");
        }
    }
}