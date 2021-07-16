package JavaStandard.ch09;

public class CloneEx1 {
    static class Point implements Cloneable {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" + "x=" + x + ", y=" + y + '}';
        }

        public Point clone33332() { // 상속관계가 없는 다른 클래스에서 clone을 사용하기 위해서 modifier 를 public으로 변경해주었다.
            Object obj = null;
            try {
                obj = super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return (Point) obj;
        }
    }

    public static void main(String[] args) {

        Point original = new Point(3, 5);
        Point copy = original.clone33332(); // 복제
        System.out.println(original);
        System.out.println(copy);

        System.out.println("==================");

        System.out.println("original.hashCode(): " + original.hashCode());
        System.out.println("copy.hashCode(): " + copy.hashCode());

    }

}
