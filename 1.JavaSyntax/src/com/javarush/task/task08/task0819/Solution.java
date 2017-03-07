package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        cats.remove(cats.iterator().next());

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        Set<Cat> setCat = new HashSet<>();
        setCat.add(new Cat());
        setCat.add(new Cat());
        setCat.add(new Cat());
        return setCat;
    }

    public static void printCats(Set<Cat> cats) {
        for (Cat cat:cats) {
            System.out.println(cat);
        }
    }

    public static class Cat{

    }
}
