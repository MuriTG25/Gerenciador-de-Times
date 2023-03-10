package br.com.systemfut.dominio.funcionarios.dados_extras;

import br.com.systemfut.aplicacao.exception.ValorInvalidoException;
import br.com.systemfut.dominio.funcionarios.dados_extras.atribitos_dados_pessoais.Email;
import br.com.systemfut.dominio.funcionarios.dados_extras.atribitos_dados_pessoais.Telefone;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe para armazenar os dados pessoais do funcionario
 * @author Murilo Bioni Caruso
 * @version 1.1
 * @since 2023
 */

public class DadosPessoais {
    private String RG;
    private String estadoCivil;
    private LocalDate dataDeNascimento;
    private int idade;
    private Email email;
    private List<Telefone> telefones = new ArrayList<>();

    public String getEstadoCivil() {

        return estadoCivil;
    }
    public void setEstadoCivil(String estadoCivil) {

        this.estadoCivil = estadoCivil;
    }
    public String getDataDeNascimento() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataDeNascimento.format(formato);
    }
    public int getIdade(){
        return idade;
    }
    public void setDataDeNascimento(int dia, int mes, int ano) {
        this.dataDeNascimento = LocalDate.of(ano,mes,dia);
        LocalDate agora = LocalDate.now();
        Period periodo = Period.between(dataDeNascimento, agora);
        this.idade = periodo.getYears();
    }

    public String getEmail() {
        return email.getEnderecoEMail();
    }

    public void setEmail(Email email) {
        this.email = email;
    }
    public List<Telefone> getTelefones() {
        return telefones;
    }
    public void adicionaTelefone(Telefone telefone){
        if (telefones.size() >= 2){
            throw new ValorInvalidoException("numero maximo de telefones eh de 2");
        }
        telefones.add(telefone);
    }
    public void removeTelefone(Telefone telefone){
        telefones.remove(telefone);
    }
    public String getRG() {
        return RG;
    }
    public void setRG(String RG) {
        this.RG = RG;
    }
}
