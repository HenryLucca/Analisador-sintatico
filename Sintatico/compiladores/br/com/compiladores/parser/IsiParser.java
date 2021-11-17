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
        T();
        El();

    }

    public void El() {
        if (token.getType() != Token.TK_END) {
            token = scanner.nextToken();
            if (token != null) {
                OP();
                T();
                El();
            }

        } else {

        }

    }

    public void T() {
        token = scanner.nextToken();
        if (token.getType() != Token.TK_END) {
            if (token.getType() != Token.TK_IDENTIFIER && token.getType() != Token.TK_OPERATOR
                    && token.getType() != Token.TK_FLOAT && token.getType() != Token.TK_NUMBER
                    && token.getType() != Token.TK_OP) {
                throw new IsiSyntaxException("ID or NUMBER Expected!, found " + Token.TK_TEXT[token.getType()] + " ("
                        + token.getText() + ") at LINE "+token.getLinha()+" at COLUMN "+token.getColuna());
            }
        } else {

        }
    }

    public void OP() {
        if (token.getType() != Token.TK_ARIT && token.getType() != Token.TK_OPERATOR
                && token.getType() != Token.TK_OP) {
            throw new IsiSyntaxException(
                    "Operator Expected, found " + Token.TK_TEXT[token.getType()] + " (" + token.getText() + ")  at LINE "+token.getLinha()+" at COLUMN "+token.getColuna());
        } else {

        }
    }
}
