import question12.impl.Bat
import question12.impl.Bird
import question12.impl.Fish
import question12.impl.Octopus
import question12.impl.SwimableBird

// Place your Spring DSL code here
beans = {
    batMan(Bat) {
        name = "Batman"
        weight = 0.5
        age = 2
        isHealthy = true
    }

    nemo(Fish) {
        name = "Nemo"
        weight = 0.1
        age = 1
        isHealthy = true
    }

    shark(Fish) {
        name = "Shark"
        weight = 100.5
        age = 4
        isHealthy = false
    }

    angryBird(Bird) {
        name = "AngryBird"
        weight = 1.5
        age = 2
        isHealthy = true
    }

    donaldDuck(SwimableBird) {
        name = "DonaldDuck"
        weight = 3.5
        age = 4
        isHealthy = false
    }

    octopus(Octopus) {
        name = "Some Octopus"
        weight = 10.5
        age = 5
        isHealthy = true
    }
}
