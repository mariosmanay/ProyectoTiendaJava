public class ProductoEnvasado extends Producto {
    private String tipoEnvase;
    private boolean importado;

    // Constructores
    public ProductoEnvasado(String identificador, String descripcion, int cantidadEnStock, double precioVenta,
                            double costoPorUnidad, boolean disponibleParaVenta, String tipoEnvase, boolean importado)
    {
        super(identificador, descripcion, cantidadEnStock, precioVenta, costoPorUnidad, disponibleParaVenta);
        this.tipoEnvase = tipoEnvase;
        this.importado = importado;
    }

    // Implementacion de los métodos de Producto
    @Override
    public String getTipoEnvase() {
        return tipoEnvase;
    }

    @Override
    public boolean esImportado() {
        return importado;
    }
    @Override
    public double getPrecioVenta() {
        double precio = super.getPrecioVenta();
        if (esImportado()) {
            precio += precio * 0.10; // Aplicar impuesto del 10%
        }
        return precio;
    }
}

