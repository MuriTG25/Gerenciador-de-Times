package br.com.systemfut.dominio.funcionarios.funcionarios_gerais;

import br.com.systemfut.aplicacao.reajuste.ReajusteService;
import br.com.systemfut.dominio.funcionarios.atributos_Funcionarios.CPF;
import br.com.systemfut.dominio.funcionarios.InterfaceSalario;
import br.com.systemfut.infraestrutura.senha.CriadorDeSenhasArquivoProperties;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Classe para organizar os Funcionarios Administrativos
 * @author Murilo Bioni Caruso
 * @version 1.0
 * @since 2023
 */
public final class FuncionariosADM extends FuncionariosGerais implements InterfaceSalario {
    private String cargo;
    private CriadorDeSenhasArquivoProperties senha;

    public FuncionariosADM(String nomeCompleto, CPF CPF, String cargo) {
        super(nomeCompleto, CPF);
        this.cargo = cargo;
        this.senha = new CriadorDeSenhasArquivoProperties();
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "[Nome: " + this.getNomeCompleto() + " / CPF: " +
                this.getCPF() + " / Cargo: " + this.getCargo() + "]";
    }
}

