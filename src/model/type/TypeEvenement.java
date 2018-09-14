package model.type;

public enum TypeEvenement {

    ANNIVERSAIRE("anniversaire"),
    MARIAGE("diner de marige"),
    DIPLOME("obtention de diplome"),
    AUTRE("autre chose"),
    RETRAITE("diner de depart a la retraite");

    private String name;

    TypeEvenement(String name){

        this.name = name;
    }

    public String toString(){

        return name;
    }

}