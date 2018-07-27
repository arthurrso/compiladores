package sintaticalAnalyzes;
import java.io.File;
import java.nio.file.Paths;



public class SintatcTest {

	public static void geraLexer(String path){
	    File arquivo = new File(path);
	    jflex.Main.generate(arquivo);
	}

    public static void main(String[] args) throws Exception {

        String raiz = Paths.get("").toAbsolutePath(). toString();
        String caminhoDaPasta = "/Testes/";
        String CaminhoTotalArquivo = raiz + caminhoDaPasta + "TesteDeSintatica.go";
	    File arquivo = new File(CaminhoTotalArquivo);
        
        
        Parser parser = new Parser(new ScannerLex(new java.io.FileInputStream(arquivo)));
    	
    	int contador = 0;
    	
    	try {
    	parser.parse();
    	}catch (Exception ex){
        	ex.getMessage();
        	contador++;
    	}
    	
    	if (contador == 0){
    		System.out.println("Não foram encontrados erros sintáticos");
    	}else {
    		System.out.println("Error");
    	}

    	
    }
}
    