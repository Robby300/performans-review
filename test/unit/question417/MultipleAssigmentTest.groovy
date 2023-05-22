package question417

import question12.impl.Bird
import spock.lang.Specification

class MultipleAssigmentTest extends Specification {
    // множественное присваивание или "множественная декомпозияиця"
    void assigmentTest() {
        def (a, b, c) = [1, 2, 5]
        def (int someInt, String someString) = [112, "Hello world!"]
        expect:
        b == 2
        someString == "Hello world!"
    }

    // множественное присваивание - мапа из проперти для создания объекта
    void assigmentMapTest() {
        Bird someBird = new Bird(name: "bird", weight: 1.5, age: 2, isHealthy: true)
        expect:
        someBird.isHealthy
    }
}
