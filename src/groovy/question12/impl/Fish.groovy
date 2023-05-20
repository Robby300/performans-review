package question12.impl

import question12.Animal
import question12.Swimable
import question12.UnderWaterBreathable

class Fish extends Animal implements UnderWaterBreathable, Swimable{

    @Override
    void move() {
        swim()
    }

    void swim() {
        println("$name is swimming")
    }

    @Override
    void breathUnderWater() {
        println("$name  can breath under the water")
    }
}
