package analiseLexica;

import analiseLexica.Parser;
import analiseLexica.Scanner;
import java_cup.parser;
import java_cup.runtime.Symbol;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;




public class TestadorSintatico {
	static String filepath1 = "C:\\Users\\Gabriela\\eclipse-workspace\\Projeto-Compiladores\\Compiladores\\src\\analiseLexica\\ForTest.txt";
	


    public static void main(String[] args) throws IOException {
    	Scanner scanner = null;
    	
		try {
			scanner = new Scanner(new BufferedReader(new FileReader(filepath1)));
			System.out.println(scanner);

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		

		parser parser1 = new parser((java_cup.runtime.Scanner) scanner);
		Symbol s = null;
		
		try {
			s = parser1.parse();
			System.out.println("The compilation process was successfully finished!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

    	
    }
}
    