package br.com.systemfut.aplicacao.reajuste;

import br.com.systemfut.dominio.funcionarios.funcionarios_gerais.FuncionariosGerais;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FuncionariosAReajustar {
    private List<FuncionariosGerais> listaReajuste;


    public FuncionariosAReajustar() {
        this.listaReajuste = new ArrayList<>();
    }

    public List<FuncionariosGerais> getListaReajuste() {
        return Collections.unmodifiableList(listaReajuste);
    }

    public void verificaFuncionariosNaoReajustados(FuncionariosGerais funcionario){
            LocalDate ultimoReajuste = funcionario.getDataDoUltimoReajuste();
            LocalDate agora = LocalDate.now();
            long mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(ultimoReajuste, agora);
            if (mesesDesdeUltimoReajuste >= 12){
                this.listaReajuste.add(funcionario);
        }
    }
}
