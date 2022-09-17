package nl.tudelft.jpacman.board;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoardTest {

    private Square[][] onexone = new Square[1][1];
    @Test
    void testKorTeeSee() {
        this.onexone[0][0] = new BasicSquare();
        Board bod = new Board(this.onexone);
        assertThat(bod.invariant()).isTrue();
        this.onexone[0][0] = null ;
        assertThat(bod.invariant()).isTrue();
        assertThrows(AssertionError.class, ()->new Board(this.onexone),"Initial grid cannot contain null squares");
    }
    @Test
    void testKorTeeHa() {
        this.onexone[0][0] = new BasicSquare();
        Board bod = new Board(this.onexone);
        this.onexone[0][0] = null ;
        assertThrows(AssertionError.class, () ->bod.squareAt(0,0), "Follows from invariant." );
    }
}
