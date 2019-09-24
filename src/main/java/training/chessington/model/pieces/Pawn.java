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

        Coordinates to = getColour().equals(PlayerColour.WHITE) ?
                new Coordinates(from.getRow()-1,from.getCol()):
                new Coordinates(from.getRow()+1,from.getCol());
            movesArray.add(new Move(from, to));

//        if (getColour().equals(PlayerColour.WHITE) && from.getRow() == 6){
//            Coordinates to2 = new Coordinates(from.getRow()-2, from.getCol());
//            movesArray.add(new Move(from, to2));
//        } else if (getColour().equals(PlayerColour.BLACK) && from.getRow() == 1){
//            Coordinates to2 = new Coordinates(from.getRow()+2, from.getCol());
//            movesArray.add(new Move(from, to2));
//        }

        to = isOnHomeRow(from) ?
                new Coordinates(from.getRow()-2, from.getCol()):
                new Coordinates(from.getRow()+2, from.getCol());
        movesArray.add(new Move(from,to));

        return movesArray;
    }

    private boolean isOnHomeRow(Coordinates from){
        return (getColour().equals(PlayerColour.WHITE) && from.getRow() == 6) ||
                (getColour().equals(PlayerColour.BLACK) && from.getRow() == 1);
    }
}
