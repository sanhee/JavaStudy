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

public class OopAndFpExample{

    public static void main(String[] args) {

        FpCalculatorService fpCalculatorService =new FpCalculatorService();

        final Calculation addition = (num1,num2)->{return num1+num2;};

        System.out.println(" addition: "+fpCalculatorService.calculate(addition,11,4));
        System.out.println(" subtraction: "+fpCalculatorService.calculate((num1,num2)->num1-num2,11,1));
        System.out.println(" Multiplication: "+fpCalculatorService.calculate((n1,n2)->n1*n2,11,2));
        System.out.println(" Division: "+fpCalculatorService.calculate((int n1,int n2)->n1/n2,20,4));

        System.out.println(" custom calc: "+fpCalculatorService.calculate((n1,n2)->((n1+n2)*2),20,4));

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