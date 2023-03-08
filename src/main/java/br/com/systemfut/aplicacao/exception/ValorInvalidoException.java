package br.com.systemfut.aplicacao.exception;
/**
 * Classe de excecao que sao geradas nesse arquivo
 * @author Murilo Bioni Caruso
 * @version 1.1
 * @since 2023
 */
public class ValorInvalidoException extends RuntimeException {
    public ValorInvalidoException(String message) {
        super(message);
    }
}
