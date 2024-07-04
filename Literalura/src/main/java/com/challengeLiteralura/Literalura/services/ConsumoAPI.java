package com.challengeLiteralura.Literalura.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ConsumoAPI {

    public String obtenerDatos(String url){
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(20)) // Timeout de conexión
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(20))
                .build();
        HttpResponse<String> response;

        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();

            // Prints de Prueba
//            System.out.println("Código de estado: " + statusCode);
//            System.out.println("Encabezados de respuesta: " + response.headers());
//            System.out.println("Cuerpo de respuesta: " + response.body());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Ocurrio un error " + e);
        }
        // Aquí se guarda el cuerpo de la consulta en formato string
        String json = response.body();

        if (json == null || json.isEmpty()) {
            throw new RuntimeException("La respuesta JSON está vacía");
        }

        return json;
    }
}
