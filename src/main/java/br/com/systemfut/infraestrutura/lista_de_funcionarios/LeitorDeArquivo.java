package br.com.systemfut.infraestrutura.lista_de_funcionarios;

import br.com.systemfut.infraestrutura.lista_de_funcionarios.conversor.ConversorDeArquivo;
import br.com.systemfut.infraestrutura.lista_de_funcionarios.tipo_funcionario.ConversorDeFuncionario;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Interface que auxilia a importacao e exportacao de arquivos externos para lista de funcionarios
 * @author Murilo Bioni Caruso
 * @version 1.1
 * @since 2023
 */

public interface LeitorDeArquivo {
    void importaArquivoParaListaDeFuncionarios(String fileName, ConversorDeFuncionario
            tipoFuncionario,ConversorDeArquivo tipoArquivo) throws FileNotFoundException;
    void leArquivoNaTela(String fileName, ConversorDeArquivo tipoArquivo) throws FileNotFoundException;
    void exportaListaFuncionariosParaArquivo(String fileName, ConversorDeFuncionario
            tipoFuncionario,ConversorDeArquivo tipoArquivo) throws IOException;
}
