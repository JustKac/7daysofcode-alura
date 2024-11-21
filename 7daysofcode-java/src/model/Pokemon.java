package model;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {

    private Integer id;
    private String name;
    private String image;
    private List<String> types;

    public Pokemon() {
        this.types = new ArrayList<>();
    }

    public Pokemon(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.types = new ArrayList<>();
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

    public List<String> getType() {
        return types;
    }

    public void setType(List<String> types) {
        this.types = types;
    }

    public void addType(String type) {
        this.types.add(type);
    }

    @Override
    public String toString() {
        // retorna uma string no formato json
        return "{\"id\":" + id + ",\"name\":\"" + name + "\",\"image\":\"" + image + "\",\"types\":" + types + "}";
    }
}
