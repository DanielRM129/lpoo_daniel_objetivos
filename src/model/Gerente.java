package model;

public class Gerente extends Funcionario{
    private String formacao;

    public Gerente() {
    }

    public Gerente(int matricula, String nome, String endereco, String bairro, String cep, String cidade, String estado) {
        super(matricula, nome, endereco, bairro, cep, cidade, estado);
    }

    public Gerente(String formacao) {
        this.formacao = formacao;
    }

    public Gerente(int matricula, String nome, String endereco, String bairro, String cep, String cidade, String estado, String formacao) {
        super(matricula, nome, endereco, bairro, cep, cidade, estado);
        this.formacao = formacao;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public void autorizarCompra(){};

    @Override
    public String toString() {
        return "\nGerente{" +
                "formacao='" + formacao + '\'' +
                '}';
    }
}
