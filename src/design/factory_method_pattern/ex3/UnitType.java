package design.factory_method_pattern.ex3;

public enum UnitType {
    PAWN('P'),
    ROOK('R'),
    KNIGHT('N'),
    BISHOP('B'),
    QUEEN('Q'),
    KING('K'),
    NONE('.');

    private final char unitRepresentation;

    UnitType(char mark) {
        this.unitRepresentation = mark;
    }

    public static char getMark(UnitColor color, String unitClassName) {
        char mark = ' ';

        switch (color) {
            case BLACK:
                mark = Character.toUpperCase(UnitType.valueOf(unitClassName.toUpperCase()).unitRepresentation);
                break;
            case WHITE:
                mark = Character.toLowerCase(UnitType.valueOf(unitClassName.toUpperCase()).unitRepresentation);
                break;
        }
        return mark;
    }
}
