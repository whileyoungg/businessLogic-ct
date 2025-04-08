package io.businesslogic;

public class Participant implements Comparable<Participant>{
    private final Player player;
    private double score =0;
    private boolean lastAsWhite = false;


    public Participant(Player player) {
        this.player = player;
    }
    public Player player() {
        return player;
    }
    public double score() {
        return score;
    }
    public void win(int elo) {
        this.player.updateElo(elo);
        this.score++;
    }
    public void loss(int elo) {
        this.player.updateElo(elo);
    }
    public void draw(int elo) {
        this.player.updateElo(elo);
        this.score += 0.5;
    }
    public void lastAsWhite() {
         lastAsWhite = true;
    }
    public void lastAsBlack() {
        lastAsWhite = false;
    }
    public boolean isLastAsWhite() {
        return lastAsWhite;
    }
    @Override
    public int compareTo(Participant o) {
        return Integer.compare( o.player.getElo(),this.player.getElo());
    }
    public int compareToScore(Participant o) {
        return Double.compare( o.score(),this.score());
    }
    public String toString(){
        return player.getName() + ":\t" + score;
    }
    
}
