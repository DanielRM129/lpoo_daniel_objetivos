package model;

public class Associado implements AssociadoVip{
    private String nome;
    private double numeroCota;

    public Associado() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNumeroCota() {
        return numeroCota;
    }

    public void setNumeroCota(double numeroCota) {
        this.numeroCota = numeroCota;
    }

    public Associado(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Associado associado = (Associado) o;

        return Double.compare(associado.numeroCota, numeroCota) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(numeroCota);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public double lucros(int qdeCotas, double valorCota) {
        return this.numeroCota = qdeCotas * valorCota;
    }

    @Override
    public String toString() {
        return "\nAssociado{" +
                "nome='" + nome + '\'' +
                ", numeroCota=" + numeroCota +
                '}';
    }
}
