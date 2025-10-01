package ejercicio4;

public class Vehiculo {
    private String marca;
    private String modelo;
    private int year;

    public Vehiculo(String marca, String modelo, int year) {
        this.marca = marca;
        this.modelo = modelo;
        this.year = year;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getYear() { return year; }

    public String mostrarInfo() {
        return "Marca: " + marca + "\nModelo: " + modelo + "\nAño: " + year;
    }
}
