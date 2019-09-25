package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class KingTest {

    @Test
    public void kingsCannotMoveOffLeftEdge() {
        // Arrange
        Board board = Board.empty();

        Piece blackKing = new King(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(3, 0);
        board.placePiece(blackCoords, blackKing);

        Piece whiteKing = new Pawn(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(4, 0);
        board.placePiece(whiteCoords, whiteKing);

        // Act
        List<Move> blackMoves = blackKing.getAllowedMoves(blackCoords, board);
        List<Move> whiteMoves = whiteKing.getAllowedMoves(whiteCoords, board);

        // Assert
        assertThat(blackMoves).doesNotContain(new Move(blackCoords, blackCoords.plus(0, -1)));
        assertThat(whiteMoves).doesNotContain(new Move(whiteCoords, whiteCoords.plus(0,-1)));
    }

    @Test
    public void kingsCanMoveInAnyDirection() {
        // Arrange
        Board board = Board.empty();

        Piece whiteKing = new Pawn(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(4, 4);
        board.placePiece(whiteCoords, whiteKing);

        // Act
        List<Move> whiteMoves = whiteKing.getAllowedMoves(whiteCoords, board);

        // Assert
        assertThat((whiteMoves).size() == 7);
    }

    @Test
    public void kingsCanCapture() {
        // Arrange
        Board board = Board.empty();

        Piece whiteKing = new King(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(4, 4);
        board.placePiece(whiteCoords, whiteKing);

        Piece blackKing = new King(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(3, 4);
        board.placePiece(blackCoords, blackKing);

        // Act
        List<Move> whiteMoves = whiteKing.getAllowedMoves(whiteCoords, board);

        // Assert
        assertThat(whiteMoves).contains(new Move(whiteCoords, blackCoords));
    }

}
