package models;

public class CuentaCorriente extends CuentaBancaria {
    private double limiteSobregiro;

    public CuentaCorriente(String numeroCuenta, double saldoInicial, double limiteSobregiro) {
        super(numeroCuenta, saldoInicial, "Corriente");
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
