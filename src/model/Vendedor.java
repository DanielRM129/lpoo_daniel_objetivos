package model;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Funcionario implements IFornecerPrecos{
    private String local;
    List<Pedido> pedidos = new ArrayList<>();

    @Override
    public int getMatricula() {
        return super.getMatricula();
    }

    @Override
    public void setMatricula(int matricula) {
        super.setMatricula(matricula);
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public String getEndereco() {
        return super.getEndereco();
    }

    @Override
    public void setEndereco(String endereco) {
        super.setEndereco(endereco);
    }

    @Override
    public String getBairro() {
        return super.getBairro();
    }

    @Override
    public void setBairro(String bairro) {
        super.setBairro(bairro);
    }

    @Override
    public String getCep() {
        return super.getCep();
    }

    @Override
    public void setCep(String cep) {
        super.setCep(cep);
    }

    @Override
    public String getCidade() {
        return super.getCidade();
    }

    @Override
    public void setCidade(String cidade) {
        super.setCidade(cidade);
    }

    @Override
    public String getEstado() {
        return super.getEstado();
    }

    @Override
    public void setEstado(String estado) {
        super.setEstado(estado);
    }

    @Override
    public boolean manterFunc(int matricula) {
        return super.manterFunc(matricula);
    }

    public Vendedor() {
    }

    public Vendedor(String local) {
        this.local = local;
    }

    public Vendedor(int matricula, String nome, String endereco, String bairro, String cep, String cidade, String estado, String local) {
        super(matricula, nome, endereco, bairro, cep, cidade, estado);
        this.local = local;
    }

    public Vendedor(int matricula, String nome, String endereco, String bairro, String cep, String cidade, String estado) {
        super(matricula, nome, endereco, bairro, cep, cidade, estado);
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void realizarPedido(){};
    public void consultarPreco(){};

    @Override
    public String toString() {
        return "\nVendedor{" +
                "Nome='" + getNome() + '\'' +
                ", Bairro='" + getBairro() + '\'' +
                ", Cep='" + getCep() + '\'' +
                ", Cidade='" + getCidade() + '\'' +
                ", Estado='" + getEstado() + '\'' +
                ", Endereco='" + getEndereco() + '\'' +
                ", Matricula='" + getMatricula() + '\'' +
                ", local='" + local + '\'' +
                '}';
    }
}
