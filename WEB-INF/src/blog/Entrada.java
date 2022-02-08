package blog;

import java.time.LocalDate;

public class Entrada {

    private Integer id;
    private String titulo;
    private String texto;
    private LocalDate fecha;
    private String autor;

    public Entrada() {
        id=0;
        titulo="";
        texto="";
        fecha=LocalDate.now();
        autor="";
    }

    public Entrada(Integer id, String titulo, String texto, LocalDate fecha, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.fecha = fecha;
        this.autor = autor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entrada entrada = (Entrada) o;

        return id != null ? id.equals(entrada.id) : entrada.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Entrada{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", texto='" + texto + '\'' +
                ", fecha=" + fecha +
                ", autor='" + autor + '\'' +
                '}';
    }

}
