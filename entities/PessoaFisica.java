package entities;

import util.Formatador;

public class PessoaFisica extends Pessoa {

    private String cpf;

    public PessoaFisica(String nome,String telefone, String cpf) {
        super.setNome(nome);
        super.setTelefone(telefone);
        this.setCpf(cpf);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public void seApresentar(){
        String cpfOriginal = Formatador.guardarDoc(this.getCpf());
        this.cpf = Formatador.formatarDoc(this, this.cpf);
        System.out.println(" --- PESSOA FISICA --- ");
        System.out.println("Nome: " + super.getNome());
        System.out.println("Telefone: " + super.getTelefone());
        System.out.println("CPF: " + this.getCpf());
        this.cpf = cpfOriginal;
    }
}