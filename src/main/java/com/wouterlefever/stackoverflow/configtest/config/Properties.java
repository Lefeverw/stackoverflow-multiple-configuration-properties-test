package com.wouterlefever.stackoverflow.configtest.config;

public class Properties {

    private String one;
    private String two;

    public void setOne(String one) {
        this.one = one;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    @Override
    public String toString() {
        return "Properties{" +
                "one='" + one + '\'' +
                ", two='" + two + '\'' +
                '}';
    }
}
