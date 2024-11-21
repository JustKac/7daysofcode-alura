import java.util.List;

import model.Pokemon;
import service.PokeApiService;

public class App {
    public static void main(String[] args) throws Exception {

        List<Pokemon> pokemonList = PokeApiService.getPokemonList(150, 0);
        pokemonList.forEach(System.out::println);

    }

}
