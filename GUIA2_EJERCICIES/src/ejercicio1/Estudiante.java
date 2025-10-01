package ejercicio1;


public class Estudiante {

    private String nombreCompleto;
    private String carnet;
    private String carrera;


    private double[] notas = new double[3];


    public Estudiante() {}


    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public String getCarnet() {
        return carnet;
    }
    public String getCarrera() {
        return carrera;
    }



    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }



    public void setNota(int indice, double nota) {
        if (indice >= 0 && indice < notas.length) {
            this.notas[indice] = nota;
        }
    }



    public double calcularPromedio() {
        double suma = 0;
        for (double n : notas) {
            suma += n;
        }
        return suma / notas.length;
    }



    public String estado() {
        return calcularPromedio() >= 6.0 ? "Aprobado" : "Reprobado";
    }



    public String toString() {
        return "Nombre: " + nombreCompleto +
                ", Carnet: " + carnet +
                ", Carrera: " + carrera +
                ", Promedio: " + String.format("%.2f", calcularPromedio()) +
                ", Estado: " + estado();
    }
}
