package question465

import grails.test.spock.IntegrationSpec
import org.springframework.beans.factory.annotation.Autowired
import question12.Animal

import java.util.function.ToDoubleFunction
import java.util.stream.Collectors

class StreamTest extends IntegrationSpec {

    @Autowired
    Collection<Animal> animals

    void conversionToList() {
        def collect = animals
                .stream()
                .map({ animal -> animal.getName() })
                .collect(Collectors.toList());
        expect:
        collect.size() == 6
        collect.contains("Batman")
        collect.contains("Nemo")
        collect.contains("Shark")
        collect.contains("AngryBird")
        collect.contains("DonaldDuck")
        collect.contains("Some Octopus")
    }

    void conversionToSet() {
        def collect = animals
                .stream()
                .collect(Collectors.toSet())
        expect:
        collect.size() == 6
    }

    void conversionToMap() {
        def collect = animals
                .stream()
                .collect(Collectors.groupingBy({ it.getAge() }))
        expect:
        collect.size() == 4
    }


    void sorted() {
        def collect = animals
                .stream()
                .sorted({  animal1, animal2 -> animal1.age - animal2.age  })
                .collect(Collectors.toList())
        println("sorted by Age")
        collect.forEach({println("$it.name --- $it.age")})
        expect:
        collect.size() == 6
    }

    void reduceTest() {
        when:
        def sumWeight = animals.stream()
                .map({ it.getWeight() })
                .reduce(0, Double.&sum)
        then:
        sumWeight == 116.6
    }
}
