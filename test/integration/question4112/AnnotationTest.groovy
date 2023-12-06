package question4112

import grails.test.spock.IntegrationSpec

class AnnotationTest extends IntegrationSpec {
    @Calculate(a = "5", b = "3", action = "*")
    String fifteen

    @Calculate(a = "5", b = "3", action = "/")
    String divide

    @Calculate(a = "5", b = "3", action = "**")
    String grade

    void shouldCalculateFifteenAnnotation() {
        expect:
        fifteen == "15"
    }

    void shouldCalculateDivideAnnotation() {
        expect:
        Double.valueOf(divide) - 1.666 < 0.001
    }

    void shouldCalculateGradeAnnotation() {
        expect:
        grade == "125"
    }
}
