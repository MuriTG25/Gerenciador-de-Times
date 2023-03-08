package br.com.systemfut.dominio.funcionarios.atributos_Funcionarios;

import br.com.systemfut.aplicacao.exception.ValorInvalidoException;

import java.util.InputMismatchException;

public class CPF {
    private String CPF;
    //link do código utilizado: https://www.4devs.com.br/gerador_de_cpf
    public CPF(String CPF) {
        if (CPF.equals("00000000000") ||
                CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999") ||
                (CPF.length() != 11)){
            throw new ValorInvalidoException("CPF invalido");
        }
        char dig10, dig11;
        int sm, i, r, num, peso;
        try {
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48);

            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char)(r + 48);
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))){
                this.CPF = CPF;
            }
            else throw new ValorInvalidoException("CPF invalido");
        } catch (InputMismatchException erro) {
            throw new ValorInvalidoException("CPF invalido");
        }
    }
    public String imprimeCPF() {
        return CPF;
    }

    @Override
    public String toString() {
        return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
                CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
    }
}
