package br.com.systemfut.infraestrutura.lista_de_funcionarios.tipo_funcionario;

import br.com.systemfut.dominio.funcionarios.Funcionarios;

import java.util.List;
/**
 * Interface que auxilia a importacao e exportacao de lista de
 * strings vinda de um arquivo externo para uma lista de Funcionarios
 * @author Murilo Bioni Caruso
 * @version 1.1
 * @since 2023
 */

public interface ConversorDeFuncionario {
    void criaFuncionarioPeloImporte(List<String> listaDeStrings);
    List<String[]> exportaFuncionariosParaList();
}
