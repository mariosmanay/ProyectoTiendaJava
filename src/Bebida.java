public class Bebida extends Producto implements ProductoConDescuento {
    private boolean esAlcoholica;
    private double graduacionAlcoholica;
    private boolean importado;

    // Constructor
    public Bebida(String identificador, String descripcion, int cantidadEnStock, double precioVenta, double costoPorUnidad, boolean disponibleParaVenta, boolean esAlcoholica, double graduacionAlcoholica, boolean importado) {
        super(identificador, descripcion, cantidadEnStock, precioVenta, costoPorUnidad, disponibleParaVenta);
        this.esAlcoholica = esAlcoholica;
        this.graduacionAlcoholica = graduacionAlcoholica;
        this.importado = importado;
    }

    // Implementar los métodos abstractos de Producto
    @Override
    public String getTipoEnvase() {
        return "N/A"; // Las bebidas no tienen tipo de envase
    }

    @Override
    public boolean esImportado() {
        return importado;
    }

    @Override
    public void setPorcentajeDescuento(double porcentajeDescuento) {
        if (esAlcoholica) {
            if (porcentajeDescuento <= 15) {
                super.setPorcentajeDescuento(porcentajeDescuento);
            } else {
                System.out.println("El porcentaje de descuento para bebidas alcohólicas no puede superar el 15%.");
            }
        } else {
            super.setPorcentajeDescuento(porcentajeDescuento);
        }
    }

    @Override
    public double getPorcentajeDescuento() {
        return 0;
    }

    @Override
    public double getPrecioVentaConDescuento() {
        return 0;
    }
}

