package CodingEverybody.ProjectOOP;

class Accounting{
    // 공급가액
    public static double valueOfSupply;
    // 부가가치세율
    public static double vatRate = 0.1;

    public static double getVAT() {
        return valueOfSupply * vatRate;
    }
    public static double getTotal() {
        return valueOfSupply + getVAT();
    }
}

public class AccountingApp {

    //m 연관된 메소드끼리 그룹화

    public static void main(String[] args) {
        Accounting.valueOfSupply = 10000.0;

        System.out.println("Value of supply : " + Accounting.valueOfSupply);
        System.out.println("VAT : " + Accounting.getVAT());
        System.out.println("Total : " + Accounting.getTotal());
    }
}