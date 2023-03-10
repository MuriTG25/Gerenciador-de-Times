package br.com.systemfut.infraestrutura.lista_de_funcionarios.conversor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
/**
 * Interface que auxilia a importacao e exportacao de arquivos externos para uma lista de strings
 * @author Murilo Bioni Caruso
 * @version 1.1
 * @since 2023
 */

public interface ConversorDeArquivo {
    List<String> ImportadorDeArquivoEmList(String nomeArquivo) throws FileNotFoundException;
    void exportaListEmArquivoExterno(List<String[]> lista, String nomeArquivo) throws IOException;
}
