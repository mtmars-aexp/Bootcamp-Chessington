package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class King extends AbstractPiece {
    public King(PlayerColour colour) {
        super(PieceType.KING, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> movesArray = new ArrayList<>();

        Coordinates to = new Coordinates(from.getRow() - 1, from.getCol()); //One space up.
        if(isCoordinateValid(to, from, board)){
            movesArray.add(new Move(from, to));
        }

        to = new Coordinates(from.getRow() - 1, from.getCol() - 1); //One space up, one space left.
        if(isCoordinateValid(to, from, board)){
            movesArray.add(new Move(from, to));
        }

        to = new Coordinates(from.getRow(), from.getCol() -1); //Zero spaces up, one space left.
        if(isCoordinateValid(to,from,board)){
            movesArray.add(new Move(from, to));
        }

        to = new Coordinates(from.getRow() + 1, from.getCol() -1); //One space down, one space left.
        System.out.println(to.getRow() + " " + to.getCol());
        if(isCoordinateValid(to,from,board)){
            movesArray.add(new Move(from, to));
        }

        to = new Coordinates(from.getRow() + 1, from.getCol()); //One space down.
        if(isCoordinateValid(to,from,board)){
            movesArray.add(new Move(from, to));
        }

        to = new Coordinates(from.getRow() + 1, from.getCol() + 1); //One space down, one space right.
        if(isCoordinateValid(to,from,board)){
            movesArray.add(new Move(from, to));
        }

        to = new Coordinates(from.getRow(), from.getCol() + 1); //One space right.
        if(isCoordinateValid(to,from,board)){
            movesArray.add(new Move(from, to));
        }

        to = new Coordinates(from.getRow() - 1, from.getCol() + 1); //One space up, one space right.
        if(isCoordinateValid(to,from,board)){
            movesArray.add(new Move(from, to));
        }

        return movesArray;
    }

    public boolean isOnSouthernEdge(Coordinates from){
        return from.getRow() == 7;
    }

    public boolean isOnNorthernEdge(Coordinates from){
        return from.getRow() == 0;
    }

    public boolean isOnEasternEdge(Coordinates from){
        return from.getCol() == 7;
    }

    public boolean isOnWesternEdge(Coordinates from){
        return from.getCol() == 0;
    }


    public boolean isCoordinateValid(Coordinates to, Coordinates from, Board board){
        if (to.getRow() >= 0 && to.getRow() <= 7 && to.getCol() >= 0 && to.getCol() <= 7){
            if (board.get(to) == null){
                return true;
            } else {
                if (board.get(to).getColour().equals(board.get(from).getColour())){
                    return false;
                } else {
                    return true;
                }
            }
        } else {
            return false;
        }
    }


}
