package io.businesslogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Tournament {
    private ArrayList<Participant> players;
    private int round;
    public ArrayList<Match> matches;
    
    public Tournament(){
        this.players = new ArrayList<>();
        this.round = 0;
        this.matches = new ArrayList<>();
    }

    public void addPlayer(Player p){
        Participant player = new Participant(p);
        this.players.add(player);
    } 
    public ArrayList<Participant> scoreTable(){
        if(round==0){
            return players.stream()
            .sorted((Participant p1, Participant p2) -> p1.compareTo(p2))
            .collect(Collectors.toCollection(ArrayList::new));
        } else{
            return players.stream()
            .sorted((Participant p1, Participant p2) -> p1.compareToScore(p2))
            .collect(Collectors.toCollection(ArrayList::new));
        }

    } 
    public List<Match> Tour(){
        ArrayList<Participant> ROUND = this.scoreTable();
        if(round==0){
            round++;
        }
        if(round ==1){
            for (int i = 0; i < ROUND.size(); i+=2) {
                Match match = new Match(ROUND.get(i),ROUND.get(i+1),this.round);
                this.matches.add(match);
            }
        } else {
            for (int i = 0; i < ROUND.size(); i+=2) {
                if(ROUND.get(i).isLastAsWhite() && !ROUND.get(i+1).isLastAsWhite()){
                    Match match = new Match(ROUND.get(i+1),ROUND.get(i),this.round);
                    this.matches.add(match);
                } else if(!ROUND.get(i).isLastAsWhite() && ROUND.get(i+1).isLastAsWhite()){
                    Match match = new Match(ROUND.get(i),ROUND.get(i+1),this.round);
                    this.matches.add(match);
                } else {
                    Match match = new Match(ROUND.get(i),ROUND.get(i+1),this.round);
                    this.matches.add(match);
                }
            }
        }
        round++;
        return this.matches;
    }
    public void results(){
        for (Match match : matches) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("The match between " + match.white().player().getName() + " and " + match.black().player().getName() + " ended as:");
            String result = scanner.nextLine();
            if (result.equals("1-0")) {
                match.whiteWin();
            } else if (result.equals("0-1")) {
                match.blackWin();
            } else if (result.equals("1/2-1/2")) {
                match.draw();
            } else {
                scanner.close();
                throw new IllegalResultException("Invalid result. Please enter 1-0, 0-1, or 1/2-1/2.");
            }
        }
        matches.clear();
    }
    public void reset() {
        this.players.clear();
        this.round = 0;
        this.matches.clear();
    }
    public int getRound() {
        return round;
    }
    public List<Match> getMatches() {
        return matches;
    }
}
