package com.example.groupe_alternant_2025;

public enum TypeOperation {

    ADD("+"),
    SUBSTRACT("-"),
    DIVIDE("/"),
    MULTIPLY("*");

    private String symbole;

    TypeOperation(String symbole) {
        this.symbole = symbole;
    }

    public String getSymbole() {
        return symbole;
    }
}
