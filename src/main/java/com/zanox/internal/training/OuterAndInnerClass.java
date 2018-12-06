package com.zanox.internal.training;

import java.lang.reflect.Method;

/**
 *  Training resource for usage of static and non static nested classes
 */
public class OuterAndInnerClass {

    /**
     * Main method to execute this example
     * @param args obsolete
     * @throws Exception May contain NoSuchMethodException or SecurityException from {@link ReflectiveAccess#accessHoldingClass()}
     */
    public static void main(String args[]) throws Exception {

        OuterAndInnerClass.ReflectiveAccess.accessHoldingClass();

        NestedClassA nestedClassA = new OuterAndInnerClass().new NestedClassA();
        nestedClassA.accessOuterMethod();
    }

    private int y =422;
    private static int x =42;
    private static void restrictedMethod() {
        System.out.println("Accessed private static method!");
    }
    private void otherRestricedMethod(){
        System.out.println("Accessed other private method!");
    }
    /**
     * Nested class to show creation from static out method
     * and as well to access a private static field of the outer class.
     */
    class NestedClassA{

        public NestedClassA(){
            System.out.println(String.format("Accessed private value y:{%s} ",y));

        }
        public void accessOuterMethod() {
           otherRestricedMethod();
        }
    }

    /**
     * Nested static class to simulate reflection access of private static method of the holding class
     */
    public static class ReflectiveAccess{

        /**
         * Method to execute private static method of the holding class
         * @throws Exception
         */
        public static void accessHoldingClass() throws Exception {
            System.out.println(String.format("Accessed private static value x:{%s} ",OuterAndInnerClass.x));
            Method restrictedMethod = OuterAndInnerClass.class.getDeclaredMethod("restrictedMethod");
            restrictedMethod();
        }

    }




}
