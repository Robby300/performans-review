package question417

import spock.lang.Specification

class MultipleAssigmentTest extends Specification {

    void assigmentTest() {
        def (a, b, c) = [1, 2, 5]
        def (int someInt, String someString) = [112, "Hello world!"]
        expect:
        b == 2
        someString == "Hello world!"
    }
}
