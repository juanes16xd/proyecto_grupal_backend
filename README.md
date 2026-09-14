Nombre del proyecto:
proyecto grupal, Sistema de Gestión De Biblioteca POO

Integrantes: Juan Esteban Palma y José Rafael Márquez

Descripción del proyecto:
El proyecto permite:
1. registrar nuevos libros.
2. mostrar los libros registrados en una tabla.
3. filtrar libros por autor.
4. eliminar libros seleccionados.
5. confirmar la eliminación de un libro.
6. Validar que los campos sean obligatorios.
7. Validar que el año de publicación no sea mayor al año actual.
8. Validar que las copias disponibles no sean negativas.
9. Evitar que se registren libros con Códigos o ISBN repetidos.

Estructura Del Proyecto: 
El proyecto se encuentra dividido en 4 clases:
-LIBRO: representa un libro y contiene sus datos como un título, autor, código, genero, año y copias disponibles. Utilizando encapsulamiento mediante atributos privados y métodos Getters y Setters.
-Biblioteca: Administra los libros utilizando un ArrayList como colección principal y un HashMap para organizarlos por autor.
-VentanaPrincipal: Contiene la interfaz gráfica desarrollada con swing. Utiliza componentes como JFrame, JPanel, JTextField, JButton y JTable.
-Main: Contiene el método Main y ejecuta el código.

El proyecto aplica conceptos de POO como encapsulamiento, herencia y sobreescritura de métodos, además del uso de constructores, métodos, arreglos, ciclos y estructuras de datos.

Requisitos:
para ejecutar el proyecto se necesita: 
-JAVA JDK instalado.
-un IDE compatible con java, como Intellij IDEA o Eclipse.

Como Compilar Y Ejecutar:
Desde un IDE:
1. Abrir el proyecto.
2. Verificar que las 4 clases .java se encuentren la carpeta src.
3. Ejecutar la clase Main.java.
4. Se abrirá la venta principal del proyecto.

Uso Del Sistema:
1. Ingresar los datos del libro en el formulario.
2. Presionar Agregar para registrarlo.
3. Los libros registrados aparecerán en la tabla.
4. Para libros de un autor específico, escribir el nombre en el campo de filtro y luego presionar Filtrar.
5. Para eliminar un libro, seleccionarlo en la tabla y de ahí presionar Eliminar
6. El sistema solicitara la confirmación antes de eliminarlo.
7. El botón mostrar todos permite visualizar todos los libros.

Uso De IA:
Hicimos uso de la inteligencia artificial para que nos de contexto de como funciona el hashmap, los componentes: JFrame, Panel, etc y para ayudarnos a corregir errores que el código presentara.
