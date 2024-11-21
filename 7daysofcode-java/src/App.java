import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import model.Pokemon;
import service.HTMLGenerator;
import service.PokeApiService;

public class App {
    public static void main(String[] args) throws Exception {

        List<Pokemon> pokemonList = PokeApiService.getPokemonList(150, 0);
        
        try (PrintWriter writer = new PrintWriter(new FileWriter("pokemons.html"))) {
            HTMLGenerator htmlGenerator = new HTMLGenerator(writer);
            htmlGenerator.generate(pokemonList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
