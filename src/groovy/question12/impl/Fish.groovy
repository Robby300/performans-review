package question12.impl

import question12.Animal
import question12.UnderWaterBreathable

class Fish extends Animal implements UnderWaterBreathable{

    @Override
    void move() {
        swim()
    }

    private void swim() {
        println("$name is swimming")
    }

    @Override
    void breathUnderWater() {
        println("$name  can breath under the water")
    }
}
