package br.com.systemfut.atletas_e_comissao;

import br.com.systemfut.exception.InvalidNumberException;
/**
 * Classe para organizar os Jogadores
 * @author Murilo Bioni Caruso
 * @version 1.0
 * @since 2023
 */
public final class Jogadores extends AtletasEComissao {
    private String posicao;
    private short numeroDaCamisa;

    public Jogadores(String nomeCompleto, long CPF, String posicao) {
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
    public void setSalario(double s) {
        if (s >= 1500.0 && s <= 50000.0) {
            this.salario = s;
        } else {
            throw new InvalidNumberException(
                    "O salário não deve ser menor que 1500 e nem maior que 50000");
        }
    }

    @Override
    public String toString() {
        return "[Nome: "+this.getNomeCompleto()+" / CPF: "+
                this.getCPF()+" / Posicao: "+this.getPosicao()+"]";
    }
}
