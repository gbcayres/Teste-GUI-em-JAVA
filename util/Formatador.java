package util;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formatador {

    public static String formatarTelefone(String telefone) {

        String regex = "^(\\(?\\d{2}\\)?)\\s?(9\\d{4})[-\\s]?(\\d{4})$";

        Pattern padraoTelefone = Pattern.compile(regex);

        Matcher matcherTelefone = padraoTelefone.matcher(telefone);

        if (matcherTelefone.matches()) {

            String ddd = matcherTelefone.group(1);
            String parte1 = matcherTelefone.group(2);
            String parte2 = matcherTelefone.group(3);

            return "(" + ddd + ")" + parte1 + "-" + parte2;
        }
        return telefone;
    }

    public static String formatarDoc(Pessoa pessoa, String doc) {
        if (pessoa instanceof PessoaFisica) {
            String regex = "(\\d{3})[. ]?(\\d{3})[. ]?(\\d{3})[- ]?(\\d{2})";
            Pattern padraoCpf = Pattern.compile(regex);
            Matcher matcherCpf = padraoCpf.matcher(doc);

            if (matcherCpf.find()) {
                String parte1 = matcherCpf.group(1);
                String parte2 = matcherCpf.group(2);
                String parte3 = matcherCpf.group(3);
                String parte4 = matcherCpf.group(4);

                return parte1 + "." + parte2 + "." + parte3 + "-" + parte4;
            }
        } else if (pessoa instanceof PessoaJuridica){
            String regex = "^(\\d{2})[. ]?(\\d{3})[. ]?(\\d{3})[\\/ ]?(\\d{4})[ -]?(\\d{2})$";
            Pattern padraoCnpj = Pattern.compile(regex);
            Matcher matcherCnpj = padraoCnpj.matcher(doc);

            if (matcherCnpj.find()){
                String parte1 = matcherCnpj.group(1);
                String parte2 = matcherCnpj.group(2);
                String parte3 = matcherCnpj.group(3);
                String parte4 = matcherCnpj.group(4);
                String parte5 = matcherCnpj.group(5);

                return parte1 +  "." + parte2 + "." + parte3 + "/" + parte4 + "-" + parte5;
            }
        }
        return doc;
    }

    public static String guardarDoc(String doc){
        String docOriginal = doc;
        return docOriginal;
    }
}