package ejercicio5;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public class principal5 {
    private static ArrayList<Pelicula> peliculas = new ArrayList<>();
    private static ArrayList<Sala> salas = new ArrayList<>();
    private static ArrayList<Reserva> reservas = new ArrayList<>();

    public static void main(String[] args) {

        inicializarDatos();

        int opcion = 0;
        do {
            try {
                String menu = "--- SISTEMA DE RESERVAS DE CINE ---\n"
                        + "1. Agregar Película\n"
                        + "2. Agregar Sala\n"
                        + "3. Realizar Reserva\n"
                        + "4. Cancelar Reserva\n"
                        + "5. Mostrar Todas las Reservas\n"
                        + "6. Salir";

                String input = JOptionPane.showInputDialog(null, menu, "Menú Principal", JOptionPane.PLAIN_MESSAGE);
                if (input == null) break;

                opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1: agregarPelicula(); break;
                    case 2: agregarSala(); break;
                    case 3: realizarReserva(); break;
                    case 4: cancelarReserva(); break;
                    case 5: mostrarReservas(); break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Saliendo del sistema de reservas.", "Adiós", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                if (opcion != 0) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida. Debe ingresar un número.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } while (opcion != 6);
    }

    private static void inicializarDatos() {
        peliculas.add(new Pelicula("P001", "La Odisea Estelar", "Ciencia Ficción", 120));
        peliculas.add(new Pelicula("P002", "El Secreto del Valle", "Drama", 95));

        salas.add(new Sala(1, 50));
        salas.add(new Sala(2, 100));


        realizarReservaAutomatica("Juan Pérez", peliculas.get(0), salas.get(0), 5);
    }


    private static void realizarReservaAutomatica(String cliente, Pelicula p, Sala s, int asientos) {
        if (s.reservarAsientos(asientos)) {
            reservas.add(new Reserva(cliente, p, s, asientos));
        }
    }


    private static void agregarPelicula() {
        String codigo = JOptionPane.showInputDialog("Código de Película:");
        if (codigo == null) return;
        String titulo = JOptionPane.showInputDialog("Título de Película:");
        if (titulo == null) return;
        String genero = JOptionPane.showInputDialog("Género:");
        if (genero == null) return;
        int duracion = 0;
        try {
            duracion = Integer.parseInt(JOptionPane.showInputDialog("Duración (min):"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Duración inválida. Película NO agregada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        peliculas.add(new Pelicula(codigo, titulo, genero, duracion));
        JOptionPane.showMessageDialog(null, "Película agregada.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void agregarSala() {
        int numeroSala = 0, capacidad = 0;
        try {
            numeroSala = Integer.parseInt(JOptionPane.showInputDialog("Número de Sala:"));
            capacidad = Integer.parseInt(JOptionPane.showInputDialog("Capacidad Total:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Número o capacidad inválidos. Sala NO agregada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        salas.add(new Sala(numeroSala, capacidad));
        JOptionPane.showMessageDialog(null, "Sala agregada.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void realizarReserva() {
        if (peliculas.isEmpty() || salas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe haber películas y salas registradas primero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombreCliente = JOptionPane.showInputDialog("Nombre del Cliente:");
        if (nombreCliente == null) return;


        StringBuilder sbPeliculas = new StringBuilder("Seleccione Película:\n");
        for (int i = 0; i < peliculas.size(); i++) {
            sbPeliculas.append(i + 1).append(". ").append(peliculas.get(i).getTitulo()).append("\n");
        }
        int idxPelicula;
        try {
            idxPelicula = Integer.parseInt(JOptionPane.showInputDialog(sbPeliculas.toString())) - 1;
            if (idxPelicula < 0 || idxPelicula >= peliculas.size()) throw new IndexOutOfBoundsException();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selección de película inválida. Reserva cancelada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Pelicula peliculaSeleccionada = peliculas.get(idxPelicula);


        StringBuilder sbSalas = new StringBuilder("Seleccione Sala:\n");
        for (int i = 0; i < salas.size(); i++) {
            sbSalas.append(i + 1).append(". ").append(salas.get(i).toString()).append("\n");
        }
        int idxSala;
        try {
            idxSala = Integer.parseInt(JOptionPane.showInputDialog(sbSalas.toString())) - 1;
            if (idxSala < 0 || idxSala >= salas.size()) throw new IndexOutOfBoundsException();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selección de sala inválida. Reserva cancelada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Sala salaSeleccionada = salas.get(idxSala);


        int asientos;
        try {
            asientos = Integer.parseInt(JOptionPane.showInputDialog("Número de asientos a reservar (Disponible: " + salaSeleccionada.getCapacidadDisponible() + "):"));
            if (asientos <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Número de asientos inválido. Reserva cancelada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }


        if (salaSeleccionada.reservarAsientos(asientos)) {
            Reserva nuevaReserva = new Reserva(nombreCliente, peliculaSeleccionada, salaSeleccionada, asientos);
            reservas.add(nuevaReserva);
            JOptionPane.showMessageDialog(null, "Reserva exitosa: " + asientos + " asientos en Sala " + salaSeleccionada.getNumeroSala(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error: Capacidad insuficiente en la Sala " + salaSeleccionada.getNumeroSala(), "Error de Reserva", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void cancelarReserva() {
        if (reservas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay reservas para cancelar.", "Cancelación", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sbReservas = new StringBuilder("Seleccione la Reserva a Cancelar:\n");
        for (int i = 0; i < reservas.size(); i++) {
            sbReservas.append(i + 1).append(". ").append(reservas.get(i).toString()).append("\n");
        }

        int idxReserva;
        try {
            idxReserva = Integer.parseInt(JOptionPane.showInputDialog(sbReservas.toString())) - 1;
            if (idxReserva < 0 || idxReserva >= reservas.size()) throw new IndexOutOfBoundsException();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selección de reserva inválida. Cancelación fallida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Reserva reservaACancelar = reservas.get(idxReserva);
        Sala salaAsociada = reservaACancelar.getSala();


        salaAsociada.liberarAsientos(reservaACancelar.getNumAsientosReservados());

        reservas.remove(idxReserva);

        JOptionPane.showMessageDialog(null, "Reserva de " + reservaACancelar.getNombreCliente() + " cancelada. Asientos liberados.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void mostrarReservas() {
        if (reservas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay reservas registradas.", "Listado de Reservas", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder("--- LISTADO DE RESERVAS ---\n");
        for (Reserva r : reservas) {
            sb.append(r.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Listado de Reservas", JOptionPane.PLAIN_MESSAGE);
    }
}
