package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {
    public static void validarNome(String nome) throws IllegalArgumentException {

        String regex = "^([A-Z][a-z]*\\s?)+";
        Pattern padraoNome = Pattern.compile(regex);
        Matcher matcherNome = padraoNome.matcher(nome);

        if (!matcherNome.matches()) {
            System.out.println("Nome deu erro.");
            throw new IllegalArgumentException("Nome inválido.");
        } else {
            System.out.println("Nome ok!");
        }
    }

    public static void validarTelefone(String telefone) {

        String regex = "^(\\(?\\d{2}\\)?)\\s?(9\\d{4})[-\\s]?(\\d{4})$";
        Pattern padraoTelefone = Pattern.compile(regex);
        Matcher matcherTelefone = padraoTelefone.matcher(telefone);

        if (!matcherTelefone.matches()) {
            System.out.println("Telefone deu erro.");
            throw new IllegalArgumentException("Número inválido.");
        } else {
            System.out.println("Telefone ok!");
        }
    }

    public static void validarDoc(String doc, String tipoPessoa) {
        if (tipoPessoa.equals("Pessoa Física")) {
            validarCpf(doc);
        } else {
            validarCnpj(doc);
        }
    }

    public static void validarCpf(String doc) {

        boolean cpfRepitido = Verificador.cpfCadastrado(doc);

        String regex = "(\\d{3})[. ]?(\\d{3})[. ]?(\\d{3})[- ]?(\\d{2})";
        Pattern padraoCpf = Pattern.compile(regex);
        Matcher matcherCpf = padraoCpf.matcher(doc);

        if (!matcherCpf.matches()) {
            System.out.println("CPF deu erro.");
            throw new IllegalArgumentException("CPF inválido.");
        } else if (cpfRepitido) {
            System.out.println("CPF deu erro.");
            throw new IllegalArgumentException("CPF já cadastrado");
        } else {
            System.out.println("CPF ok!");
        }
    }

    public static void validarCnpj(String doc) {

        boolean cnpjRepitido = Verificador.cnpjCadastrado(doc);

        String regex = "^(\\d{2})[. ]?(\\d{3})[. ]?(\\d{3})[\\/ ]?(\\d{4})[ -]?(\\d{2})$";

        Pattern padraoCnpj = Pattern.compile(regex);

        Matcher matcherCnpj = padraoCnpj.matcher(doc);

        if(!matcherCnpj.matches()) {
            System.out.println("CNPJ deu erro.");
            throw new IllegalArgumentException("CNPJ inválido.");
        } else if (cnpjRepitido) {
            System.out.println("CNPJ deu erro.");
            throw new IllegalArgumentException("CNPJ já cadastrado.");
        } else {
            System.out.println("CNPJ ok!");
        }
    }

}