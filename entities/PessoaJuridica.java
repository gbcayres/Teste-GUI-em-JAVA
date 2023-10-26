package entities;

import util.Formatador;

public class PessoaJuridica extends Pessoa {

    private String cnpj;

    public PessoaJuridica(String nome, String telefone, String cnpj) {
        super.setNome(nome);
        super.setTelefone(telefone);
        this.setCnpj(cnpj);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public void seApresentar(){
        String cnpjOriginal = Formatador.guardarDoc(this.cnpj);
        this.cnpj = Formatador.formatarDoc(this, this.cnpj);
        System.out.println(" --- PESSOA JURIDICA --- ");
        System.out.println("Nome: " + super.getNome());
        System.out.println("Telefone: " + super.getTelefone());
        System.out.println("CNPJ: " + this.getCnpj());
        this.cnpj = cnpjOriginal;
    }
}