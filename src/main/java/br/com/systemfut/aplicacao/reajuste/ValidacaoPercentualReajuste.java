package br.com.systemfut.aplicacao.reajuste;

import br.com.systemfut.aplicacao.exception.ValorInvalidoException;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosGerais;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ValidacaoPercentualReajuste implements ValidacaoReajuste{
    @Override
    public void validar(BigDecimal porcentagemAumento, FuncionariosGerais funcionario) {
        if (porcentagemAumento.compareTo(new BigDecimal("0.15")) > 0 || porcentagemAumento.compareTo(new BigDecimal("0")) <= 0) {
            throw new ValorInvalidoException("Reajuste nao pode ser superior a 15% do salario e nem diminuir o valor atual");
        }
    }
}
