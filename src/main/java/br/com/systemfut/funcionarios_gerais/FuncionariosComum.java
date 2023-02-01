package br.com.systemfut.funcionarios_gerais;
/**
 * Classe para organizar a lista de Funcionarios fora do setor Administrativo
 * @author Murilo Bioni Caruso
 * @version 1.0
 * @since 2023
 */
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
