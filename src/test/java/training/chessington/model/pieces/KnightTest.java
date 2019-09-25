package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class KnightTest {

    @Test
    public void knightsCanMoveInEightDirections() {
        // Arrange
        Board board = Board.empty();

        Piece blackKnight = new Knight(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(3, 0);
        board.placePiece(blackCoords, blackKnight);

        // Act
        List<Move> blackMoves = blackKnight.getAllowedMoves(blackCoords, board);

        // Assert
        assertThat(blackMoves.size() == 7);
    }

    @Test
    public void knightsCanHopOverOtherPieces() {
        // Arrange
        Board board = Board.empty();

        Piece blackRook = new Rook(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(1,3);
        board.placePiece(blackCoords, blackRook);

        Piece blackKnight = new Knight(PlayerColour.BLACK);
        blackCoords = new Coordinates(3, 3);
        board.placePiece(blackCoords, blackKnight);

        Piece whitePawn = new Pawn(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(2,3);
        board.placePiece(whiteCoords, whitePawn);

        // Act
        List<Move> blackMoves = blackKnight.getAllowedMoves(blackCoords, board);

        // Assert
        assertThat(blackMoves).contains(new Move(blackCoords, blackCoords.plus(-2,1)));
    }

    @Test
    public void knightsCanCapture() {
        // Arrange
        Board board = Board.empty();

        Piece blackKnight = new Knight(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(0, 0);
        board.placePiece(blackCoords, blackKnight);

        Piece whitePawn = new Pawn(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(2,1);
        board.placePiece(whiteCoords, whitePawn);

        // Act
        List<Move> blackMoves = blackKnight.getAllowedMoves(blackCoords, board);

        // Assert
        assertThat(blackMoves).contains(new Move(blackCoords, whiteCoords));
    }


}
