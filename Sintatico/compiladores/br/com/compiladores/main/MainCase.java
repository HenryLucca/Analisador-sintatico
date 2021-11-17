package br.com.compiladores.main;

import br.com.compiladores.exceptions.IsiLexicalException;
import br.com.compiladores.exceptions.IsiSyntaxException;
import br.com.compiladores.lexico.IsiScanner;
import br.com.compiladores.parser.IsiParser;

public class MainCase {
    public static void main(String[] args) {
        try {
            IsiScanner sc = new IsiScanner("input.isi");
            IsiParser pa = new IsiParser(sc);

            pa.E();

            System.out.println("O programa rodou com Exitô");

        } catch (IsiLexicalException ex) {
            System.out.println("Lexical ERROR " + ex.getMessage());

        } catch (IsiSyntaxException ex) {
            System.out.println("Sintatico ERROR " + ex.getMessage());

        }
    }
}
