package models;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    protected int id;
    protected String nombre, direccion, telefono;
    protected List<CuentaBancaria> cuentaBancarias;

    public Cliente(int id, String nombre, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cuentaBancarias = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }


    public List<CuentaBancaria> getCuentaBancarias() {
        return cuentaBancarias;
    }

}
