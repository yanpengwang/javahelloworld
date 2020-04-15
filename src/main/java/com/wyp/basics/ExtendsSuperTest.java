package com.wyp.basics;

import java.util.ArrayList;
import java.util.List;
class Animal{

}
class Cat extends Animal{

}
class Garfield extends Cat{

}
public class ExtendsSuperTest {

    public static void main(String[] args) {
        List<Animal> animal = new ArrayList<>();
        List<Cat> cat = new ArrayList<>();
        List<Garfield> garfield = new ArrayList<>();

        animal.add(new Animal());
        cat.add(new Cat());
        garfield.add(new Garfield());

        List<? super Cat> superCatFromAnimal = animal;
        List<? extends Cat> extendsCatFromCat = cat;
        List<? super Cat> superCatFromCat = cat;
        List<? extends Cat> extendsCatFromGarfield = garfield;

        superCatFromCat.add(new Cat());
        superCatFromCat.add(new Garfield());

        Object catExtends1 = extendsCatFromCat.get(0);

        System.out.println("args = [" + catExtends1 + "]");
    }
}
