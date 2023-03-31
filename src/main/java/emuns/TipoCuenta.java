package emuns;

public enum TipoCuenta {

    AHORROS(1, "Ahorros"),
    CORRIENTE(2, "Corriente"),
    ;

    TipoCuenta(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    private int id;
    private String nombre;




    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
