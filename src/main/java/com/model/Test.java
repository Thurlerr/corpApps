package com.model;

public class Test {
    public static void main(String[] args) {
        Cliente aroldo = new Cliente("Aroldo", "0123", 1500.00);
        Cliente gordola = new Cliente("Gordola", "0123444", 2500.00);


        System.out.println(gordola.getId());
    }
}
