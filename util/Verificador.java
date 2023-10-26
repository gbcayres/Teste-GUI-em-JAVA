package util;

import application.Main;
import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Verificador {

    public static boolean cpfCadastrado(String doc) {
        for (Pessoa pessoa : Main.pessoas) {
            if (pessoa instanceof PessoaFisica) {
                PessoaFisica pessoaAux = (PessoaFisica) pessoa;
                if (pessoaAux.getCpf().equals(doc)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean cnpjCadastrado(String doc) {

        for (Pessoa pessoa : Main.pessoas) {
            if (pessoa instanceof PessoaJuridica) {
                PessoaJuridica pessoaAux = (PessoaJuridica) pessoa;
                if (pessoaAux.getCnpj().equals(doc)) {
                    return true;
                }
            }
        }
        return false;
    }
}