package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsDemo {

    //DATOS
    public static List<Integer> createRandomList(int qty){
        var random = new Random();
        List<Integer> numbers = new LinkedList<>();

        for (int i = 0; i < qty; i++){
            numbers.add(random.nextInt(100));
        }
        return numbers;
    }

    //programación imperativa
    public static List<Integer> sortList(List<Integer> unsortedList){
        Collections.sort(unsortedList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        return unsortedList;
    }

    public static boolean isPrimeNumber(int n){
        if (n<=1)
            return false;

        var qtyDivisible = 0;

        for (int i = n - 1; i > 1 ; i--){
            if (n % i == 0){
                qtyDivisible++;
            }
        }

        return qtyDivisible <= 0;
    }

    //programación declarativa
    public static List<Integer> sortLambdaList(List<Integer> unsortedList){
        Collections.sort(unsortedList, (o1, o2) -> o1.compareTo(o2));
        return unsortedList;
    }

    public static String getFibonacciFunction(int limit){
        if (limit <= 0)
            return("El número " + limit + " no es un número válido");

        var result = "";
        var prevNum = 0;
        var nextNum = 1;
        for (int i = 0; i <= limit; i++ )
        {
            result += i < limit ? prevNum + "," : prevNum;
            var sum = prevNum + nextNum;
            prevNum = nextNum;
            nextNum = sum;
        }

        return result;
    }

    public static void main(String args[]){


        System.out.println("Iniciando cálculo");

        var primeNumbers = createRandomList(Integer.valueOf(args[0])).parallelStream()//solo stream() no aprovecha los CPU's
                .filter(n -> isPrimeNumber(n))
                .sorted()
                .collect(Collectors.toList());

        var fibPrimeNums = primeNumbers.parallelStream()
                .map(j -> j + " = " + getFibonacciFunction(j) + "\n")
                .collect(Collectors.toList());

        System.out.println("Números primos");
        System.out.println(primeNumbers);

        System.out.println("Fibonacci");
        System.out.println(fibPrimeNums);

        System.out.println("Cálculo finalizado");


        /*
        var primos = IntStream.range(0,100).boxed()//en vez de dar el int primitivo da el int objeto
                .filter(n -> isPrimeNumber(n))
                .collect(Collectors.toList());

        System.out.println(primos);

        //clase anónima
        var randomNumber = createRandomList(10);
        System.out.println(randomNumber);
        sortLambdaList(randomNumber);
        System.out.println(randomNumber);*/
    }
}
