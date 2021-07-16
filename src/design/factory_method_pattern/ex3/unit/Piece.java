package design.factory_method_pattern.ex3.unit;

import design.factory_method_pattern.ex3.UnitColor;
import design.factory_method_pattern.ex3.UnitType;


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
