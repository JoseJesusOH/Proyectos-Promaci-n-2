package Fruteria;

public class Fruta {
    
    private String nombre;
    private String color;
    private int precio;
    private String codigo;

    public Fruta(String nombre, String color, int precio, String codigo) {
        this.nombre = nombre;
        this.color = color;
        this.precio = precio;
        this.codigo = codigo;
    }

    public Fruta() {
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void subirPrecio(){
        precio++;
        
    }
    
    @Override
    public String toString() {
        return nombre + ", " + color + ", " + precio + ", " + codigo;
    }

}
