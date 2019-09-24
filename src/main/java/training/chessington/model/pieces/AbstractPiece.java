package training.chessington.model.pieces;

import training.chessington.model.PlayerColour;

public abstract class AbstractPiece implements Piece {

    protected final Piece.PieceType type;
    protected final PlayerColour colour;

    protected AbstractPiece(Piece.PieceType type, PlayerColour colour) {
        this.type = type;
        this.colour = colour;
    }

    public Piece.PieceType getType() {
        return type;
    }

    public PlayerColour getColour() {
        return colour;
    }

    public String toString() {
        return colour.toString() + " " + type.toString();
    }
}
