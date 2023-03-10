package br.com.systemfut.dominio.funcionarios.funcionarios_gerais;

import br.com.systemfut.aplicacao.reajuste.ReajusteService;
import br.com.systemfut.dominio.funcionarios.atributos_Funcionarios.CPF;
import br.com.systemfut.dominio.funcionarios.InterfaceSalario;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Classe para organizar a lista de Funcionarios fora do setor Administrativo
 * @author Murilo Bioni Caruso
 * @version 1.0
 * @since 2023
 */
public final class FuncionariosComum extends FuncionariosGerais implements InterfaceSalario {

    private String cargo;
    public FuncionariosComum(String nomeCompleto, CPF CPF, String cargo) {
        super(nomeCompleto, CPF);
        this.cargo = cargo;
    }
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "[Nome: "+this.getNomeCompleto()+" / CPF: "+
                this.getCPF()+" / Cargo: "+this.getCargo()+"]";
    }
}
