import enumerator.PokemonResource;
import service.PokeApiService;

public class App {
    public static void main(String[] args) throws Exception {

        String response = PokeApiService.buscaPaginada(PokemonResource.POKEMON, 150, 0);
        String[] pokemons = getObectList(response, "name");
        String[] urls = getObectList(response, "url");
        for (int i = 0; i < pokemons.length; i++) {
            System.out.println(pokemons[i] + " - " + urls[i]);
        }
    }

    static String[] getObectList(String json, String key) {
        String[] list = json.split("\"" + key + "\":\"");
        String[] processedList = new String[list.length];
        for (int i = 1; i < list.length; i++) {
            String nome = list[i].split("\"")[0];
            processedList[i] = nome;
        }
        return processedList;
    }

}
