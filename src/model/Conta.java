package model;

public abstract class Conta {
    protected double saldo;

    public Conta() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conta conta = (Conta) o;

        return Double.compare(conta.saldo, saldo) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(saldo);
        return (int) (temp ^ (temp >>> 32));
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Conta(double saldo) {
        this.saldo = saldo;
    }

    public void deposita(double valor) {
        this.saldo = this.saldo + valor;
    }

    public void saca(double valor) {
        this.saldo = this.saldo - valor;
    }

    public void atualiza(double taxa) {
        this.saldo = this.saldo+(this.saldo * (taxa/100));
    }


}
