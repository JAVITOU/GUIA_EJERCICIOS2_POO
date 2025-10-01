package ejercicio3;

public class Empleado {
    private String id;
    private String nombre;
    private String puesto;
    private double salario;

    public Empleado(String id, String nombre, String puesto, double salario) {
        this.id = (id != null) ? id.trim() : "";
        this.nombre = (nombre != null) ? nombre.trim() : "";
        this.puesto = (puesto != null) ? puesto.trim() : "";
        this.salario = salario;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Puesto: " + puesto + " | Salario: $ " + String.format("%.2f", salario);
    }
}
