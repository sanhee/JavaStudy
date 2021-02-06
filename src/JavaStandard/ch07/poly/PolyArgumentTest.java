package JavaStandard.ch07.poly;

import java.util.Vector;

class Product{
    int price;
    int bonusPoint;
    Product(int price){
        this.price = price;
        this.bonusPoint = price/10;
    }
}
class Computer extends Product{
    Computer() {
        super(100);
    }

    @Override
    public String toString() {
        return "Computer";
    }
}
class SmartPhone extends Product{
    SmartPhone(){
        super(500);
    }

    @Override
    public String toString() {
        return "SmartPhone";
    }
}

class Buyer{
    private int haveMoney = 1000;
    private int havePoint = 0;
    private Vector<Product> item = new Vector<Product>();
    private int sum = 0;
    private StringBuilder buyList = new StringBuilder();

    void Buy(Product p){
        haveMoney -= p.price;
        havePoint += p.bonusPoint;
        item.add(p);
    }

    void Summary(){
        if (item.isEmpty()) {
            return;
        }
        for (Product product : item) {
            Product p = (Product) product;
            sum += p.price;
            buyList.append(p);
        }
        System.out.println("지금까지 구매한 총 금액:"+sum);
        System.out.println("지금까지 구매한 품목:"+buyList);
    }

}

public class PolyArgumentTest {
    public static void main(String[] args) {

        Buyer b = new Buyer();

        Product com = new Computer();
        b.Buy(com);
        b.Buy(new SmartPhone());
        b.Summary();
    }
}
