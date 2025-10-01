package ejercicio4;

public class Moto extends Vehiculo {
    private int cilindraje;

    public Moto(String marca, String modelo, int year, int cilindraje) {
        super(marca, modelo, year);
        this.cilindraje = cilindraje;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + "\nCilindraje: " + cilindraje + "cc";
    }
}
