package JavaStandard.ch6;

public class VarArgsEx {
    public int test;

    public static void main(String[] args) {
        String[] cocoa = new String[]{"노을", "쿠퍼"};
        print(cocoa);
        print(); // 인자가 없어도 됨.
        print("우디", "제인");
        print("우디", "쿠퍼", "제인", "노을");
    }

    public static void print(String... strings) {
        for (String str : strings) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "VarArgsEx{" +
                "test=" + test +
                '}';
    }
}
