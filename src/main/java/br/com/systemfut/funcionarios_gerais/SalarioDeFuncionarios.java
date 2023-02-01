package br.com.systemfut.funcionarios_gerais;

public enum SalarioDeFuncionarios {
    //Cargos Funcionarios comum
    LIMPEZA_JUNIOR(1100.0),LIMPEZA_PLENO(1250.0),LIMPEZA_SENIOR(1400.0)
    ,MASSAGISTA_JUNIOR(1500.0),MASSAGISTA_PLENO(1800.0),MASSAGISTA_SENIOR(2100.0),
    ROUPEIRO_JUNIOR(1200.0),ROUPEIRO_PLENO(1400.0),ROUPEIRO_SENIOR(1600.0),
    //Funcionários Administrativos
    AUXILIAR_DE_ESCRITORIO_JUNIOR(2000.0),AUXILIAR_DE_ESCRITORIO_PLENO(2500.0),AUXILIAR_DE_ESCRITORIO_SENIOR(3000.0),
    SECRETARIO_JUNIOR(1500.0),SECRETARIO_PLENO(2000.0),SECRETARIO_SENIOR(2500.0)
    ,GERENTE_JUNIOR (3500.0),GERENTE_PLENO(5000.0),GERENTE_SENIOR(8000.0);
    private double salario;
    SalarioDeFuncionarios(double salario) {
        this.salario = salario;
    }
    public double pagamento(){return salario;};

}
