package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends AbstractPiece {
    public Bishop(PlayerColour colour) {
        super(PieceType.BISHOP, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {

        List<Move> movesArray = new ArrayList<>();

        Coordinates to = new Coordinates(from.getRow(), from.getCol());
        for(int i = 1; to.getCol() != 7; i++) {
            to = new Coordinates(from.getRow() - i, from.getCol() + i); //Up-right branch.
            if (coordinateIsOnBoard(to)) {
                if (isPiece(to, board)) {
                    break;
                }
                movesArray.add(new Move(from, to));
            }
        }

        to = new Coordinates(from.getRow(), from.getCol());
        for(int i = 1; to.getCol() != 0; i++) {
            to = new Coordinates(from.getRow() - i, from.getCol() - i); //Up-left branch.
            if (coordinateIsOnBoard(to)) {
                if (isPiece(to, board)) {
                    break;
                }
                movesArray.add(new Move(from, to));
            }
        }

        to = new Coordinates(from.getRow(), from.getCol());
        for(int i = 1; to.getCol() != 7; i++) {
            to = new Coordinates(from.getRow() + i, from.getCol() + i); //Down-right branch.
            if (coordinateIsOnBoard(to)) {
                if (isPiece(to, board)) {
                    break;
                }
                movesArray.add(new Move(from, to));
            }
        }

        to = new Coordinates(from.getRow(), from.getCol());
        for(int i = 1; to.getCol() != 0; i++) {
            to = new Coordinates(from.getRow() + i, from.getCol() - i); //Down-left branch.
            if (coordinateIsOnBoard(to)) {
                if (isPiece(to, board)) {
                    break;
                }
                movesArray.add(new Move(from, to));
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

