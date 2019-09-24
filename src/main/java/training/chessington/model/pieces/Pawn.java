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

        int direction = getColour().equals(PlayerColour.WHITE) ?
                -1:
                1;

        if(isNotOnOppositeRow(from)) {

            if (isWhite() && isSpaceOneAheadEmpty(from, direction, board)) {
                Coordinates to = new Coordinates(from.getRow() +(direction), from.getCol());
                movesArray.add(new Move(from, to));
            } else if (isBlack() && isSpaceOneAheadEmpty(from, direction, board)) {
                Coordinates to = new Coordinates(from.getRow() +(direction), from.getCol());
                movesArray.add(new Move(from, to));
            }

            if (isWhite() && isOnHomeRow(from) && isSpaceTwoAheadEmpty(from, direction, board)) {
                Coordinates to2 = new Coordinates(from.getRow() - 2, from.getCol());
                movesArray.add(new Move(from, to2));
            } else if (isBlack() && isOnHomeRow(from) && isSpaceTwoAheadEmpty(from, direction, board)) {
                Coordinates to2 = new Coordinates(from.getRow() + 2, from.getCol());
                movesArray.add(new Move(from, to2));
            }

            if (isPieceDiagonallyLeft(from, direction, board)){
                Coordinates to = new Coordinates(from.getRow() + (direction), from.getCol() + (direction));
                movesArray.add(new Move(from, to));
            }

            if (isPieceDiagonallyRight(from, direction, board)){
                Coordinates to = new Coordinates(from.getRow() + (direction), from.getCol() - (direction));
                movesArray.add(new Move(from, to));
            }

        }

        return movesArray;
    }

    private boolean isOnHomeRow(Coordinates from){
        int whiteHomeRow = 6;
        int blackHomeRow = 1;

        return ((isWhite() && from.getRow() == whiteHomeRow) || (isBlack() && from.getRow() == blackHomeRow));
    }

    private boolean isNotOnOppositeRow(Coordinates from){
        int whiteOppositeRow = 0;
        int blackOppositeRow = 7;

        return ((isWhite() && from.getRow() != whiteOppositeRow) || (isBlack() && from.getRow() != blackOppositeRow));
    }

    private boolean isSpaceOneAheadEmpty(Coordinates from, int direction, Board board){
        return board.get(new Coordinates(from.getRow()+(direction),from.getCol())) == null;
    }

    private boolean isSpaceTwoAheadEmpty(Coordinates from, int direction, Board board){
        return board.get(new Coordinates(from.getRow()+(2*direction),from.getCol())) == null;
    }

    private boolean isBlack(){
        return (getColour().equals(PlayerColour.BLACK));
    }

    private boolean isWhite(){
        return (getColour().equals(PlayerColour.WHITE));
    }


    private boolean isPieceDiagonallyLeft(Coordinates from, int direction, Board board){
        if ((isWhite() && from.getCol() != 0) || (isBlack() && from.getCol() != 7)) {
            return (board.get(new Coordinates(from.getRow() + (direction), from.getCol() + (direction))) != null) && board.get(new Coordinates(from.getRow() + (direction), from.getCol() + (direction))).getColour() != getColour();
        } else {
            return false;
        }
    }

    private boolean isPieceDiagonallyRight(Coordinates from, int direction, Board board) {
        if ((isWhite() && from.getCol() != 7) || (isBlack() && from.getCol() != 0)) {
            return (board.get(new Coordinates(from.getRow() + (direction), from.getCol() - (direction))) != null) && board.get(new Coordinates(from.getRow() + (direction), from.getCol() - (direction))).getColour() != getColour();
        } else {
            return false;
        }
    }

}