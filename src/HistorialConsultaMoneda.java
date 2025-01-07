import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class HistorialConsultaMoneda {
    private static final String RUTA_ARCHIVO = "historia.json"; // crea nombre del archivo 
    private static List<DatosBusqueda> historial = new ArrayList<>(); // crea la lista dinamica para guardar los datos a obtener

    public static void guardarBusqueda(DatosBusqueda datosBusqueda){
        historial.add(datosBusqueda);
     escribirHistorialEnArchivo();
    }

    private static void escribirHistorialEnArchivo(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        DecimalFormat decimalFormatTasa = new DecimalFormat("#.#########"); // formatea lo decimales
        DecimalFormat decimalFormatResultado = new DecimalFormat("#.##");

        JsonArray jsonArray = new JsonArray();

        // Agregar todas las búsquedas al JSON
        for (DatosBusqueda busqueda : historial) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("monedaOrigen",busqueda.getMonedaOrigen());
            jsonObject.addProperty("cantidad", busqueda.getCantidad());
            jsonObject.addProperty("monedaDestino", busqueda.getMonedaDestino());
            jsonObject.addProperty("tasa", decimalFormatTasa.format(busqueda.getTasaDeCambio())); // Formatear tasa
            jsonObject.addProperty("resultado", decimalFormatResultado.format(busqueda.getResultado())); // Formatear resultado
            jsonArray.add(jsonObject);
        }

        // Guardar el JSON en un archivo
        try (FileWriter writer = new FileWriter(RUTA_ARCHIVO)) {
            writer.write(gson.toJson(jsonArray));
            writer.close();
            System.out.println("Historial de búsquedas guardado exitosamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar el historial: " + e.getMessage());
        }

    }
}
