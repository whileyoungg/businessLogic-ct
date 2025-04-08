package io.businesslogic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ranges.Range;

import static org.hamcrest.MatcherAssert.assertThat;
import org.assertj.core.api.Assertions;



public class MatchTest {
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

    }
    @Test
    public void testPlayers() {
        Assertions.assertThat(m1.white()).isEqualTo(p1);
        Assertions.assertThat(m1.black()).isEqualTo(p2);
        Assertions.assertThat(m2.black()).isEqualTo(p4);
        Assertions.assertThat(m2.white()).isEqualTo(p3);

    }
    @Test
    public void whiteWinsM1() {
        m1.whiteWin();
        Assertions.assertThat(m1.white().player().getElo()).isEqualTo(2694);
        Assertions.assertThat(m1.black().player().getElo()).isEqualTo(2676);
        Assertions.assertThat(m1.white().score()).isEqualTo(1);
        Assertions.assertThat(m1.black().score()).isEqualTo(0);
        Assertions.assertThat(m1.white().isLastAsWhite()).isTrue();
        Assertions.assertThat(m1.black().isLastAsWhite()).isFalse();
    }
    @Test
    public void blackWinsM1() {
        m1.blackWin();
        Assertions.assertThat(m1.white().player().getElo()).isEqualTo(2686);
        Assertions.assertThat(m1.black().player().getElo()).isEqualTo(2684);
    }
    @Test
    public void drawM1() {
        m1.draw();
        Assertions.assertThat(m1.white().player().getElo()).isEqualTo(2690);
        Assertions.assertThat(m1.black().player().getElo()).isEqualTo(2680);
        Assertions.assertThat(m1.white().score()).isEqualTo(0.5);
        Assertions.assertThat(m1.black().score()).isEqualTo(0.5);
    }
    @Test
    public void whiteWinsM2() {
        m2.whiteWin();
        Assertions.assertThat(m2.white().player().getElo()).isEqualTo(2850);
        Assertions.assertThat(m2.black().player().getElo()).isEqualTo(1700);

    }
    @Test
    public void blackWinsM2() {
        m2.blackWin();
        Assertions.assertThat(m2.white().player().getElo()).isEqualTo(2842);
        Assertions.assertThat(m2.black().player().getElo()).isEqualTo(1708);

    }
    @Test
    public void drawM2() {
        m2.draw();
        Assertions.assertThat(m2.white().player().getElo()).isEqualTo(2846);
        Assertions.assertThat(m2.black().player().getElo()).isEqualTo(1704);

}
}