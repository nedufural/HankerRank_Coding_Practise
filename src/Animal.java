package com.nekashop.app.test;

public class Animal {
    void PrintName(){
        System.out.println("Animal");
    }
}

 class Dog extends Animal {
    @Override
    void PrintName(){
        System.out.println("Dog");
    }
}
 class Cat extends Animal {
    @Override
    void PrintName(){
        System.out.println("Cat");
    }
}

class Peop extends Cat {
    @Override
    void PrintName(){
        System.out.println("Peop");
    }

    public static void main(String[] args) {
        Peop peop = new Peop();
        peop.PrintName();
    }
}