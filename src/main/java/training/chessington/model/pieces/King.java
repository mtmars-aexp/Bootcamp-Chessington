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

        for (int i = -1; i <= 1; i++) {

            for (int j = -1; j <= 1; j++) {

                if (i == 0 && j == 0) {
                    continue;
                } else {
                    Coordinates to = new Coordinates(from.getRow() + i, from.getCol() + j); //One space up, one space left.
                    if (isCoordinateValid(to, board)) {
                        movesArray.add(new Move(from, to));
                    }
                }

            }

        }

        return movesArray;
    }

    public boolean isCoordinateValid(Coordinates to, Board board) {
        if (to.getRow() >= 0 && to.getRow() <= 7 && to.getCol() >= 0 && to.getCol() <= 7) {

            if (board.get(to) == null) {
                return true;
            }

            return !board.get(to).getColour().equals(getColour());

        }
        return false;
    }


}
