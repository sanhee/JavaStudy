package enums;

public class Practice2 {
    enum CalculatorType{
        CALC_A{
            long calculate(long value){return value;}
        },
        CALC_B{
            long calculate(long value){return value*7;}
        },
        CALC_C{
            long calculate(long value){return value*2;}
        },
        CALC_ETC{
            long calculate(long value){return 0L;}
        };
        abstract long calculate(long value);
    }

    public static void main(String[] args) {
        CalculatorType type = CalculatorType.CALC_B;
        long originValue = 10000L;
        long result = type.calculate(originValue);
        System.out.println(result);
    }


}
