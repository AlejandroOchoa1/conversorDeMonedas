import java.sql.SQLOutput;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        System.out.println("\n*****************************************************");
        System.out.println("\n Bienvenido/a al Conversor de monedas");
        System.out.println("\n*****************************************************");

        String menu = """
                ** Escribe el número de la opción deseada de moneda a convertir: **
                    1 - Dólar => Quetzales
                    2 - Quetzales => Dólar
                    3 - Dólar => Euro
                    4 - Euro => Dólar
                    5 - Dólar => Real brasileño
                    6 - Real brasileñoo => Dólar
                    7 - Dólar => Peso chileno
                    8 - Peso chileno => Dólar
                    9 - Dólar => Boliviano
                    10 - Boliviano => Dólar
                    11 - Salir
                *******************************************************************
                """;

        Scanner teclado = new Scanner(System.in);
        boolean seguir = true;

        while(seguir){
            System.out.println(menu);
            System.out.println("Selecciona una opción");
            int opcion = teclado.nextInt();

            switch(opcion){
                case 1,2,3,4,5,6,7,8,9,10 -> realizarConversion(opcion, teclado);
                case 11 ->{
                    System.out.println("Saliendo del programa... ");
                    System.out.println("Gracias por Consultar ");
                    seguir = false;
                }
            }
        }

    }
    private static void realizarConversion(int opcion, Scanner teclado){
        String monedaOrigen = "";
        String monedaDestino = "";

        switch (opcion) {
            case 1 -> { monedaOrigen = "USD"; monedaDestino = "GTQ"; }
            case 2 -> { monedaOrigen = "GTQ"; monedaDestino = "USD"; }
            case 3 -> { monedaOrigen = "USD"; monedaDestino = "EUR"; }
            case 4 -> { monedaOrigen = "EUR"; monedaDestino = "USD"; }
            case 5 -> { monedaOrigen = "USD"; monedaDestino = "BRL"; }
            case 6 -> { monedaOrigen = "BRL"; monedaDestino = "USD"; }
            case 7 -> { monedaOrigen = "USD"; monedaDestino = "CLP"; }
            case 8 -> { monedaOrigen = "CLP"; monedaDestino = "USD"; }
            case 9 -> { monedaOrigen = "USD"; monedaDestino = "BOB"; }
            case 10 -> { monedaOrigen = "BOB"; monedaDestino = "USD"; }
        }
        System.out.println("Ingresa la cantidad de " + obtenerNombreMoneda(monedaOrigen) + ": ");
        String input = teclado.next();
        input = input.replace(",", "."); //el replace cambia la coma por el punto

        double cantidad;
        try{
            cantidad = Double.parseDouble(input); //convertir a double el dato que viene del input
        } catch (NumberFormatException e) {
            System.out.println("Entrada No válida. Por favor ingresa un número válido");
            return;
        }if (cantidad < 0 ){
            System.out.println("Cantidad Inválida. No se permiten numeros negativos.");
            return;
        }

        double tasaCambio = ConsultaMoneda.obtenerTasaDeCambio(monedaOrigen, monedaDestino);

            if(tasaCambio != -1 ){
                double resultado = cantidad * tasaCambio;
                System.out.println(String.format("%.2f %s son %.2f %s.", cantidad, obtenerNombreMoneda(monedaOrigen),
                        resultado, obtenerNombreMoneda(monedaDestino)));

                DatosBusqueda busqueda = new DatosBusqueda(monedaOrigen, cantidad, monedaDestino,tasaCambio, resultado);
                HistorialConsultaMoneda.guardarBusqueda(busqueda);
            }else{
                System.out.println("Error al obtener la tasa de cambio");
            }
        }

    public static String obtenerNombreMoneda(String codigo){
        return switch (codigo){
        case "USD" -> "Dólares";
        case "GTQ" -> "Quetzales Guatemala";
        case "EUR" -> "Euros";
        case "BRL" -> "Reales brasileños";
        case "CLP" -> "Pesos chilenos";
        case "BOB" -> "Bolivianos";
        default -> "Moneda desconocida";
        };
    }
}


