package br.com.systemfut.aplicacao.reajuste;

import br.com.systemfut.dominio.funcionarios.Funcionarios;
import br.com.systemfut.dominio.funcionarios.InterfaceSalario;
import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosGerais;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ReajusteService {
        private List<ValidacaoReajuste> validacoes;
        ValidacaoPercentualReajuste validacaoPercentual;
        ValidacaoPeriodicidadeEntrePeriodos validacaoPeriodo;


        public ReajusteService() {
            this.validacoes = new ArrayList<>();
            this.validacaoPercentual = new ValidacaoPercentualReajuste();
            this.validacaoPeriodo = new ValidacaoPeriodicidadeEntrePeriodos();
            validacoes.add(validacaoPercentual);
            validacoes.add(validacaoPeriodo);
        }

        public BigDecimal getNovoSalarioDoFuncionario(BigDecimal aumento, FuncionariosGerais funcionario) {
            this.validacoes.forEach(v -> v.validar(aumento, funcionario));
            return aumento;
        }
}
