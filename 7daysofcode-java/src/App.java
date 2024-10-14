import enumerator.PokemonResource;
import service.PokeApiService;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(PokeApiService.buscaPaginada(PokemonResource.POKEMON, 150, 0));
    }
}
