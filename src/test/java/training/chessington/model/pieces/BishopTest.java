package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class BishopTest {

    @Test
    public void bishopCanMoveDiagonally() {
        // Arrange
        Board board = Board.empty();

        Piece blackBishop = new Bishop(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(3, 3);
        board.placePiece(blackCoords, blackBishop);

        // Act
        List<Move> blackMoves = blackBishop.getAllowedMoves(blackCoords, board);

        // Assert
        assertThat(blackMoves).contains(new Move(blackCoords, blackCoords.plus(+1,+1)));
        assertThat(blackMoves).contains(new Move(blackCoords, blackCoords.plus(+1,-1)));
        assertThat(blackMoves).contains(new Move(blackCoords, blackCoords.plus(-1,+1)));
        assertThat(blackMoves).contains(new Move(blackCoords, blackCoords.plus(-1,-1)));
    }

}
