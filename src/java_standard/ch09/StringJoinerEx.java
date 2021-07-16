package JavaStandard.ch09;

import java.util.StringJoiner;

public class StringJoinerEx {
    public static void main(String[] args) {
        String abc = "abc";
        String e = abc.concat("def");

        String[] array = e.split("");


        StringJoiner strJoiner = new StringJoiner("|", "[", "]");
        for (String str : array) {
            strJoiner.add(str);
        }
        System.out.println(strJoiner);

        String test = "abcdeb";
        int index = test.indexOf("b");
        int index2 = test.lastIndexOf("b"); // 뒤에서부터 읽네 ㅇㅋ
        System.out.println(index);
        System.out.println(index2);

    }
}
