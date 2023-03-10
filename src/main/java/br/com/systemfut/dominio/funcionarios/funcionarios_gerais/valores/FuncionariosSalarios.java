package br.com.systemfut.dominio.funcionarios.funcionarios_gerais.valores;

import java.math.BigDecimal;

public enum FuncionariosSalarios {
    //Cargos Funcionarios comum
    LIMPEZA_JUNIOR(new BigDecimal("1100.0")),LIMPEZA_PLENO(new BigDecimal("1250.0")),
    LIMPEZA_SENIOR(new BigDecimal("1400.0")),MASSAGISTA_JUNIOR(new BigDecimal("1500.0")),
    MASSAGISTA_PLENO(new BigDecimal("1800.0")),MASSAGISTA_SENIOR(new BigDecimal("2100.0")),
    ROUPEIRO_JUNIOR(new BigDecimal("1200.0")),ROUPEIRO_PLENO(new BigDecimal("1400.0")),
    ROUPEIRO_SENIOR(new BigDecimal("1600.0")),
    //Funcionários Administrativos
    AUXILIAR_DE_ESCRITORIO_JUNIOR(new BigDecimal("2000.0")),
    AUXILIAR_DE_ESCRITORIO_PLENO(new BigDecimal("2500.0")),
    AUXILIAR_DE_ESCRITORIO_SENIOR(new BigDecimal("3000.0")),
    SECRETARIO_JUNIOR(new BigDecimal("1500.0")),SECRETARIO_PLENO(new BigDecimal("2000.0")),
    SECRETARIO_SENIOR(new BigDecimal("2500.0")),GERENTE_JUNIOR (new BigDecimal("3500.0")),
    GERENTE_PLENO(new BigDecimal("5000.0")),GERENTE_SENIOR(new BigDecimal("8000.0"));
    private BigDecimal salario;
    FuncionariosSalarios(BigDecimal salario) {
        this.salario = salario.setScale(2);
    }
    public BigDecimal pagamento(){return salario.setScale(2);};

}
