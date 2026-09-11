public class Main {

    public static void main(String[] args) {

        BibliotecaMain biblioteca = new BibliotecaMain();

        VentanaPrincipal ventana = new VentanaPrincipal(biblioteca);

        ventana.setVisible(true);
    }
}