package br.com.systemfut.funcionarios_gerais;

public enum SalarioDeFuncionarios {
    //Cargos Funcionarios comum
    LIMPEZA_JUNIOR {
        public double pagamento(){return 1100.0;}
    },LIMPEZA_PLENO{
        public double pagamento(){return 1250.0;}
    },LIMPEZA_SENIOR{
        public double pagamento(){return 1400.0;}
    },MASSAGISTA_JUNIOR{
        public double pagamento(){return 1500.0;}
    },MASSAGISTA_PLENO{
        public double pagamento(){return 1800.0;}
    },MASSAGISTA_SENIOR{
        public double pagamento(){return 2100.0;}
    },ROUPEIRO_JUNIOR{
        public double pagamento(){return 1200.0;}
    },ROUPEIRO_PLENO{
        public double pagamento(){return 1400.0;}
    },ROUPEIRO_SENIOR{
        public double pagamento(){return 1600.0;}
    },
    //Funcionários Administrativos
    AUXILIAR_DE_ESCRITORIO_JUNIOR{
        public double pagamento(){return 2000.0;}
    },AUXILIAR_DE_ESCRITORIO_PLENO{
        public double pagamento(){return 2500.0;}
    },AUXILIAR_DE_ESCRITORIO_SENIOR{
        public double pagamento(){return 3000.0;}
    },SECRETARIO_JUNIOR{
    public double pagamento(){return 1500.0;}
    },SECRETARIO_PLENO{
        public double pagamento(){return 2000.0;}
    },SECRETARIO_SENIOR{
        public double pagamento(){return 2500.0;}
    },GERENTE_JUNIOR{
        public double pagamento(){return 3500.0;}
    },GERENTE_PLENO{
        public double pagamento(){return 5000.0;}
    },GERENTE_SENIOR{
        public double pagamento(){return 8000.0;}
    };


    public abstract double pagamento();

}
