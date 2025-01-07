# conversorDeMonedas

Este proyecto es un conversor de monedas que utiliza la API ExchangeRate para obtener tasas de cambio actualizadas. Está diseñado como primer desafío de la especialización Back-End de Alura Latam.

Estructura del Proyecto
El proyecto tiene un package que tiene las siguientes clases:

* Clase Principal (main): Punto de entrada de la aplicación. Muestra un menú al usuario para seleccionar opciones de conversión de monedas. Responsabilidades: Captura las entradas del usuario, gestiona la lógica de conversión y llama a otros métodos según sea necesario.

* Clase ConsultaMoneda: Interactúa con la API de ExchangeRate para obtener tasas de cambio. Responsabilidades: Configura la API Key desde una variable de entorno, realiza solicitudes HTTP para obtener tasas de cambio y proporciona métodos para convertir monedas.

* Clase DatosBusqueda: Representa una búsqueda de conversión de moneda. Responsabilidades: Almacena la moneda de origen, la cantidad, la moneda de destino, la tasa de cambio y el resultado de la conversión.

* Clase HistorialConsultaMoneda: Maneja el historial de conversiones y lo guarda en un archivo JSON. Responsabilidades: Mantiene una lista de objetos Busqueda, serializa esta lista a formato JSON y la guarda en un archivo historial.json.

Utiliza las siguientes bibliotecas y herramientas:
Java Collections: Para manejar listas y colecciones de datos.
Gson: Para convertir objetos Java a JSON y viceversa.
JsonObject, JsonParser y JsonArray: Para manejar estructuras de respuestas JSON.
HTTP Client y HTTP Request: Para crear y realizar solicitudes a la API.
HTTP Response: Enviar la solicitud y obtener la respuesta.
Postman: Para pruebas de la API.
Dependencias
Asegúrate de tener la siguiente librería en tu proyecto:

Gson 2.10.1 o superior
Requisitos
JDK versión 17 o superior.
IDE (Recomendado: IntelliJ IDEA).
Configuración de la variable de entorno para la API_KEY.

Para ejecutar el proyecto: Abre el proyecto en IntelliJ IDEA. Asegúrate de que todas las dependencias estén correctamente configuradas. Ejecuta la clase Main para iniciar el conversor de monedas.

Configuración de la API
Obtén una clave de API de ExchangeRate.
Crea una variable de entorno llamada API_KEY (tal como se llama en el código en la clase ConversorAPI) y coloca tu clave de API dentro de ella.
Esto asegura que tu clave se mantenga segura y no esté expuesta en el código.
Configura las dependencias:
Asegúrate de tener la librería gson-2.10.1.jar en tu proyecto. Agrega las dependencias necesarias en tu configuración de proyecto en IntelliJ IDEA.

Forma de Uso
Una vez que hayas instalado el proyecto y configurado la API_KEY, puedes ejecutar el conversor de monedas. El programa presenta un menú al usuario con las siguientes opciones:

Opciones de Conversión
El menú incluirá las siguientes monedas para convertir:

menu de inicio

*Proceso de Conversión
El usuario podrá elegir entre las opciones disponibles.

*Podrá realizar múltiples consultas dentro del menú.

![image](https://github.com/user-attachments/assets/b1c48098-9f9b-42b7-b308-24a45b929f6f)




Un ejemplo de respuesta:

* buqueda

![image](https://github.com/user-attachments/assets/b91803a5-1b1c-46d9-9029-28bb4013f8a5)

* Historial de busqueda

![image](https://github.com/user-attachments/assets/d305cfd2-399d-4ea4-ae1c-c11b851510ce)


Al elegir la opción 11, el sistema sale y da un mensaje de despedida, como se ve en el ejemplo anterior. Además, genera el historial de consultas (archivo .json).

Asimismo, al iniciar una nueva consulta/s, este historial se borra y muestra un nuevo listado con todas las consultas efectuadas.

Todas las búsquedas realizadas se guardarán en el archivo historial.json.
