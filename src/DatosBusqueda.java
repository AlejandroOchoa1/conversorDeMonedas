public class DatosBusqueda {
    private final String monedaOrigen;
    private final double cantidad;
    private final String monedaDestino;
    private final double tasaCambio;
    private final double resultado;

    public DatosBusqueda(String monedaOrigen, double cantidad, String monedaDestino, double tasaDeCambio, double resultado){
        this.monedaOrigen = monedaOrigen;
        this.cantidad = cantidad;
        this. monedaDestino = monedaDestino;
        this.tasaCambio = tasaDeCambio;
        this.resultado = resultado;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public double getTasaDeCambio() {
        return tasaCambio;
    }

    public double getResultado() {
        return resultado;
    }
}
