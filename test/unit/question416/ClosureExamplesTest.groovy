package question416


import spock.lang.Specification

class ClosureExamplesTest extends Specification {

    void firstClosureExample() {
        when:
        def a = 1
        def c = { a }
        then:
        c() == 1
    }

    void secondClosureExample() {
        when:
        def c = { a, b, c -> a + b * c }
        then:
        c(1, 2, 3) == 7
    }
}
