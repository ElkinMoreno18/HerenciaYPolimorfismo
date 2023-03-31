package models;

import emuns.TipoCuenta;

import java.util.ArrayList;
import java.util.List;

public abstract class CuentaBancaria {
    protected String numeroCuenta;
    protected double saldo;
    protected TipoCuenta tipoCuenta;
    protected List<Transferencia> transferencia;

    public CuentaBancaria(String numeroCuenta, double saldoInicial, TipoCuenta tipoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
        this.tipoCuenta = tipoCuenta;
        this.transferencia = new ArrayList<>();

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

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public List<Transferencia> getTransferencia() {
        return transferencia;
    }
}



