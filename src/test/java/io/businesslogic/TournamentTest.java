package io.businesslogic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ranges.Range;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.assertj.core.api.Assertions;

public class TournamentTest {
    Player player1;
    Player player2;
    Participant p1;
    Participant p2;
    Match m1;
    Participant p3;
    Player player3;
    Player player4;
    Participant p4;
    Match m2;
    Tournament t;
    @BeforeEach
    public void setUp() throws Exception {
        player1 = new Player("Anton Korobov", 2690,"Ukraine");
        p1 = new Participant(player1);
        player2 = new Player("Vasyl Ivanchuk",2680,"Ukraine");
        p2 = new Participant(player2);
        m1 = new Match(p1,p2,1);
        player3 = new Player("Magnus Carlsen", 2850, "Norway");
        p3 = new Participant(player3);
        player4 = new Player("Daniil Kurys",1700, "Ukraine");
        p4 = new Participant(player4);
        m2 = new Match(p3,p4,1);
        t = new Tournament();
        t.addPlayer(player1);
        t.addPlayer(player2);
        t.addPlayer(player3);
        t.addPlayer(player4);
    }
    @Test
    public void statsTable(){
        List<Participant> players = t.scoreTable();
        Assertions.assertThat(players.get(0).player().getName()).isEqualTo("Magnus Carlsen");
        Assertions.assertThat(players.get(1).player().getName()).isEqualTo("Anton Korobov");
        Assertions.assertThat(players.get(2).player().getName()).isEqualTo("Vasyl Ivanchuk");
        Assertions.assertThat(players.get(3).player().getName()).isEqualTo("Daniil Kurys");

    } 

}