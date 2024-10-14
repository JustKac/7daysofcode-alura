package service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import enumerator.HttpStatusCode;
import enumerator.PokemonResource;

public class PokeApiService {

    private final static String REQUEST_URL = "https://pokeapi.co/api/v2/";
    private static HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofMinutes(5)).build();

    public static String buscaPaginada(PokemonResource resource, int limit, int offset) throws Exception {

        String urlParaChamada = REQUEST_URL + resource.getResource() + "?limit=" + limit + "&offset=" + offset;

        try {

            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(urlParaChamada))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != HttpStatusCode.OK.getCode()) {
                throw new Exception("ERRO: " + HttpStatusCode.getHttpStatusCode(response.statusCode()));
            }

            return response.body();
        } catch (Exception e) {
            throw new Exception("ERRO: " + e);
        }
    }
}
