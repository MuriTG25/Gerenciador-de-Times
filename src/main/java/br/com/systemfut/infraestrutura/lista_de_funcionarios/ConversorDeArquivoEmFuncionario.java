package br.com.systemfut.infraestrutura.lista_de_funcionarios;

import br.com.systemfut.infraestrutura.lista_de_funcionarios.conversor.ConversorDeArquivo;
import br.com.systemfut.infraestrutura.lista_de_funcionarios.tipo_funcionario.ConversorDeFuncionario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
/**
 * Classe de importacao e exportacao de arquivos externos para lista de funcionarios
 * @author Murilo Bioni Caruso
 * @version 1.1
 * @since 2023
 */

public class ConversorDeArquivoEmFuncionario implements LeitorDeArquivo {

    @Override
    public void importaArquivoParaListaDeFuncionarios(String nomeArquivo, ConversorDeFuncionario
            tipoFuncionario, ConversorDeArquivo tipoArquivo) throws FileNotFoundException {
        List<String> lista = tipoArquivo.ImportadorDeArquivoEmList(nomeArquivo);
        tipoFuncionario.criaFuncionarioPeloImporte(lista);
    }

    @Override
    public void leArquivoNaTela(String nomeArquivo, ConversorDeArquivo tipoArquivo) throws FileNotFoundException {
        List<String> lista = tipoArquivo.ImportadorDeArquivoEmList(nomeArquivo);
        imprimiNaTela(lista);
    }
//metodo ainda não implementado
    @Override
    public void exportaListaFuncionariosParaArquivo(String nomeArquivo, ConversorDeFuncionario
            tipoFuncionario, ConversorDeArquivo tipoArquivo) throws IOException {
        List<String[]> lista = tipoFuncionario.exportaFuncionariosParaList();
        tipoArquivo.exportaListEmArquivoExterno(lista,nomeArquivo);
    }

    private void imprimiNaTela(List<String> lista) {
        for (int i = 0; i < lista.size(); i = i+3) {
            String nome = lista.get(i);
            String CPF = lista.get(i+1);
            String cargo = lista.get(i+2);
            System.out.format("Nome: %s CPF: %s Posicao/Cargo: %s \n"
                    ,nome,CPF,cargo);
        }
    }
}


