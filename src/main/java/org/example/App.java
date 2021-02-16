package org.example;

import org.example.functional.MyFunctionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void doSomethingTraditional(){

        /* Todo bien pero esto es oPP
                var instanciaTux = new Tux();

                System.out.println(instanciaTux.doSomething("Que divertida es la progra funcional"));
        */
        var instanciaTux = new Tux();

        System.out.println(instanciaTux.doSomething("POO"));

    }

    public static void doSomethingClassy(){
        //clase anónima, implementación directa o en línea de una interfaz
        //es anónima porque no se implementa una clase con nombre sino solo la funcionalidad
        // y se asigna a un identificador

        var duke = new MyFunctionalInterface() {
            @Override
            public String doSomething(String param) {
                return "Hola soy duke y recibí " + param;
            }
        };

        System.out.println(duke.doSomething("Clase anónima"));
    }

    public static void doSomethingFunctional(){
        //lambda o función anónima, implementar el cuerpo completo
        MyFunctionalInterface clippy = (String param) -> {
            return "Hola soy Clippy y recibí " + param;
        };

        //
        MyFunctionalInterface wilbert = (p) -> "hola soy wilbert y recibi " + p;

        doSomethingHighOrder(clippy);
        doSomethingHighOrder(wilbert);
        doSomethingHighOrder(x -> "Hola soy anonymus y recibi " + x);

        var tux = new Tux();
        doSomethingHighOrder(tux::doSomething);

        //se respetan las firmas del método
        var pickachu = new Pickachu();
        doSomethingHighOrder(pickachu::pika);
        doSomethingHighOrder(pickachu::impactrueno);
    }

    //defino el comportamiento que la función va a tener
    //y ya adentro puedo usar la función como una normal
    //aunque internamente no sé qué hace
    public static void doSomethingHighOrder(MyFunctionalInterface comportamiento){
        //ejecuto el comportamiento que recibí como argumento de la función HO

        var respuesta = comportamiento.doSomething("Java 11 es genial");
        System.out.println(respuesta);
    }

    public static void main( String[] args ){
        //doSomethingFunctional();

        //var jedis =   List.of("Yoda", "Windu", "Anakin", "Luke", "Rey");

        //jedis.forEach(param -> System.out.println(param));
        //jedis.forEach(System.out::println);

        //¿es una Jedi? -> no en el caso que sea Rey
        //Predicate<String> isNotAJedi = s -> !s.equals("Rey");

        //en esta declaración la lista es inmutable, se soluciona con STREAMS API
        //List jedis =   Arrays.asList("Yoda", "Windu", "Anakin", "Luke", "Rey");
/*
        var jedis = new ArrayList<String>();
        jedis.add("Anakin");
        jedis.add("Rey");
        jedis.add("Leia");*/

        //removeIf solo trabaja con listas mutables
        //se puede trabajar sin generar una nueva
        //instancia.

        //List jedis = List.of("Anakin", "leia", "Luke", "Rey");

        //procesamiento sin STREAMS API
        //jedis.removeIf(s -> s.equals("Rey"));
/*
        var filteredJedis = jedis.stream()
                .filter(s -> !s.equals("Rey"))//map
                .map(j -> j.toString().toUpperCase())//map
                //.reduce();//map
                .collect(Collectors.toList());//reduce

        var theJedi = jedis.stream()
                .peek(System.out::println)//auditorías
                .filter(s -> !s.equals("Rey"))//map
                .peek(System.out::println)
                .map(j -> j.toString().toUpperCase())//map
                .peek(System.out::println)
                //.reduce();//map
                .findFirst();//reduce

        System.out.println("Resultado --- " + theJedi);

*/


    }
}
