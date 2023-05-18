package question12

import grails.test.spock.IntegrationSpec
import org.springframework.beans.factory.annotation.Autowired

class AnimalTest extends IntegrationSpec {

    @Autowired
    Collection<Animal> animals

    void allAnimalsShouldMove() {

        expect:
        animals.size() == 6
        animals.each {it.move()}
    }

    @Autowired
    Collection<Flyable> flyableAnimals

    void allFlyableShouldFly() {
        expect:
        flyableAnimals.size() == 3
        flyableAnimals.each {it.fly()}
    }

    @Autowired
    Collection<UnderWaterBreathable> underWaterBreathableAnimals

    void allUnderWaterBreathableShouldBreathe() {
        expect:
        underWaterBreathableAnimals.size() == 3
        underWaterBreathableAnimals.each {it.breathUnderWater()}
    }
}
