package com.zanox.internal.training;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;


/**
 * Training resources for lambdas, streams and method references
 */
public class LambdasAndStreams {


    /**
     * Main method to execute this example
     * @param args runtime args for the execution (leave empty, necessary standard of the main signature)
     */
    public static void main(String[] args) {

        var myList=
        IntStream.range(1, 10)
                .filter(x -> x % 2 == 0) // Predicate implementation 
                .mapToDouble(x -> x * 2) // Function implementation
                .boxed()
                .collect(Collectors.toList()); // Default Supplier usage

        myList.forEach(System.out::println);// Consumer implementation and method reference
        //(x -> System.out.print(String.format("Value : %s\r\n", x)));

        // Custom implementation of custom interface
        DummyInterface handler = (x)->{
            var result=x
                    .chars()
                    .mapToObj(c -> Character.valueOf((char)c))
                    .map(String::valueOf)
                    //.collect(joining(""));
                    .reduce("Test: ", (s, c) -> s + c + c);
            return result;
        };
        dummyFunction("Fubar", handler);

        
        
    }

    /**
     * Dummy function for functional {@link DummyInterface} interface as parameter
     * @param with String value to transform
     * @param handler Transformation function
     */
    public static void dummyFunction(String with, DummyInterface handler) {
        System.out.print(
                handler.handleTheDummy(with)
        );
    }

    /**
     * Custom functional interface
     */
    @FunctionalInterface
    public interface DummyInterface {
        public String handleTheDummy(String input);
    }
    
}
