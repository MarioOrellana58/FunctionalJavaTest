package org.example;

import org.example.functional.MyFunctionalInterface;

public class Tux implements MyFunctionalInterface {

    @Override
    public String doSomething(String param) {
        return "Gola soy Tux y recibí el siguiente parámetro: " + param;


    }

}
