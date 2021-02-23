package Design.FactoryMethodPattern.ex3.unit;

import Design.FactoryMethodPattern.ex3.Point;
import Design.FactoryMethodPattern.ex3.UnitColor;
import Design.FactoryMethodPattern.ex3.UnitType;

public abstract class Piece {
    private final UnitColor color; // Piece 색상
    private final Point point; // Piece 좌표정보

    public Piece() {
        this(UnitColor.WHITE);
    }

    public Piece(UnitColor color) {
        this.color = color;
        this.point = new Point(1,2);
    }

    public boolean isColor(UnitColor color) {
        return this.getColor().equals(color);
    }

    public UnitColor getColor() {
        return color;
    }

    public Point getPoint() {
        return point;
    }

    public char getRepresentation() {
        return UnitType.getMark(this.color,this.getClass().getSimpleName());
    }

}