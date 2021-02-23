package Design.FactoryMethodPattern.ex3.unit;

import Design.FactoryMethodPattern.ex3.UnitColor;
import Design.FactoryMethodPattern.ex3.UnitType;

public class PieceFactory {

    public Piece createWhite(UnitType unitType)  {
        Piece piece = null;
        final UnitColor WHITE = UnitColor.WHITE;
        switch (unitType) {
            case KNIGHT: //m switch 문에서 열거형 타입 생략
                piece = new Knight(UnitColor.WHITE);
                break;
            case PAWN:
                piece = new Pawn(UnitColor.WHITE);
                break;
        }
        return piece;
    }
    public Piece createBlack(UnitType unitType)  {
        Piece piece = null;
        switch (unitType) {
            case KNIGHT: //m switch 문에서 열거형 타입 생략
                piece = new Knight(UnitColor.BLACK);
                break;
            case PAWN:
                piece = new Pawn(UnitColor.BLACK);
                break;
        }
        return piece;
    }
}
