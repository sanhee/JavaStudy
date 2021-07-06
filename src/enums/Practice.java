package enums;

import java.util.EnumSet;

public class Practice {

    enum Number {
        ONE(1), TWO(2), THREE(3), FOUR(4);

        private final int value;

        private Number(int number) {
            value = number;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        System.out.println("------------------------- allOf -------------------------");
        EnumSet<Number> enumSetAll =  EnumSet.allOf(Number.class);
        enumSetAll.forEach(System.out::println);

        System.out.println("------------------------- range (3~4) -------------------------");
        EnumSet<Number> enumSetRange =  EnumSet.range(Number.THREE, Number.FOUR);
        enumSetRange.forEach(System.out::println);

        System.out.println("------------------------- complementOf (3~4) -------------------------");
        EnumSet<Number> enumSetComplement=  EnumSet.complementOf(EnumSet.of(Number.THREE, Number.FOUR));
        enumSetComplement.forEach(System.out::println);

        System.out.println("------------------------- copyOf -------------------------");
        EnumSet<Number> enumSetCopy = EnumSet.copyOf(enumSetAll);
        enumSetCopy.forEach(System.out::println);

        System.out.println("------------------------- noneOf -------------------------");
        EnumSet<Number> enumSet = EnumSet.noneOf(Number.class);
        enumSet.add(Number.ONE);
        enumSet.add(Number.FOUR);
        enumSet.remove(Number.FOUR);

        enumSet.forEach(System.out::println);
    }
}
