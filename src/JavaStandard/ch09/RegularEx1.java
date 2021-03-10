package JavaStandard.ch09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//m 드디어 정규표현식 공부한다 신나!
public class RegularEx1 {
    public static void main(String[] args) {
        String[] data = {"bat", "baby","bonus,","cA","c0","car","combat","count","data","disc"};

        Pattern pattern = Pattern.compile("c[a-z]*"); // c로 시작하는 소문자 영단어
        for(int i =0; i< data.length; i++){
            Matcher m = pattern.matcher(data[i]);
            if(m.matches()){
                System.out.println(data[i]+",");
            }

        }
    }
}
