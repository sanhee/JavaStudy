package ModernJava.ch1;


class CalculatorService {
    public int calculate(char cal, int num1, int num2) {
        if(cal == '+') {
            return num1 + num2;
        }
        else if(cal == '-'){
            return num1 - num2;
        }
        else if(cal == '*'){
            return num1 * num2;
        }
        else if(cal == '/'){
            return num1 / num2;
        }
        else
            throw new IllegalArgumentException("Unknown calculation: "+cal);
    }
}

public class OopAnotherExample{

    public static void main(String[] args) {

        final CalculatorService calculatorService = new CalculatorService();

        final int additionResult = calculatorService.calculate('+',1, 1);
        System.out.println(additionResult);

        //m 추가 요구 사항으로 뺄셈 기능이 필요하다면?
        final int subtractionResult = calculatorService.calculate('-',1, 1);
        System.out.println(subtractionResult);

        //m 요구사항이 자꾸 늘어나면 코드가 점점 길어짐
        final int multiplicationResult = calculatorService.calculate('*',1, 1);
        System.out.println(multiplicationResult);

        //m ...
        final int divisionResult = calculatorService.calculate('/',8, 4);
        System.out.println(divisionResult);

    }
}