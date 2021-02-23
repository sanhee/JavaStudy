package Design.FactoryMethodPattern.ex3;

import Design.FactoryMethodPattern.ex3.unit.Piece;
import Design.FactoryMethodPattern.ex3.unit.PieceFactory;

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
