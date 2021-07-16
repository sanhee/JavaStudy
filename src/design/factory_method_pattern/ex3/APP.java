package design.factory_method_pattern.ex3;

import design.factory_method_pattern.ex3.unit.Piece;
import design.factory_method_pattern.ex3.unit.PieceFactory;

public class APP {


    public static void main(String[] args) {
        PieceFactory pieceFactory = new PieceFactory();
        Piece pawn = pieceFactory.createBlack(UnitType.PAWN);
        Piece pawn2 = pieceFactory.createWhite(UnitType.PAWN);
        Piece knight = pieceFactory.createWhite(UnitType.KNIGHT);

        System.out.println(pawn.getRepresentation());
        System.out.println(pawn2.getRepresentation());
        System.out.println(knight.getRepresentation());
    }

}
