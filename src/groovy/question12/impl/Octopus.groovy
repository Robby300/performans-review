package question12.impl

import question12.Animal
import question12.UnderWaterBreathable

class Octopus extends Animal implements UnderWaterBreathable{

    @Override
    void move() {
        println("$name is swimming")
    }

    @Override
    void breathUnderWater() {
        println("$name can breath under the water")
    }
}
