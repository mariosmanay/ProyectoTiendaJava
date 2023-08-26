public class ProductoLimpieza extends Producto {
    private String tipoAplicacion;

    // Constructores
    public ProductoLimpieza(String identificador, String descripcion, int cantidadEnStock, double precioVenta, double costoPorUnidad, boolean disponibleParaVenta, String tipoAplicacion) {
        super(identificador, descripcion, cantidadEnStock, precioVenta, costoPorUnidad, disponibleParaVenta);
        this.tipoAplicacion = tipoAplicacion;
    }

    // Implementacion de los métodos de Producto

    @Override
    public String getTipoEnvase() {
        return "N/A";
    }

    @Override
    public boolean esImportado() {

        return false;
    }

    @Override
    public void setPorcentajeDescuento(double porcentajeDescuento) {
        if (tipoAplicacion.equals("COCINA") || tipoAplicacion.equals("PISOS")) {
            if (porcentajeDescuento >= 10 && porcentajeDescuento <= 25) {
                super.setPorcentajeDescuento(porcentajeDescuento);
            } else {
                System.out.println("El porcentaje de descuento para productos de limpieza de cocina o pisos debe estar entre 10% y 25%.");
            }
        } else {
            super.setPorcentajeDescuento(porcentajeDescuento);
        }
    }
}