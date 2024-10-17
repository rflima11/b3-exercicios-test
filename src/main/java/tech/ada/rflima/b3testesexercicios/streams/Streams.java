package tech.ada.rflima.b3testesexercicios.streams;

import java.util.Arrays;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {
        //Pré Java 5
        List<Integer> listaInteiros = Arrays.asList(6,1,9,9,9,3,4,4,5);
   /*     for (Iterator<Integer> numero = listaInteiros.iterator(); numero.hasNext(); ) {
            Integer integer = numero.next();
            System.out.println(integer);
        }

        //Pós Java 5
        for (Integer numero: listaInteiros) {
            System.out.println(numero);
        }

        //Java 8
        listaInteiros.stream().forEach(item -> System.out.println(item));

        boolean possuiPar = listaInteiros.stream().anyMatch(item -> item % 2 == 0);
        System.out.println(possuiPar);*/

        listaInteiros.stream()
                .distinct()
                .findFirst();


        List<Integer> collect = listaInteiros.stream()
                .filter(item -> item % 2 == 0)
                .map(item -> item + 1)
                .collect(Collectors.toList());



        collect.forEach(item -> System.out.println(item));
        collect.forEach(System.out::println);

    }

}
