package lexicalAnalyzes;

import java.io.IOException;
import java.io.StringReader;

public class LexiTest {

    public static void main(String[] args) throws IOException {

        String expr2 = "6.986 + 52 + 45 * 942 / 32 * 5 == D <= 895.1211213 - "
        		+ "4 * ! > false true --";

        LexiAnalyz lexical2 = new LexiAnalyz(new StringReader(expr2));
        lexical2.yylex();

    }
}
