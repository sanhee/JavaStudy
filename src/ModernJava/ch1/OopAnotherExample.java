package ModernJava.ch1;

interface Calculation {
    int calculate(int num1, int num2);
}

//m 전략패턴
class Addition implements Calculation {
    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}
class Subtraction implements Calculation {
    @Override
    public int calculate(int num1, int num2) {
        return num1 - num2;
    }
}
class Multiplication implements Calculation {
    @Override
    public int calculate(int num1, int num2) {
        return num1 * num2;
    }
}
class Division implements Calculation {
    @Override
    public int calculate(int num1, int num2) {
        return num1 / num2;
    }
}


class CalculatorService {
    private final Calculation calculation;

    public CalculatorService(Calculation calculation) {
        this.calculation = calculation;
    }

    public int calculate(int num1, int num2) {
      return this.calculation.calculate(num1,num2);
    }
}


public class OopAnotherExample{

    public static void main(String[] args) {

        final CalculatorService calculatorService = new CalculatorService(new Addition());

        final int additionResult = calculatorService.calculate(1, 1);
        System.out.println(additionResult);

        //m 추가 요구 사항으로 뺄셈 기능이 필요하다면?
        final int subtractionResult = calculatorService.calculate(1, 1);
        System.out.println(subtractionResult);

        //m 요구사항이 자꾸 늘어나면 코드가 점점 길어짐
        final int multiplicationResult = calculatorService.calculate(1, 1);
        System.out.println(multiplicationResult);

        //m ...
        final int divisionResult = calculatorService.calculate(8, 4);
        System.out.println(divisionResult);

    }
}