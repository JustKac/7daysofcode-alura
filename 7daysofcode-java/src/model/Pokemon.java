package model;

public class Pokemon {

    private Integer id;
    private String name;
    private String image;

    public Pokemon() {
    }

    public Pokemon(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        // retorna uma string no formato json
        return "{\"id\":" + id + ",\"name\":\"" + name + "\",\"image\":\"" + image + "\"}";
    }
}
