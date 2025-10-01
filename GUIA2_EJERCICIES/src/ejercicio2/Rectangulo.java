package ejercicio2;

public class Rectangulo {
    private double altura;
    private double base;

    public Rectangulo(double altura, double base) {
        this.base = base;
        this.altura = altura;

    }
    public Rectangulo(double lado)
    {
        this.base = lado;
        this.altura = lado;
    }
    public double calcularArea() {
        return base * altura;
    }
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }
}
