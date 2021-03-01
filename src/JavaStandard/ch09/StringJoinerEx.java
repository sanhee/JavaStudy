package JavaStandard.ch09;

import java.util.StringJoiner;

public class StringJoinerEx {
    public static void main(String[] args) {
        String abc = "abc";
        String e = abc.concat("def");

        String[] array = e.split("");


        StringJoiner strJoiner = new StringJoiner("|","[","]");
        for(String str : array){
            strJoiner.add(str);
        }
        System.out.println(strJoiner);


    }
}
