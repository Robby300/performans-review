package question441

import spock.lang.Specification

class UtilEvalTest extends Specification {

    void test() {

        expect:
        def value = new Random().nextInt(100)
        Eval.me('x', value,'x * x') == value * value
    }

    void testUnary() {

        expect:
        Eval.x(2, 'x * x') == 4
    }

    void testBinary() {

        expect:
        Eval.xy(2, 3, 'x * y') == 6
    }

    void testTriple() {
        expect:
        Eval.xyz(2, 3, 5, 'x * y - z') == 1
    }
}
