package ejercicio4;

import javax.swing.JOptionPane;


public class principal4 {
    public static void main(String[] args) {

        Auto auto1 = new Auto("Lamborguini", "Veneno", 2015, 2);
        Auto auto2 = new Auto("Ford", "Mustang", 2016, 2);


        Moto moto1 = new Moto("Yamaha", "YBR", 2019, 150);
        Moto moto2 = new Moto("Honda", "Shadow", 2019, 200);


        JOptionPane.showMessageDialog(null, "Información del Auto 1:\n" + auto1.mostrarInfo());

        JOptionPane.showMessageDialog(null, "Información del Auto 2:\n" + auto2.mostrarInfo());
        JOptionPane.showMessageDialog(null, "Información de la Moto 1:\n" + moto1.mostrarInfo());

        JOptionPane.showMessageDialog(null, "Información de la Moto 2:\n" + moto2.mostrarInfo());
    }
}
