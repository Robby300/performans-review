package question418

import spock.lang.Specification

class ValueRangesTest extends Specification {

    void rangesTest() {
        // диапазон строк
        def letters = "а".."я"
        // диапазон интов
        def integers = 1 .. 10
        // диапазон дат
        def dateRange = Date.parse("yyyy-MM-dd", "2023-05-01") .. Date.parse("yyyy-MM-dd", "2023-05-22")
        expect:
        letters[2] == 'в'
        letters.size() == 32
        integers.size() == 10
        dateRange.size() == 22
    }
}
