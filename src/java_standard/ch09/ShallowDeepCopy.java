package JavaStandard.ch09;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
}

class Circle implements Cloneable {
    Point p; // 원점
    double r; // 반지름

    Circle(Point p, double r) {
        this.p = p;
        this.r = r;
    }

    public Circle shallowCopy() { //m 얕은 복사, 공변  반환타입
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return (Circle) obj; // 공변  반환타입
    }

    public Circle deepCopy() { //m 깊은 복사
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        Circle c = (Circle) obj;
        c.p = new Point(this.p.x, this.p.y);
        return c; // 공변  반환타입
    }

    @Override
    public String toString() {
        return "Circle{" + "p=" + p + ", r=" + r + '}';
    }

    public Circle newinstanceCopiedByCircle() {
        return new Circle(new Point(this.p.x, this.p.y), this.r);
    }

}

// 얕은복사, 깊은 복사 실습 예제
public class ShallowDeepCopy {
    public static void main(String[] args) {
        Circle c1 = new Circle(new Point(1, 1), 2.0);
        Circle c2 = c1.shallowCopy();
        Circle c3 = c1.deepCopy();
        Circle c4 = c1.newinstanceCopiedByCircle();

        System.out.println("c1=" + c1);
        System.out.println("c2=" + c2);
        System.out.println("c3=" + c3);
        System.out.println("c4=" + c4);
        c2.r = 4.0;
        c1.p.x = 9;
        c1.p.y = 9;
        c4.p.x = 999;

        System.out.println("변경 후.");
        System.out.println("c1=" + c1);
        System.out.println("c2=" + c2);
        System.out.println("c3=" + c3);
        System.out.println("c4=" + c4);
    }

}
