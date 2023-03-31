package models;

public class Cliente {

    protected int id;
    protected String nombre, direccion, telefono;

    CuentaBancaria cuentaBancaria;

    public Cliente(int id, String nombre, String direccion, String telefono, CuentaBancaria cuentaBancaria) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cuentaBancaria = cuentaBancaria;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void addCuenta(CuentaBancaria cuentaBancaria){

    }


}
