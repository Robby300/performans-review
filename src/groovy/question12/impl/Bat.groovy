package question12.impl

import question12.Animal
import question12.Flyable

class Bat extends Animal implements Flyable{

    @Override
    void move() {
        fly()
    }

    @Override
    void fly() {
        println("$metaClass $name can fly")
    }
}
