package br.com.compiladores.main;

import br.com.compiladores.exceptions.IsiLexicalException;
import br.com.compiladores.exceptions.IsiSyntaxException;
import br.com.compiladores.lexico.IsiScanner;
import br.com.compiladores.lexico.Token;
import br.com.compiladores.parser.IsiParser;

public class MainCase {
    public static void main(String[] args) {
        String hash;
        hash = "#";
        try {
            IsiScanner sc = new IsiScanner("input.isi");
            IsiParser pa = new IsiParser(sc);
            Token token = null;
        //    try{
                pa.E();  
           // } catch(Exception ex){
            //    System.out.println("o programa rodou perfeitamente");
           // }
          
        } catch (IsiLexicalException ex) {
            System.out.println("Lexical ERROR " + ex.getMessage());

        } catch (IsiSyntaxException ex) {
            System.out.println("Sintatico ERROR " + ex.getMessage());

        }
    }
}
/* Picked up _JAVA_OPTIONS: -Xmx512M
---DEBUG---
㋡abc+123*456/12.0%#

-----------
Token [type= COMEÇO DA LINHA, text= ㋡]
Token [type= ARITIMETICO, text= *]
Token [type= INTEIRO, text= 456]
Token [type= ARITIMETICO, text= /]
Token [type= DOUBLE, text= 12.0]
Token [type= ENCERRA PROGRAMA, text= #]*/

//  do {
           //     token = sc.nextToken();
            //     if (token != null) {
             //        System.out.println(token);
              //        if (token.getText().contains(hash)) {
              //            System.out.println("fim de programa");
              //            break;
            //         }
  //
            //      }
          /// } while (token != null);