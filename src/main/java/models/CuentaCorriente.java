package models;

import emuns.TipoCuenta;

public class CuentaCorriente extends CuentaBancaria {
    private double limiteSobregiro;

    public CuentaCorriente(String numeroCuenta, double saldoInicial, TipoCuenta tipoCuentadouble, double limiteSobregiro) {
        super(numeroCuenta, saldoInicial, tipoCuentadouble);
        this.limiteSobregiro = limiteSobregiro;
    }

    @Override
    public boolean retirar(double monto) throws Exception {
        if (monto > saldo + limiteSobregiro) {
            throw new Exception("Fondos insuficientes");
        }
        saldo -= monto;
        return false;
    }
}
