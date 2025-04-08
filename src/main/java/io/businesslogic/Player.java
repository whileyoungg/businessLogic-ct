package io.businesslogic;

public class Player {
    private final String name;
    private int elo;
    private final String county;

    public Player(String name, int elo, String county) {
        this.name = name;
        this.elo = elo;
        this.county = county;
    }
    public String getName() {
        return name;
    }
    public int getElo() {
        return elo;
    }
    public String getCounty() {
        return county;
    }
    public void updateElo(int elo) {
        this.elo = this.elo + elo;
    }
}
