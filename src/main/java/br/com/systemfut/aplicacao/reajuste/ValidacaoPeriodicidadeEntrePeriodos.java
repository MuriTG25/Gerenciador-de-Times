package br.com.systemfut.aplicacao.reajuste;

import br.com.systemfut.aplicacao.exception.ValorInvalidoException;
import br.com.systemfut.dominio.funcionarios.InterfaceSalario;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosGerais;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoPeriodicidadeEntrePeriodos implements ValidacaoReajuste{
    @Override
    public void validar(BigDecimal porcentagemAumento, FuncionariosGerais funcionario) {
        LocalDate ultimoReajuste = funcionario.getDataDoUltimoReajuste();
        LocalDate agora = LocalDate.now();
        long mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(ultimoReajuste, agora);
        if (mesesDesdeUltimoReajuste < 12){
            throw new ValorInvalidoException("Intervalos entre reajuste deve ser de no mínimo de 12 meses!!!!");
        }
    }
}
