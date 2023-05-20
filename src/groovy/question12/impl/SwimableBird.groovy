package question12.impl

import question12.Swimable

class SwimableBird extends Bird implements Swimable{
    @Override
    void swim() {
        println("I can swim")
    }
}
