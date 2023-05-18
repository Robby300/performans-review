package question15

import question12.Animal
import question12.impl.Bat
import question12.impl.Bird
import question12.impl.Fish
import question12.impl.Octopus

class CompositeZoo {

    private Animal shark = new Fish("Shark")
    private Animal angryBird = new Bird("Angry Bird")
    private Animal batMan = new Bat("BatMan");
    private Animal someOctopus = new Octopus("Octopus")

    void showAnimals() {
        List<Animal> animals = [shark, angryBird, batMan, someOctopus]
        // show animals
    }
}
