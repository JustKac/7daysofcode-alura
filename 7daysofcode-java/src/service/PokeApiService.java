package service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import enumerator.HttpStatusCode;
import enumerator.PokemonResource;
import model.Pokemon;
import util.JsonUtil;

public class PokeApiService {

    private final static String REQUEST_URL = "https://pokeapi.co/api/v2";
    private static HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofMinutes(5)).build();

    public static String buscaPaginada(PokemonResource resource, int limit, int offset) throws Exception {

        String urlParaChamada = String.format("%s/%s?limit=%d&offset=%d", REQUEST_URL, resource.getResource(), limit,
                offset);

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

    public static String buscaPorId(PokemonResource resource, int id) throws Exception {

        String urlParaChamada = String.format("%s/%s/%d", REQUEST_URL, resource.getResource(), id);

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

    public static List<Pokemon> getPokemonList(int limit, int offset) throws Exception {

        String response = PokeApiService.buscaPaginada(PokemonResource.POKEMON, limit, offset);
        List<String> pokemons = JsonUtil.getObectList(response, "name");
        List<String> urls = JsonUtil.getObectList(response, "url");

        int length = pokemons.size();
        List<Pokemon> pokemonList = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            pokemonList.add(new Pokemon(pokemons.get(i), urls.get(i)));
        }
        
        return pokemonList;
    }
}
