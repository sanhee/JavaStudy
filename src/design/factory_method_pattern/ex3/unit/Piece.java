package Design.FactoryMethodPattern.ex3.unit;

import Design.FactoryMethodPattern.ex3.UnitColor;
import Design.FactoryMethodPattern.ex3.UnitType;

public class Piece {
    private final UnitColor color; // Piece 색상

    public Piece(UnitColor color) {
        this.color = color;
    }

    public boolean isColor(UnitColor color) {
        return this.getColor().equals(color);
    }

    public UnitColor getColor() {
        return color;
    }

    public char getRepresentation() {
        return UnitType.getMark(this.color, this.getClass().getSimpleName());
    }

}
