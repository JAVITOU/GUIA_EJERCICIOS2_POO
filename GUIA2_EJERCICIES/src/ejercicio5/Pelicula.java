package ejercicio5;

public class Pelicula {
    private String codigo;
    private String titulo;
    private String genero;
    private int duracion;

    public Pelicula(String codigo, String titulo, String genero, int duracion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
    }


    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }



    @Override
    public String toString() {
        return "[" + codigo + "] " + titulo + " (" + genero + ", " + duracion + "min)";
    }
}
