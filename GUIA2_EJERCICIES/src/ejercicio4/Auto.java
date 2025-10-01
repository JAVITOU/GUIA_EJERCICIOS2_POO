
package ejercicio4;

public class Auto extends Vehiculo {
    private int numPuertas;

    public Auto(String marca, String modelo, int year, int numPuertas) {
        super(marca, modelo, year);
        this.numPuertas = numPuertas;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + "\nNúmero de puertas: " + numPuertas;

    }
}
