package JavaStandard.ch07;

public class PolyArgumentTest {

    public static void main(String[] args) {

        Buyer buyer = new Buyer();

        buyer.Buy(new Computer());
        buyer.Buy(new Book());
        buyer.Buy(new Hamburger());

        System.out.println("남은 돈"+buyer.getMoney());
        System.out.println("보너스"+buyer.getBonusPoint());
    }
}

class Product {
    int price;
    int bonusPoint;
    static int test = 1;

    Product(int price){
        this.price = price;
        this.bonusPoint += price/10;
    }
}

class Computer extends Product {
    Computer(){
        super(100);
    }

    @Override
    public String toString() {
        return "Computer";
    }
}
class Book extends Product {
    Book(){
        super(200);
    }
    @Override
    public String toString() {
        return "Book";
    }
}
class Hamburger extends Product{
    Hamburger(){
        super(300);
    }
    @Override
    public String toString() {
        return "Hamburger";
    }
}


class Buyer {
    private int money = 1000;  //m 소유 금액
    private int bonusPoint = 0; // 보너스 금액

    void Buy(Product p){
        if(money < p.price){
            System.out.println("돈 없어서 못삼.");
            return;
        }
        money -= p.price;
        bonusPoint += p.bonusPoint;
        System.out.println(p+" 을/를 구매하셨습니다.");
    }

    public int getMoney() {
        return money;
    }

    public int getBonusPoint() {
        return bonusPoint;
    }
}