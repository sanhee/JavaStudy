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
    private final Calculation calculation2;


    public CalculatorService(Calculation calculation, Calculation calculation2) {
        this.calculation = calculation;
        this.calculation2 = calculation2;
    }

    public int calculate(int num1, int num2) {
        if(num1 > 10 && num2 <num1){
            return this.calculation.calculate(num1,num2);
        }
        else{
            throw new IllegalArgumentException("Invalid input num1: "+num1+", num2: "+num2);
        }

    }

    public int compute(int num1, int num2) {
        if(num1 > 10 && num2 <num1){
            return this.calculation2.calculate(num1,num2);
        }
        else{
            throw new IllegalArgumentException("Invalid input num1: "+num1+", num2: "+num2);
        }

    }
}


public class OopAndFpExample{

    public static void main(String[] args) {

        final CalculatorService calculatorService = new CalculatorService(new Addition(),new Subtraction());

        /*
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

         */

        FpCalculatorService fpCalculatorService =new FpCalculatorService();
        System.out.println(" addition: "+fpCalculatorService.calculate(new Addition(),11,4));
        System.out.println(" subtraction: "+fpCalculatorService.calculate(new Subtraction(),11,1));
        System.out.println(" Multiplication: "+fpCalculatorService.calculate(new Multiplication(),11,2));
        System.out.println(" Division: "+fpCalculatorService.calculate(new Division(),20,4));

    }
}


class FpCalculatorService{

    public int calculate(Calculation calculation, int num1, int num2) {
        if(num1 > 10 && num2 <num1){
            return calculation.calculate(num1,num2);
        }
        else{
            throw new IllegalArgumentException("Invalid input num1: "+num1+", num2: "+num2);
        }
    }
}