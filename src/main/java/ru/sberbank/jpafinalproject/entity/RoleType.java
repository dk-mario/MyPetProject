package ru.sberbank.jpafinalproject.entity;

public enum RoleType {
    SPECIALIST("SPECIALIST"), CUSTOMER("CUSTOMER");

    private String name;

    RoleType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
