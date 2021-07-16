package etc;


//https://riptutorial.com/java/example/14441/java-closures-with-lambda-expressions-


//m Note that Java does not support true closures.
//m The problem is that this breaks the design contract for the IntUnaryOperator interface
//m which states that instances should be functional and stateless.
//m If such a closure is passed to built-in functions that accept functional objects,
//m it is liable to cause crashes or erroneous behavior.
//m Closures that encapsulate mutable state should be implemented as regular classes. For example.

import java.util.function.IntUnaryOperator;

public class AccumulatorGenerator {
    private int value = 0;

    public IntUnaryOperator createAccumulator() {
        IntUnaryOperator accumulate = (x) -> {
            value += x;
            return value;
        };
        return accumulate;
    }


    public static void main(String[] args) {

        AccumulatorGenerator ac = new AccumulatorGenerator();
        IntUnaryOperator op = ac.createAccumulator();

        int num = op.applyAsInt(1);
        int num2 = op.applyAsInt(2);

        System.out.println(num);
        System.out.println(num2);
    }

}
