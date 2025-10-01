package ejercicio5;

public class Reserva {
    private String nombreCliente;
    private Pelicula pelicula;
    private Sala sala;
    private int numAsientosReservados;

    public Reserva(String nombreCliente, Pelicula pelicula, Sala sala, int numAsientosReservados) {
        this.nombreCliente = nombreCliente;
        this.pelicula = pelicula;
        this.sala = sala;
        this.numAsientosReservados = numAsientosReservados;
    }


    public String getNombreCliente() {
        return nombreCliente;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public int getNumAsientosReservados() {
        return numAsientosReservados;
    }

    public void setNumAsientosReservados(int numAsientosReservados) {
        this.numAsientosReservados = numAsientosReservados;
    }
    public String toString() {
        return "Cliente: " + nombreCliente +
                ", Película: " + pelicula.getTitulo() +
                ", Sala: " + sala.getNumeroSala() +
                ", Asientos: " + numAsientosReservados;
    }
}
