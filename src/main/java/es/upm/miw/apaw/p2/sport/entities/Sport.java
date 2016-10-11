package es.upm.miw.apaw.p2.sport.entities;

public class Sport {
    private int id;

    private String name;

    public Sport() {
        // TODO Auto-generated constructor stub
    }

    public Sport(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
