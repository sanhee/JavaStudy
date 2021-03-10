package JavaStandard.ch09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx3 {
    public static void main(String[] args) {
        String source = "HP:011-1111-1111, HOME:02-999-9999";
        String pattern = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(source);

        int i = 0;
        while (m.find()) {
            System.out.println(++i + ": " + m.group() + "->" + m.group(1) +
                    ", " + m.group(2) + ", " + m.group(3));
        }
        /*
        정규식의 일부를 괄호로 나누어 묶어서 그룹화 할 수 있다.
        그룹화된 부분은 하나의 단위로 묶이는 셈이 되어서,
        한 번 또는 그 이상의 반복을 의미하는 '+'나 '*'가 뒤에 오면 그룹화 된 부분이 적용대상이 된다.

        위의 예제에서 (0\\d{1,2})-(\\d{3,4})-(\\d{4}) 은 괄호를 이용해서 정규식을 세 부분으로 나누었는데
        예제와 결과에서 알 수 있듯이 매칭되는 문자열에서 첫 번째 그룹은 group(1)로 두번째 그룹은 group(2)와 같이 호출함으로써 얻을 수 있다.
        group() 또는 group(0) 은 그룹을 ㅗ매칭된 무자열을 전체를 나누어지지 않은 채로 반환한다.

        find()는 주어진 소스 내에서 패턴과 일치하는 부분을 찾아내면 true를 반환하고 찾지 못하면 false를 반환한다.
        find()를 호출해서 패턴과 일치하는 부분을 찾아낸 다음,
        다시 find()를 호출하면 이전에 발견한 패턴과 일치하는 부분의 다음부터 다시 패턴매칭을 시작한다.
        */
    }
}
