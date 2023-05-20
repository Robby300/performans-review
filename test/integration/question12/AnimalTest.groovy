package question12

import grails.test.spock.IntegrationSpec
import org.springframework.beans.factory.annotation.Autowired

class AnimalTest extends IntegrationSpec {

    // внедряю из контекста коллекцию всех реализаций абстракции Animal
    @Autowired
    Collection<Animal> animals

    void allAnimalsShouldMove() {

        expect:
        animals.size() == 6
        animals.each {it.move()}
    }

    // внедряю из контекста коллекцию всех реализаций интерфейса flyable
    @Autowired
    Collection<Flyable> flyableAnimals

    void allFlyableShouldFly() {
        expect:
        flyableAnimals.size() == 3
        flyableAnimals.each {it.fly()}
    }

    // внедряю из контекста коллекцию всех реализаций интерфейса underWaterBreathable
    @Autowired
    Collection<UnderWaterBreathable> underWaterBreathableAnimals

    void allUnderWaterBreathableShouldBreathe() {
        expect:
        underWaterBreathableAnimals.size() == 3
        underWaterBreathableAnimals.each {it.breathUnderWater()}
    }

    // внедряю из контекста коллекцию всех реализаций интерфейса underWaterBreathable
    @Autowired
    Collection<Swimable> swimableAnimals

    void allSwimableAnimalseShouldSwim() {
        expect:
        swimableAnimals.size() == 3
        swimableAnimals.each {it.swim()}
    }
}
