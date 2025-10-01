package ejercicio3;

import ejercicio3.Empleado;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class principal3 {

    private static ArrayList<Empleado> listaempleados = new ArrayList<>();

    public static void main(String[] args) {
        // Datos iniciales (los IDs y textos se normalizan en el constructor)
        listaempleados.add(new Empleado("E100", "Javier Salmerón", "Jefe", 5000.00));
        listaempleados.add(new Empleado("A104", "Juan Menjivar", "Asistente", 1100.00));

        int opcion = 0;
        do {
            try {
                String menu = "-GESTOR DE CHAMBIADORES- \n"
                        + "1. Agregar Empleado \n"
                        + "2. Listar Empleados\n"
                        + "3. Buscar empleado por ID\n"
                        + "4. Eliminar empleado \n"
                        + "5. Salir\n";
                String input = JOptionPane.showInputDialog(null, menu, "Menú", JOptionPane.PLAIN_MESSAGE);
                if (input == null) break;

                opcion = Integer.parseInt(input.trim());

                switch (opcion) {
                    case 1 -> agregarEmpleado();
                    case 2 -> listarEmpleados();
                    case 3 -> buscarEmpleado();
                    case 4 -> eliminarEmpleado();
                    case 5 -> JOptionPane.showMessageDialog(null, "Cerrando el Sistema...");
                    default -> JOptionPane.showMessageDialog(null, "Opción inválida.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Debe ingresar un número.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 5);
    }





    private static void agregarEmpleado() {
        String id;
        boolean idRepetido;
        do {
            id = JOptionPane.showInputDialog("Ingrese el ID del empleado:");
            if (id == null) return;
            id = id.trim();
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "ID no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                idRepetido = true;
                continue;
            }

            idRepetido = false;
            for (Empleado e : listaempleados) {
                if (e.getId().equalsIgnoreCase(id)) {
                    idRepetido = true;
                    JOptionPane.showMessageDialog(null, "El empleado con esta ID ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
        } while (idRepetido);

        String nombre = JOptionPane.showInputDialog("Ingrese Nombre del empleado:");
        if (nombre == null) return;

        String puesto = JOptionPane.showInputDialog("Ingrese Puesto del empleado:");
        if (puesto == null) return;

        String salarioStr = JOptionPane.showInputDialog("Ingrese Salario del empleado:");
        if (salarioStr == null) return;

        double salario;
        try {
            salario = Double.parseDouble(salarioStr.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Salario inválido. Operación cancelada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Empleado nuevo = new Empleado(id, nombre, puesto, salario);
        listaempleados.add(nuevo);
        JOptionPane.showMessageDialog(null, "Empleado agregado con éxito");
    }

    private static void listarEmpleados() {
        if (listaempleados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados.", "Listado", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        StringBuilder sb = new StringBuilder("--- LISTADO DE EMPLEADOS ---\n");
        for (Empleado e : listaempleados) {
            sb.append(e.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Listado", JOptionPane.PLAIN_MESSAGE);
    }

    private static void buscarEmpleado() {
        String idBuscar = JOptionPane.showInputDialog("Ingrese ID del empleado:");
        if (idBuscar == null) return;
        idBuscar = idBuscar.trim();
        if (idBuscar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Empleado encontrado = null;
        for (Empleado e : listaempleados) {
            if (e.getId().equalsIgnoreCase(idBuscar)) {
                encontrado = e;
                break;
            }
        }

        if (encontrado != null) {
            JOptionPane.showMessageDialog(null, "Empleado encontrado:\n" + encontrado.toString(), "Resultado Búsqueda", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Empleado con ID " + idBuscar + " no encontrado.", "Resultado Búsqueda", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void eliminarEmpleado() {
        String idEliminar = JOptionPane.showInputDialog("Ingrese ID del empleado a eliminar:");
        if (idEliminar == null) return;
        idEliminar = idEliminar.trim();
        if (idEliminar.isEmpty()) return;

        String finalIdEliminar = idEliminar;
        boolean eliminado = listaempleados.removeIf(e -> e.getId().equalsIgnoreCase(finalIdEliminar));

        if (eliminado) {
            JOptionPane.showMessageDialog(null, "Empleado con ID " + idEliminar + " ha sido eliminado.", "Eliminación", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Empleado con ID " + idEliminar + " no encontrado.", "Eliminación", JOptionPane.ERROR_MESSAGE);
        }
    }
}