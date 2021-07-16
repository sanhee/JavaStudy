package JavaStandard.ch09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularPractice {
    public static void main(String[] args) {

        String originString = "Once you see all those animals, you should feel better";
        String changeWord = "you";
        StringBuffer sb = new StringBuffer();

        Pattern p = Pattern.compile(changeWord);
        Matcher matcher = p.matcher(originString);

        while (matcher.find()) {
            matcher.appendReplacement(sb, "***");
        }
        matcher.appendTail(sb);

        System.out.println(sb.toString());


    }
}
