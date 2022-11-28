package model;

public class ContaCorrente extends Conta implements AssociadoVip{
    private double valorLucro;

    public ContaCorrente() {
    }

    public ContaCorrente(double saldo) {
        super(saldo);
    }

    @Override
    public double lucros(int qdeCotas, double valorCota) {
        return this.valorLucro = qdeCotas * valorCota;
    }

    @Override
    public String toString() {
        return "\nContaCorrente{" +
                "valorLucro=" + valorLucro +
                ", saldo=" + saldo +
                '}';
    }
}
