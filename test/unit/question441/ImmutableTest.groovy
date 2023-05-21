package question441


import spock.lang.Specification

class ImmutableTest extends Specification {
    // Создание иммутабельного объекта с помощью аннотации @Immutable
    void test() {
        when:
        Immutable immutable = new Immutable("firsString", "secondString")
        immutable.first = "anotherFirstString"
        then:
        thrown ReadOnlyPropertyException
    }

    // Создание иммутабельного листа
    void anotherTest() {
        when:
        def immutableList = [1, 2, 3].asImmutable()
        immutableList.add(4)
        then:
        thrown UnsupportedOperationException
    }
}
