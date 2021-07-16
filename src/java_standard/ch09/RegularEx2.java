package JavaStandard.ch09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx2 {
    public static void main(String[] args) {
        String[] data = {"김과장", "bat", "baby", "bonus,", "c.", "cA", "ca", "co", "c0", "c*", "car", "combat", "count", "data", "disc"};
        StringBuilder sb = new StringBuilder();
        String[] pattern = {".*",  //m 모든 문자열
                "^[가-힣]*$",   //m 한글 입력 허용
                "c[a-z]*", //m c[a-z]*: c로 시작하는 모든 소문자 문자열
                "c[a-z]",  //m c[a-z] : c로 시작하는 2개의 문자열
                "c[a-zA-Z]", //m c[a-zA-Z] : c로 시작하는 2개의 문자열(대소문자 비교안함)
                "c[a-zA-Z0-9]", //m c[a-zA-Z-0-9] : c로 시작하는 2개의 문자,숫자(대소문자 비교안함)
                "c.", //m c로 시작하는 2자리 문자열(숫자, 대소문자 다포함)
                "c.*", //m c로 시작하는 모든 문자열 (기호포함 )
                "c\\.", //m c.와 일치하는 문자열 '.'은 패턴작성에 사용되는 문자이므로 escape문자임 '\'를 함께 사용
                "c\\w", //m c로 시작하고 숫자와 영어로 조합된 두글자
                "c[0-9]",  //m c로 시작하고 뒤에 숫자
                "c\\d",  //m c로 시작하고 뒤에 숫자
                "c.*t", //m c로 시작하고 t로 끝나는 문자열
                "[b|c].*",
                ".*a.*", // 일단 총 3개임 . *a * 으로 해석 , a를 포함하는 0또는 그이상의 문자!
                ".*a.+", // 이것도 일단 총 3개인데, a를 포함하는 1또는 그이상의 문자라서 ca 같이 a로 끝나는 2자리는 안됨!
                "[b|c].{2}" //m [bc].{2} b또는 c로 시작하는 세 자리 문자열
        };

        for (int x = 0; x < pattern.length; x++) {
            Pattern p = Pattern.compile(pattern[x]);
            System.out.print("Pattern: " + pattern[x] + " 결과: ");
            for (int i = 0; i < data.length; i++) {
                Matcher matcher = p.matcher(data[i]);
                if (matcher.matches()) {
                    System.out.print(data[i] + ", ");
                }
            }
            System.out.println();
        }
    }
}
