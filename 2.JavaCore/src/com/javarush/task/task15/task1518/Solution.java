package com.javarush.task.task15.task1518;

/* 
Статики 3
*/

public class Solution {
    public static Cat cat;

    public static void main(String[] args) {

    }

    static {
        cat=new Cat();
        System.out.println(cat.name);
    }

    public static class Cat{
        public String name  = "Барсик";
    }
}
