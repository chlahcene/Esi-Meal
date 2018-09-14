package model.type;

public enum TypeRepas {

    ENTREE("entrée"),
    PLAT("plat"),
    DESSERT("dessert");

    private String name;

    TypeRepas(String name){

        this.name = name;
    }

    public String toString(){

        return name;
    }
}