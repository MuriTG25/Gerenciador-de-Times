package br.com.systemfut.funcionarios_gerais;

public final class FuncionariosComum extends FuncionariosGerais {

    private String cargo;
    public FuncionariosComum(String nomeCompleto, long CPF, String cargo) {
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
