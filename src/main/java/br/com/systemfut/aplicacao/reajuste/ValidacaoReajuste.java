package br.com.systemfut.aplicacao.reajuste;

import br.com.systemfut.dominio.funcionarios.InterfaceSalario;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosGerais;

import java.math.BigDecimal;

public interface ValidacaoReajuste {
    void validar(BigDecimal porcentagemAumento, FuncionariosGerais funcionario);
}
