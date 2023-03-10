package br.com.systemfut.dominio.funcionarios.dados_extras.atributos_dados_bancarios;

public enum GrupoDaDataDePagamento {
    GRUPO_1(5),GRUPO_2(15),GRUPO_3(25);
    int diaDePagamento;

    GrupoDaDataDePagamento(int diaDePagamento) {
        this.diaDePagamento = diaDePagamento;
    }

    public int getDiaDePagamento() {
        return diaDePagamento;
    }
}
