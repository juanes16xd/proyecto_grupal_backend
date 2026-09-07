public class Libro {

    //agregar atributos
    private String titulo;
    private String autor;
    private String codigo;
    private String genero;
    private int AnioDePublicacion;
    private int CopiasDisponibles;

    //constructor
    public Libro(String titulo, String autor, String codigo, String genero, int anioPublicacion, int copiasDisponibles) {

        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
        this.genero = genero;
        this.AnioDePublicacion = AnioDePublicacion;
        this.CopiasDisponibles = CopiasDisponibles;
    }

        //Getters y Setters
        public String getTitulo() {
            return titulo;
        }
        public void setTitulo(String titulo) {
        this.titulo = titulo;
        }

        public String getAutor() {
        return autor;
        }
        public void setAutor(String autor) {
        this.autor = autor;
        }

        public String getCodigo() {
        return codigo;
        }
        public void setCodigo(String codigo) {
        this.codigo = codigo;
        }

        public String getGenero() {
        return genero;
        }
        public void setGenero(String genero) {
        this.genero = genero;
        }

        public int getAnioDePublicacion() {
        return AnioDePublicacion;
        }
        public void setAnioDePublicacion(int AnioDePublicacion) {
        this.AnioDePublicacion = AnioDePublicacion;
        }

        public int getCopiasDisponibles() {
        return CopiasDisponibles;
        }
        public void setCopiasDisponibles(int CopiasDisponibles) {
        this.CopiasDisponibles = CopiasDisponibles;
        }
    }

public class Libro {
}
