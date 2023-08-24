import java.util.List;
import java.util.Map;


public class ApplicacionTienda {
    public static void main(String[] args) {
        Tienda miTienda = new Tienda("Mi Tienda", 100);

        // Crear productos
        ProductoEnvasado aceite = new ProductoEnvasado("AB123", "Aceite", 50, 20, 15, true, "Plástico", true);
        Bebida vino = new Bebida("AC456", "Vino", 30, 15, 10, true, true, 12, true);
        ProductoLimpieza detergente = new ProductoLimpieza("AZ789", "Detergente", 40, 10, 5, true, "COCINA");

        miTienda.agregarProducto(aceite);
        miTienda.agregarProducto(vino);
        miTienda.agregarProducto(detergente);

        // Realizar operaciones
        miTienda.comprarProducto(aceite, 10);
        miTienda.venderProductos(Map.of(vino, 2, detergente, 5));

        // Mostrar información de stock y saldo
        System.out.println("Datos de stock:");
        for (Producto producto : miTienda.getStockProductos().values()) {
            System.out.println(producto.getIdentificador() + " - " + producto.getDescripcion() + ": " + producto.getCantidadEnStock());
        }
        System.out.println("Saldo en caja: " + miTienda.getSaldoCaja());

        // Ejemplo de uso de obtenerComestiblesConMenorDescuento
        List<String> comestiblesConMenorDescuento = miTienda.obtenerComestiblesConMenorDescuento(15);
        System.out.println("Comestibles con descuento menor al 15%: " + comestiblesConMenorDescuento);

        // Ejemplo de uso de listarProductosConUtilidadesInferiores
        System.out.println("Productos con utilidades inferiores al 10%:");
        miTienda.listarProductosConUtilidadesInferiores(10);
    }
}