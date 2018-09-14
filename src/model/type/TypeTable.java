package model.type;

public enum TypeTable {

    EXTERIEUR("exterieur"),
    INTERIEUR("interieur");

    private String name;

    TypeTable(String name){

        this.name = name;
    }

    public String toString(){

        return name;
    }
}