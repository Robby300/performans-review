package question418

import spock.lang.Specification

class ValueRangesTest extends Specification {

    void rangesTest() {
        def list = [123, "some text", new Date()]
        def letters = "а".."я"
        def number = 1 .. 10
        expect:
        list.size() == 3
        list[0] == 123
        letters[2] == 'в'
        letters.size() == 32
        number.size() == 10
    }
}
