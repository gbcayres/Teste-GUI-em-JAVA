package entities;

public abstract class Pessoa {
    protected String nome;
    protected String telefone;

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void seApresentar(){
        System.out.println("Nome: " + this.getNome());
        System.out.println("Telefone: " + this.getTelefone());
    };
}