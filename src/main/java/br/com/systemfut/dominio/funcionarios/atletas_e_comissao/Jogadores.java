package br.com.systemfut.dominio.funcionarios.atletas_e_comissao;

import br.com.systemfut.aplicacao.exception.ValorInvalidoException;
import br.com.systemfut.aplicacao.reajuste.ReajusteService;
import br.com.systemfut.dominio.funcionarios.atributos_Funcionarios.CPF;
import br.com.systemfut.dominio.funcionarios.InterfaceSalario;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Classe para organizar os Jogadores
 * @author Murilo Bioni Caruso
 * @version 1.1
 * @since 2023
 */
public final class Jogadores extends AtletasEComissao implements InterfaceSalario {
    private String posicao;
    private short numeroDaCamisa;

    public Jogadores(String nomeCompleto, CPF CPF, String posicao) {
        super(nomeCompleto, CPF);
        this.posicao = posicao;
    }
    public String getPosicao() {
        return posicao;
    }
    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }
    public short getNumeroDaCamisa() {
        return numeroDaCamisa;
    }
    public void setNumeroDaCamisa(short numeroDaCamisa) {
        this.numeroDaCamisa = numeroDaCamisa;
    }
    @Override
    public void setSalario(BigDecimal salario) {
        if (salario.compareTo(new BigDecimal("1500.0"))< 0 || salario.compareTo(new BigDecimal("50000.0"))>0){
            throw new ValorInvalidoException(
                    "O salário não deve ser menor que 1500 e nem maior que 50000");
        }
        this.salario = salario.setScale(2);
    }
    @Override
    public String toString() {
        return "[Nome: "+this.getNomeCompleto()+" / CPF: "+
                this.getCPF()+" / Posicao: "+this.getPosicao()+"]";
    }
}
