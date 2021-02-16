package org.example.functional;

@FunctionalInterface //para revisar que cumpla con todos los requisitos de interfaz funcional
//no pueden tener más de un método porque son la base lara las lambda
public interface MyFunctionalInterface {

    public String doSomething(String param);//por defecto son públicos

}
