package io.businesslogic;

public class Match {
    private final Participant white;
    private final Participant black;
    private double whitewinExcpected;
    private double blackwinExcpected;
    private int whiteWinResult;
    private int blackWinResult;
    private int whiteDrawResult;
    private int blackDrawResult;
    private int K = 8; // K-factor for Elo rating system
    private int round;

    public Match(Participant white, Participant black, int round) {
        this.white = white;
        this.black = black;
        this.whitewinExcpected = 1 / (1 + Math.pow(10, (black.player().getElo() - white.player().getElo()) / 400.0));
        this.blackwinExcpected = 1 / (1 + Math.pow(10, (white.player().getElo() - black.player().getElo()) / 400.0));
        this.whiteWinResult = (int) Math.round(K * (1 - whitewinExcpected));
        this.blackWinResult = (int) Math.round(K * (1 - blackwinExcpected));
        this.whiteDrawResult = (int) Math.round(K * (0.5 - whitewinExcpected));
        this.blackDrawResult = (int) Math.round(K * (0.5 - blackwinExcpected));
        this.round = round;
    }
    public Participant white() {
        return white;
    }
    public Participant black() {
        return black;
    }
    public void whiteWin(){
        white.win(whiteWinResult);
        white.lastAsWhite();
        black.lastAsBlack();
        black.loss(-whiteWinResult);
    }
    public void blackWin(){
        black.win(blackWinResult);
        black.lastAsBlack();
        white.lastAsWhite();
        white.loss(-blackWinResult);
    }
    public void draw(){
        white.draw(whiteDrawResult);
        black.draw(blackDrawResult);
        white.lastAsWhite();
        black.lastAsBlack();
    }
    public String toString(){
        return "Round: " + round + "\n" + white.player().getName() + " vs " + black.player().getName() + "\n" +
                white.player().getElo() + " vs " + black.player().getElo() + "\n" +
                white.score() + " vs " + black.score() + "\n";

}
}