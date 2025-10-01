package ejercicio5;

public class Sala {
    private int numeroSala;
    private int capacidadTotal;
    private int capacidadDisponible;


    public Sala(int numeroSala, int capacidadTotal) {
        this.numeroSala = numeroSala;
        this.capacidadTotal = capacidadTotal;
        this.capacidadDisponible = capacidadTotal;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public int getCapacidadDisponible() {
        return capacidadDisponible;
    }



    public boolean reservarAsientos(int asientos) {
        if (asientos > 0 && capacidadDisponible >= asientos) {
            this.capacidadDisponible -= asientos;
            return true;
        }
        return false;
    }



    public void liberarAsientos(int asientos) {

        if (asientos > 0) {

            this.capacidadDisponible += asientos;


            if (this.capacidadDisponible > this.capacidadTotal) {
                this.capacidadDisponible = this.capacidadTotal;
            }
        }
    }

    @Override
    public String toString() {
        return "Sala #" + numeroSala +
                " (Capacidad Total: " + capacidadTotal +
                ", Disponible: " + capacidadDisponible + ")";
    }
}