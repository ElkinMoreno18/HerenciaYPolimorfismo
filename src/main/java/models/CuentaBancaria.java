package models;

public abstract class CuentaBancaria {
    protected String numeroCuenta;
    protected double saldo;

    public CuentaBancaria(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public abstract boolean retirar(double monto) throws Exception;

    public double getSaldo() {
        return saldo;
    }
}



