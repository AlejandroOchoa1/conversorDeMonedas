import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConsultaMoneda {
    private static final String API_KEY = "Ingresa tu API_KEY"; // Ingresa tu API_KEY generada en URL: -> https://www.exchangerate-api.com/

    public static double obtenerTasaDeCambio(String monedaOrigen, String monedaDestino) {
        //URL
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+API_KEY+"/latest/"+monedaOrigen);
    try{
        //Crear el cliente HTTP
        HttpClient client = HttpClient.newHttpClient();
        //Crear la Solicitud
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion).build();

        //Enviar la solicitud y obtener respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //Parsear el cuerpo del Json
        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();

        //Extraer el cuerpo del Json
        return jsonObject.getAsJsonObject("conversion_rates").get(monedaDestino).getAsDouble();

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}