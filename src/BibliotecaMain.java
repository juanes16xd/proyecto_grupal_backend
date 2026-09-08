import java.util.ArrayList;
import java.util.HashMap;
public class BibliotecaMain {

    //ArrayList y HashMap de libros
    private ArrayList<Libro> libros;
    private HashMap<String, ArrayList<Libro>> LibrosPorAutor;

    //Array
    public BibliotecaMain() {
        libros = new ArrayList<>();
        LibrosPorAutor = new HashMap<>();
    }

    //metodos
    public boolean agregarLibro(Libro libro) {

        for (Libro l : libros) {
            if (l.getCodigo().equalsIgnoreCase(libro.getCodigo())) {
                return false;
            }
        }

        libros.add(libro);
        String autor = libro.getAutor();

        if (!LibrosPorAutor.containsKey(autor)) {
            LibrosPorAutor.put(autor, new ArrayList<>());
        }
        LibrosPorAutor.get(autor).add(libro);
        return true;
    }

    public void eliminarlibro(String codigo) {

        Libro libroEliminar = null;

        for(Libro libro : libros) {
            if(libro.getCodigo().equalsIgnoreCase(codigo)) {
                libroEliminar = libro;
                break;
            }
        }

        if(libroEliminar != null) {

            libros.remove (libroEliminar);

            String autor = libroEliminar.getAutor();

            ArrayList<Libro> librosAutor = LibrosPorAutor.get(autor);

            if(librosAutor != null) {
                librosAutor.remove(libroEliminar);

                if(librosAutor.isEmpty()) {
                    LibrosPorAutor.remove(autor);
                }
            }
        }
    }

    public ArrayList<Libro> obtenerTodos() {
        return new ArrayList<>(libros);
    }

    public ArrayList<Libro> FiltrarPorAutor(String autor) {
        ArrayList<Libro> resultado = new ArrayList<>();

        if(LibrosPorAutor.containsKey(autor)) {
            resultado.addAll(LibrosPorAutor.get(autor));
        }
        return resultado;
    }
     public boolean ExisteCodigo(String codigo) {

        for(Libro libro : libros) {
            if(libro.getCodigo().equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
     }
}




