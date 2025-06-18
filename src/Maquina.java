public class Maquina {

    private String nombre;
    private int cantPiezas;

    
    public Maquina(String nombre, int cantPiezas) {
        this.nombre = nombre;
        this.cantPiezas = cantPiezas;
    }


    public String getNombre() {
        return nombre;
    }


    public int getCantPiezas() {
        return cantPiezas;
    }


    @Override
    public String toString() {
        return "Maquina nombre = " + nombre + "";
    }
    
}