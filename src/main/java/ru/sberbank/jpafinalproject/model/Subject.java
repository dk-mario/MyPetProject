package ru.sberbank.jpafinalproject.model;

public class Subject {
    private String sub;

    public Subject() {
    }

    public Subject(String sub) {
        this.sub = sub;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }


    @Override
    public String toString() {
        return "Subject{" +
                "sub='" + sub + '\'' +
                '}';
    }
}
