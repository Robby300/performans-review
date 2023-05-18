package question15

import question12.Animal

class AggregatedZoo {

    private Animal shark
    private Animal angryBird
    private Animal batMan
    private Animal someOctopus

    AggregatedZoo(Animal shark, Animal angryBird, Animal batMan, Animal someOctopus) {
        this.shark = shark
        this.angryBird = angryBird
        this.batMan = batMan
        this.someOctopus = someOctopus
    }

    void showAnimals() {
        List<Animal> animals = [shark, angryBird, batMan, someOctopus]
        // show animals
    }
}
