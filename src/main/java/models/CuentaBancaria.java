package models;

public abstract class CuentaBancaria {
    protected String numeroCuenta;
    protected double saldo;
    protected String tipoCuenta;

    public CuentaBancaria(String numeroCuenta, double saldoInicial, String tipoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
        this.tipoCuenta = tipoCuenta;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public abstract boolean retirar(double monto) throws Exception;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }
}



