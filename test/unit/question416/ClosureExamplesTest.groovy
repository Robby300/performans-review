package question416


import spock.lang.Specification

class ClosureExamplesTest extends Specification {

    // кложура имеет доступ к переменным из внешенго контекста
    void firstClosureExample() {
        given:
        def a = 1
        def c = { a }
        expect:
        c() == 1
    }

    // простейшший пример
    void secondClosureExample() {
        given:
        def c = { a, b, c -> a + b * c }
        expect:
        c(1, 2, 3) == 7
    }

    // простейшший пример
    void multiplyClosure() {
        given:
        def multiply = {a, b -> a * b}
        expect:
        multiply(5, 7) == 35
    }

    // кложура в each
    void closureInEach() {
        given:
        def numbers = [1,2,3,4,5]
        numbers.each({ n -> println(n * 10) })
    }

    // кложура имеет доступ к переменным из внешенго контекста
    void usingOuterVariable() {
        given:
        def outerVariable = 10
        def addOuterVariable = { n -> n + outerVariable }
        expect:
        addOuterVariable(5) == 15
    }
}
