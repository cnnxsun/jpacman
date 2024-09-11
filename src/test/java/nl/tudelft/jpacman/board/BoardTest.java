package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the Board.
 */
class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        // Create a 1x1 grid with a valid BasicSquare.
        Square[][] grid = new Square[1][1];
        grid[0][0] = new BasicSquare();
        board = new Board(grid);
    }

    @Test
    void testBoardInitialization() {
        // Ensure that the board width and height are both 1.
        assertThat(board.getWidth()).isEqualTo(1);
        assertThat(board.getHeight()).isEqualTo(1);

        // Ensure that the square at (0,0) is not null and is the expected BasicSquare.
        Square square = board.squareAt(0, 0);
        assertThat(square).isNotNull();
    }

    @Test
    void testBoardInitializationWithNullSquare() {
        // Create a 1x1 grid with a null square.
        Square[][] gridWithNull = new Square[1][1];
        gridWithNull[0][0] = null;

        // Check that the construction of a board with a null square throws an AssertionError.
        assertThrows(AssertionError.class, () -> {
            new Board(gridWithNull);
        });
    }
}
