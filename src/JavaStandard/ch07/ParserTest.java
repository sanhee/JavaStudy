package JavaStandard.ch07;

interface Parseable{
    // 구문 분석작업을 수행한다.
    public abstract void parse(String filename);
}
class ParserManager{
    // 리턴타입이 Parseable 인터페이스이다.
    public static Parseable getParser(String type){
        if(type.equals("XML")){
            return new XMLParser_();
        }else{
            Parseable p = new HTMLParser();
            return p;
        }

    }
}

class XMLParser_ implements Parseable{
    @Override
    public void parse(String filename) {
        System.out.println(filename+"- XML parsinng completed.");
    }
}
class HTMLParser implements Parseable{
    @Override
    public void parse(String filename) {
        System.out.println(filename+"- HTML parsinng completed.");
    }
}
public class ParserTest {
    public static void main(String[] args) {

        Parseable parser = ParserManager.getParser("HTML");
        parser.parse("document.xml");
        parser = ParserManager.getParser("XML");
        parser.parse("document2.xml");

    }
}
