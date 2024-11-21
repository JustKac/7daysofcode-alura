package service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import model.Pokemon;

public class HTMLGenerator {
    private Writer writer;

    public HTMLGenerator(Writer writer) {
        this.writer = writer;
    }

    public void generate(List<Pokemon> pokemons) throws IOException {
        writer.write("""
            <html>
            <head>
                <meta charset="utf-8">
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
                <title>Pokémon</title>
            </head>
            <body>
                <div class="container">
                    <div class="row">
            """);

        for (Pokemon pokemon : pokemons) {
            String types = String.join(", ", pokemon.getType());
            writer.write(String.format("""
                <div class="col-md-4">
                    <div class="card" style="width: 18rem;">
                        <img src="%s" class="card-img-top" alt="%s">
                        <div class="card-body">
                            <h5 class="card-title">%s</h5>
                            <p class="card-text">Tipo: %s</p>
                        </div>
                    </div>
                </div>
                """, pokemon.getImage(), pokemon.getName(), pokemon.getName(), types));
        }

        writer.write("""
                    </div>
                </div>
            </body>
            </html>
            """);

        writer.close();
    }
}
