public abstract class Producto {
    private String identificador;
    private String descripcion;
    private int cantidadEnStock;
    private double precioVenta;
    private double costoPorUnidad;
    private boolean disponibleParaVenta;

    // Constructor
    public Producto(String identificador, String descripcion, int cantidadEnStock, double precioVenta, double costoPorUnidad, boolean disponibleParaVenta) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.cantidadEnStock = cantidadEnStock;
        this.precioVenta = precioVenta;
        this.costoPorUnidad = costoPorUnidad;
        this.disponibleParaVenta = disponibleParaVenta;
    }

    // Métodos getters y setters para todas las propiedades

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getCostoPorUnidad() {
        return costoPorUnidad;
    }

    public void setCostoPorUnidad(double costoPorUnidad) {
        this.costoPorUnidad = costoPorUnidad;
    }

    public boolean isDisponibleParaVenta() {
        return disponibleParaVenta;
    }

    public void setDisponibleParaVenta(boolean disponibleParaVenta) {
        this.disponibleParaVenta = disponibleParaVenta;
    }

    // Métodos abstractos que deben ser implementados por las clases hijas
    public abstract String getTipoEnvase();
    public abstract boolean esImportado();

    public void setPorcentajeDescuento(double porcentajeDescuento) {
    }

    public double getPorcentajeDescuento() {
        return 0;
    }

    public double getPorcentajeGanancia() {
        return 0;
    }
}

