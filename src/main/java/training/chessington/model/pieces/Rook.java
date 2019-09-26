package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece {
    public Rook(PlayerColour colour) {
        super(PieceType.ROOK, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> movesArray = new ArrayList<>();

        Coordinates to = new Coordinates(from.getRow(), from.getCol());

        //Building north branch.
        for(int i = 1; i != 7; i++){
            to = new Coordinates(from.getRow()-i, from.getCol());
            if (coordinateIsOnBoard(to)){
                if(isPiece(to, board) && board.get(to).getColour().equals(getColour())) {
                    break;
                } else if (isPiece(to,board)){
                    movesArray.add(new Move(from, to));
                    break;
                } else {
                    movesArray.add(new Move(from, to));
                }
            }
        }

        //Building south branch.
        for(int i = 1; i != 8; i++){
            to = new Coordinates(from.getRow()+i, from.getCol());
            if (coordinateIsOnBoard(to)){
                if(isPiece(to, board) && board.get(to).getColour().equals(getColour())) {
                    break;
                } else if (isPiece(to,board)){
                    movesArray.add(new Move(from, to));
                    break;
                } else {
                    movesArray.add(new Move(from, to));
                }
            }
        }

        //Building east branch.
        for(int i = 1; i != 8; i++){
            to = new Coordinates(from.getRow(), from.getCol()+i);
            if (coordinateIsOnBoard(to)){
                if(isPiece(to, board) && board.get(to).getColour().equals(getColour())) {
                    break;
                } else if (isPiece(to,board)){
                    movesArray.add(new Move(from, to));
                    break;
                } else {
                    movesArray.add(new Move(from, to));
                }
            }

        }

        //Building west branch.
        for(int i = 1; i != 8; i++){
            to = new Coordinates(from.getRow(), from.getCol()-i);
            if (coordinateIsOnBoard(to)){
                if(isPiece(to, board) && board.get(to).getColour().equals(getColour())) {
                    break;
                } else if (isPiece(to,board)){
                    movesArray.add(new Move(from, to));
                    break;
                } else {
                    movesArray.add(new Move(from, to));
                }
            }

        }

        return movesArray;
    }


    private boolean isPiece(Coordinates to, Board board) {
        return (board.get(to) != null);
    }

    private boolean coordinateIsOnBoard(Coordinates to) {
        return (to.getRow() >= 0 && to.getRow() <= 7 && to.getCol() >= 0 && to.getCol() <= 7);
    }

}
