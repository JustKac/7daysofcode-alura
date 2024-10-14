package enumerator;

public enum PokemonResource {

    BERRIES("berries"),
    CONTESTS("contests"),
    ENCOUNTERS("encounters"),
    EVOLUTION("evolution"),
    GAMES("games"),
    ITEMS("items"),
    LOCATIONS("locations"),
    MACHINES("machines"),
    MOVES("moves"),
    POKEMON("pokemon");

    private String resource;

    private PokemonResource(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
