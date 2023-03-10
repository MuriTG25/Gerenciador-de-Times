package br.com.systemfut.dominio.funcionarios.atletas_e_comissao;

import br.com.systemfut.aplicacao.reajuste.ReajusteService;
import br.com.systemfut.dominio.funcionarios.atributos_Funcionarios.CPF;
import br.com.systemfut.dominio.funcionarios.InterfaceSalario;
import br.com.systemfut.aplicacao.exception.ValorInvalidoException;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Classe para organizar a Comissão Tecnica
 * @author Murilo Bioni Caruso
 * @version 1.1
 * @since 2023
 */
public final class ComissaoTecnica extends AtletasEComissao implements InterfaceSalario {
    public ComissaoTecnica(String nomeCompleto, CPF CPF, String cargo) {
        super(nomeCompleto, CPF);
        this.cargo = cargo;
    }
    private String cargo;

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    @Override
    public void setSalario(BigDecimal salario) {
        if (salario.compareTo(new BigDecimal("2000.0"))<0
        || salario.compareTo(new BigDecimal("20000.0"))>0){
            throw new ValorInvalidoException(
                    "O salário não deve ser menor que 2000 e nem maior que 20000");
        }
        this.salario = salario.setScale(2);
    }
    @Override
    public String toString() {
        return "[Nome: "+this.getNomeCompleto()+" / CPF: "+
                this.getCPF()+" / Cargo: "+this.getCargo()+"]";
    }
}
