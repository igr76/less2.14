package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Service list =new Service();
        list.add("one");
        list.add("two");
        list.add("three");

        list.set(1,"for");
        list.get(0);
    }
}