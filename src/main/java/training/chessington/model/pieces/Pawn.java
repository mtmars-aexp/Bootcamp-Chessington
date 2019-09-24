package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {

        List<Move> movesArray = new ArrayList<>();

        if (getColour().equals(PlayerColour.WHITE)) {
            Coordinates to = new Coordinates(from.getRow()-1,from.getCol());
            Move move = new Move(from, to);
            movesArray.add(move);
        } else if (getColour().equals(PlayerColour.BLACK)) {
            Coordinates to = new Coordinates(from.getRow()+1,from.getCol());
            Move move = new Move(from, to);
            movesArray.add(move);
        }

        if (getColour().equals(PlayerColour.WHITE) && from.getRow() == 6){
            Coordinates to = new Coordinates(from.getRow()-2, from.getCol());
            Move move = new Move(from, to);
            movesArray.add(move);
        } else if (getColour().equals(PlayerColour.BLACK) && from.getRow() == 1){
            Coordinates to = new Coordinates(from.getRow()+2, from.getCol());
            Move move = new Move(from, to);
            movesArray.add(move);
        }




        return movesArray;
    }
}
