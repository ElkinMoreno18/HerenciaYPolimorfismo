package models;

import emuns.TipoCuenta;
import models.CuentaBancaria;

import java.util.Date;

public class Transferencia {
    private Date fecha;
    private double monto;
    private CuentaBancaria cuentaOrigen;
    private CuentaBancaria cuentaDestino;

    public Transferencia(Date fecha, double monto, CuentaBancaria cuentaOrigen, CuentaBancaria cuentaDestino) {
        this.fecha = fecha;
        this.monto = monto;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
    }

    public void transferir(Transferencia transferencia) throws Exception {

        if (transferencia.cuentaOrigen.getTipoCuenta() == TipoCuenta.CORRIENTE){
            Double saldoSobregiro =  transferencia.cuentaOrigen.getSaldo() + 50000 ;
            if (transferencia.getMonto() > saldoSobregiro){
                throw new Exception("Esta realizando un sobregiro y no es posible realizar la transferencia");
            }else{
                double saldoFinalDestino = transferencia.getCuentaDestino().getSaldo() + transferencia.getMonto();
                double saldoFinalOrigen = transferencia.getCuentaOrigen().getSaldo() - transferencia.getMonto();
                transferencia.getCuentaDestino().setSaldo(saldoFinalDestino);
                transferencia.getCuentaOrigen().setSaldo(saldoFinalOrigen);
            }
        }else{
            throw new Exception("No es posible realiar la transferencia a este tipo de cuenta");
        }

    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public CuentaBancaria getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(CuentaBancaria cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public CuentaBancaria getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(CuentaBancaria cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }
}
