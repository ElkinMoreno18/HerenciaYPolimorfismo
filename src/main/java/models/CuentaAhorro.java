package models;

public class CuentaAhorro extends CuentaBancaria {
    private double tasaInteres;

    public CuentaAhorro(String numeroCuenta, double saldoInicial, double tasaInteres) {
        super(numeroCuenta, saldoInicial);
        this.tasaInteres = tasaInteres;
    }

    @Override
    public boolean retirar(double monto) throws Exception {
        if (monto > saldo) {
            throw new Exception("Fondos insuficientes");
        }
        saldo -= monto;
        return false;
    }

    public void agregarInteres() {
        saldo += saldo * tasaInteres;
    }
}
