package ejercicio2;

public class Principal2 {
    public static void main(String[] args) {

        Rectangulo rectangulo = new Rectangulo(10.5, 5.0);


        Rectangulo cuadrado = new Rectangulo(7.0);

        System.out.println("- Resultados para el Rectángulo (10.5 x 5.0) -");
        System.out.println("Área: " + rectangulo.calcularArea());
        System.out.println("Perímetro: " + rectangulo.calcularPerimetro());

        System.out.println("\n- Resultados para el Cuadrado (7.0 x 7.0) -");
        System.out.println("Área: " + cuadrado.calcularArea());
        System.out.println("Perímetro: " + cuadrado.calcularPerimetro());
    }
}
