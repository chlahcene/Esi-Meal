package model.type;

public enum TypeBoisson {
    EAU_MINERALE("eau minerale"),
    GAZEUSE("boisson gazeuse"),
    JUS("jus"),
    CAFE("caf"),
    THE("the");

    private String name;

    TypeBoisson(String name){

        this.name = name;
    }

    public String toString(){

        return name;
    }

}