import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Tienda {
    private String nombre;
    private int maxProductosEnStock;
    private double saldoCaja;


    public void setStockProductos(Map<String, Producto> stockProductos) {
        this.stockProductos = stockProductos;
    }

    private Map<String, Producto> stockProductos;

    // Constructor
    public Tienda(String nombre, int maxProductosEnStock) {
        this.nombre = nombre;
        this.maxProductosEnStock = maxProductosEnStock;
        this.saldoCaja = 0.0;
        this.stockProductos = new HashMap<>();
    }

    // Métodos para gestionar el stock y las ventas
    public void agregarProducto(Producto producto) {
        if (stockProductos.size() < maxProductosEnStock) {
            stockProductos.put(producto.getIdentificador(), producto);
        } else {
            System.out.println("No se puede agregar más productos. Stock lleno.");
        }
    }

    public Map<String, Producto> getStockProductos() {
        return stockProductos;
    }
    public double getSaldoCaja() {
        return saldoCaja;
    }

    public void venderProducto(String identificador) {
        Producto producto = stockProductos.get(identificador);
        if (producto != null && producto.isDisponibleParaVenta()) {
            double precioVenta = producto.getPrecioVenta();
            saldoCaja += precioVenta;
            producto.setCantidadEnStock(producto.getCantidadEnStock() - 1);
            System.out.println("Producto vendido: " + producto.getDescripcion());
        } else {
            System.out.println("Producto no disponible para la venta.");
        }
    }

    public void comprarProducto(Producto producto, int cantidad) {
        double costoTotal = producto.getCostoPorUnidad() * cantidad;
        if (saldoCaja >= costoTotal && stockProductos.size() < maxProductosEnStock) {
            saldoCaja -= costoTotal;
            producto.setCantidadEnStock(producto.getCantidadEnStock() + cantidad);
            stockProductos.put(producto.getIdentificador(), producto);
            System.out.println("Producto agregado a la tienda: " + producto.getDescripcion());
        } else {
            System.out.println("El producto no puede ser agregado a la tienda debido a saldo insuficiente en la caja o stock lleno.");
        }
    }

    public void venderProductos(Map<Producto, Integer> productosAVender) {
        double totalVenta = 0.0;
        for (Map.Entry<Producto, Integer> entry : productosAVender.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            if (producto.isDisponibleParaVenta() && producto.getCantidadEnStock() >= cantidad) {
                double precioVenta = producto.getPrecioVenta() * cantidad;
                totalVenta += precioVenta;
                producto.setCantidadEnStock(producto.getCantidadEnStock() - cantidad);
                System.out.println(producto.getIdentificador() + " " + producto.getDescripcion() + " " + cantidad + " x " + producto.getPrecioVenta());
            } else {
                System.out.println("El producto " + producto.getIdentificador() + " no se encuentra disponible o no hay suficiente stock.");
            }
        }
        System.out.println("TOTAL VENTA: " + totalVenta);
    }

    public List<String> obtenerComestiblesConMenorDescuento(double porcentajeDescuento) {
        return stockProductos.values()
                .stream()
                .filter(producto -> producto instanceof ProductoComestible && !producto.esImportado())
                .filter(producto -> producto.getPorcentajeDescuento() < porcentajeDescuento)
                .sorted((p1, p2) -> Double.compare(p1.getPrecioVenta(), p2.getPrecioVenta()))
                .map(producto -> producto.getDescripcion().toUpperCase())
                .collect(Collectors.toList());
    }

    public void listarProductosConUtilidadesInferiores(double porcentajeUtilidad) {
        stockProductos.values()
                .stream()
                .filter(producto -> producto.getPorcentajeGanancia() < porcentajeUtilidad)
                .forEach(producto -> System.out.println(
                        "Código: " + producto.getIdentificador() +
                                ", Descripción: " + producto.getDescripcion() +
                                ", Cantidad en stock: " + producto.getCantidadEnStock()));
    }

}


