import java.util.List;
import java.util.Map;


public class ApplicacionTienda {
    public static void main(String[] args) {
        Tienda miTienda = new Tienda("Mi Tienda", 100);

        // Creacion de todos los productos
        ProductoEnvasado aceite = new ProductoEnvasado("AM437", "Aceite", 20, 20, 15, true, "Plástico", true);
        Bebida cerveza = new Bebida("AC456", "Cerveza", 30, 15, 10, true, true, 12, true);
        ProductoLimpieza esponja = new ProductoLimpieza("AZ789", "Esponja", 40, 10, 5, true, "COCINA");

        miTienda.agregarProducto(aceite);
        miTienda.agregarProducto(cerveza);
        miTienda.agregarProducto(esponja);

        // Algunas operaciones
        miTienda.comprarProducto(aceite, 5);
        miTienda.venderProductos(Map.of(cerveza, 4, esponja, 5));

        // Información de stock y saldo
        System.out.println("Datos de stock:");
        for (Producto producto : miTienda.getStockProductos().values()) {
            System.out.println(producto.getIdentificador() + " - " + producto.getDescripcion() + ": " + producto.getCantidadEnStock());
        }
        System.out.println("Saldo en caja: " + miTienda.getSaldoCaja());

    }
}