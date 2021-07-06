package enums;

import java.util.function.Function;

public class Practice2 {
    enum CalculatorType{
        CALC_A(value -> value),
        CALC_B(value -> value*7),
        CALC_C(value -> value*2),
        CALC_ETC(value -> 0L);

        private Function<Long, Long> expression;

        CalculatorType(Function<Long, Long> expression) {
            this.expression = expression;
        }
        public long calculate(long value){
            return expression.apply(value);
        }
    }

    public static void main(String[] args) {
        CalculatorType type = CalculatorType.CALC_B;
        long originValue = 10000L;
        long result = type.calculate(originValue);
        System.out.println(result);
    }


}
