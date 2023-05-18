package question441


import spock.lang.Specification

class ImmutableTest extends Specification {
    void test() {
        when:
        Immutable immutable = new Immutable("firsString", "secondString")
        immutable.first = "anotherFirstString"
        then:
        thrown ReadOnlyPropertyException
    }
}
