package question4112

import grails.test.spock.IntegrationSpec

class AnnotationTest extends IntegrationSpec {
    @Calculate(a = "5", b = "3", action = "*")
    String fifteen

    @Calculate(a = "5", b = "3", action = "/")
    String divide

    @Calculate(a = "5", b = "3", action = "**")
    String power

    void shouldCalculateFifteen() {
        expect:
        fifteen == "15"
    }

    void shouldCalculateDivide() {
        expect:
        Double.valueOf(divide) - 1.666 < 0.001
    }

    void shouldCalculatePower() {
        expect:
        power == "125"
    }
}
