import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class VentanaPrincipal extends JFrame {

    private BibliotecaMain biblioteca;

    private JTextField txtTitulo, txtAutor, txtCodigo;
    private JTextField txtGenero, txtAnio, txtCopias;
    private JTextField txtFiltroAutor;

    private JTable tabla;
    private DefaultTableModel modelo;

    public VentanaPrincipal(BibliotecaMain biblioteca) {

        this.biblioteca = biblioteca;

        setTitle("Biblioteca");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        crearVentana();
        actualizarTabla(biblioteca.obtenerTodos());
    }

    private void crearVentana() {

        JPanel formulario = new JPanel(new GridLayout(7, 2));

        txtTitulo = new JTextField();
        txtAutor = new JTextField();
        txtCodigo = new JTextField();
        txtGenero = new JTextField();
        txtAnio = new JTextField();
        txtCopias = new JTextField();

        formulario.add(new JLabel("Título:"));
        formulario.add(txtTitulo);

        formulario.add(new JLabel("Autor:"));
        formulario.add(txtAutor);

        formulario.add(new JLabel("Código / ISBN:"));
        formulario.add(txtCodigo);

        formulario.add(new JLabel("Género:"));
        formulario.add(txtGenero);

        formulario.add(new JLabel("Año:"));
        formulario.add(txtAnio);

        formulario.add(new JLabel("Copias:"));
        formulario.add(txtCopias);

        JButton btnAgregar = new JButton("Agregar");
        JButton btnEliminar = new JButton("Eliminar");

        formulario.add(btnAgregar);
        formulario.add(btnEliminar);

        String[] columnas = {
                "Título", "Autor", "Código",
                "Género", "Año", "Copias"
        };

        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabla);

        JPanel filtro = new JPanel();

        txtFiltroAutor = new JTextField(15);

        JButton btnFiltrar = new JButton("Filtrar");
        JButton btnMostrarTodos = new JButton("Mostrar todos");

        filtro.add(new JLabel("Autor:"));
        filtro.add(txtFiltroAutor);
        filtro.add(btnFiltrar);
        filtro.add(btnMostrarTodos);

        setLayout(new BorderLayout());

        add(formulario, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(filtro, BorderLayout.SOUTH);

        btnAgregar.addActionListener(e -> agregarLibro());
        btnEliminar.addActionListener(e -> eliminarLibro());
        btnFiltrar.addActionListener(e -> filtrar());
        btnMostrarTodos.addActionListener(e ->
                actualizarTabla(biblioteca.obtenerTodos()));
    }

    private void agregarLibro() {

        String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();
        String codigo = txtCodigo.getText();
        String genero = txtGenero.getText();

        if (titulo.isEmpty() || autor.isEmpty() ||
                codigo.isEmpty() || genero.isEmpty() ||
                txtAnio.getText().isEmpty() ||
                txtCopias.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Todos los campos son obligatorios.");

            return;
        }

        int anio;
        int copias;

        try {
            anio = Integer.parseInt(txtAnio.getText());
            copias = Integer.parseInt(txtCopias.getText());
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this,
                    "Año y copias deben ser números.");

            return;
        }

        int anioActual = java.time.Year.now().getValue();

        if (anio > anioActual) {
            JOptionPane.showMessageDialog(this,
                    "El año no puede ser mayor al actual.");
            return;
        }

        if (copias < 0) {
            JOptionPane.showMessageDialog(this,
                    "Las copias no pueden ser negativas.");
            return;
        }

        if (biblioteca.ExisteCodigo(codigo)) {
            JOptionPane.showMessageDialog(this,
                    "Ese código ya existe.");
            return;
        }

        Libro libro = new Libro(
                titulo,
                autor,
                codigo,
                genero,
                anio,
                copias
        );

        biblioteca.agregarLibro(libro);

        JOptionPane.showMessageDialog(this,
                "Libro agregado correctamente.");

        actualizarTabla(biblioteca.obtenerTodos());

        txtTitulo.setText("");
        txtAutor.setText("");
        txtCodigo.setText("");
        txtGenero.setText("");
        txtAnio.setText("");
        txtCopias.setText("");
    }

    private void eliminarLibro() {

        int fila = tabla.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this,
                    "Selecciona un libro.");
            return;
        }

        String codigo = modelo.getValueAt(fila, 2).toString();

        int respuesta = JOptionPane.showConfirmDialog(
                this,
                "¿Eliminar este libro?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION
        );

        if (respuesta == JOptionPane.YES_OPTION) {

            biblioteca.eliminarlibro(codigo);

            actualizarTabla(biblioteca.obtenerTodos());
        }
    }

    private void filtrar() {

        String autor = txtFiltroAutor.getText().trim();

        if (autor.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Escribe un autor.");
            return;
        }

        actualizarTabla(biblioteca.FiltrarPorAutor(autor));
    }

    private void actualizarTabla(ArrayList<Libro> libros) {

        modelo.setRowCount(0);

        for (Libro libro : libros) {

            Object[] fila = {
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getCodigo(),
                    libro.getGenero(),
                    libro.getAnioDePublicacion(),
                    libro.getCopiasDisponibles()
            };

            modelo.addRow(fila);
        }
    }
}