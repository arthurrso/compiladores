package lexicalAnalyzes;

import java.io.File;
import java.nio.file.Paths;

public class LexicalGenerator {
	
	public static void geraLexer(String path){
	    File arquivo = new File(path);
	    jflex.Main.generate(arquivo);
	}

    public static void main(String[] args) {

        String rootPath = Paths.get("").toAbsolutePath(). toString();
        String subPath = "/src/analiseLexica/";

        String file = rootPath + subPath + "Linguagem.lex";

        geraLexer(file);
    }
}
