package CodingEverybody.ProjectOOP;

class Accounting{
    public double valueOfSupply;
    public static double vatRate = 0.1; //m 현재 모든 인스턴스가 사용 및 공유하는 변수로 클래스 변수, static 변수로 사용하는 것이 메모리쪽에서도 절약이되며, 유지보수 측면에서도 좋음
    public Accounting(double valueOfSupply) {
        this.valueOfSupply = valueOfSupply;
    }
    public double getVAT() {
        return valueOfSupply * vatRate;
    }
    public double getTotal() {
        return valueOfSupply + getVAT();
    }
}
public class AccountingApp {
    public static void main(String[] args) {
        Accounting a1 = new Accounting(10000.0);

        Accounting a2 = new Accounting(20000.0);

        System.out.println("Value of supply : " + a1.valueOfSupply);
        System.out.println("Value of supply : " + a2.valueOfSupply);

        System.out.println("VAT : " + a1.getVAT());
        System.out.println("VAT : " + a2.getVAT());

        System.out.println("Total : " + a1.getTotal());
        System.out.println("Total : " + a2.getTotal());


    }
}