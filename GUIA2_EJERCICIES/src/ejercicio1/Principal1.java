

package ejercicio1;

import java.util.Scanner;
import java.util.ArrayList;

public class Principal1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Estudiante> lista = new ArrayList<>();


        for (int i = 1; i <= 3; i++) {
            Estudiante e = new Estudiante();
            System.out.println("\nRegistro del estudiante " + i);



            System.out.print("Nombre completo: ");
            e.setNombreCompleto(sc.nextLine());
            System.out.print("Carnet: ");
            e.setCarnet(sc.nextLine());
            System.out.print("Carrera: ");
            e.setCarrera(sc.nextLine());


            for (int j = 0; j < 3; j++) {
                System.out.print("Nota " + (j + 1) + ": ");
                e.setNota(j, sc.nextDouble());
            }
            sc.nextLine();


            lista.add(e);
        }


        System.out.println("\nLISTADO DE ESTUDIANTES:");
        for (Estudiante e : lista) {
            System.out.println(e);
        }
    }
}

