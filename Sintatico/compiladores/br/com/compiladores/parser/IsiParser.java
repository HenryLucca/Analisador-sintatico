package br.com.compiladores.parser;

import br.com.compiladores.exceptions.IsiSyntaxException;
import br.com.compiladores.lexico.IsiScanner;
import br.com.compiladores.lexico.Token;

public class IsiParser {

    private IsiScanner scanner;
    private Token token;

    public IsiParser(IsiScanner scanner) {
        this.scanner = scanner;
    }

    public void E() {
        token = scanner.nextToken();
        if (token.getType() == Token.TK_END) {
          //  System.out.println(token);
        }
        T();
        El();

    }

    public void El() {
        token = scanner.nextToken();
        if (token.getType() != Token.TK_END) {
            OP();
            T();
            E();
        }else{
            System.out.println(token);
        }

    }

    public void T() {
        token = scanner.nextToken();
        System.out.println(token);
        if (token.getType() != Token.TK_IDENTIFIER && token.getType() != Token.TK_OPERATOR
                && token.getType() != Token.TK_FLOAT && token.getType() != Token.TK_NUMBER) {
            throw new IsiSyntaxException("ID or NUMBER Expected! ");
        }
    }

    public void OP() {
        if (token.getType() == Token.TK_OPERATOR) {
            throw new IsiSyntaxException("Operator Expected");
        }
    }
}
