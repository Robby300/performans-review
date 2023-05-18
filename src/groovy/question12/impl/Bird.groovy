package question12.impl

import question12.Animal
import question12.Flyable

class Bird extends Animal implements Flyable{

    @Override
    void move() {
        fly()
    }

    @Override
    void fly() {
        println("$name can fly")
    }
}
