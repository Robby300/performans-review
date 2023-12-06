package question441

import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import spock.lang.Specification

class JsonTest extends Specification  {

    void testJsonSlurper() {
        when:
        def jsonString = '{"name": "John", "age": 30}'
        def jsonSlurper = new JsonSlurper()
        def data = jsonSlurper.parseText(jsonString)

        then:
        data.name == 'John'
        data.age  == 30
    }

    void testJsonBuilder() {
        when:
        def jsonBuilder = new JsonBuilder()
        def data = jsonBuilder {
            name 'John'
            age 30
        }

        then:
        data.name == 'John'
        data.age  == 30
    }

    void testIteration() {
        when:
        def jsonString = '[{"name": "John", "age": 30}, {"name": "Jane", "age": 25}]'
        def jsonSlurper = new JsonSlurper()
        def data = jsonSlurper.parseText(jsonString)

        data.each { person ->
            person.age += 1
        }

        then:
        data[0].age  == 31
        data[1].age == 26
    }

    void testManipulate() {
        when:
        def jsonString = '{"name": "John", "age": 30}'
        def jsonSlurper = new JsonSlurper()
        def data = jsonSlurper.parseText(jsonString)

        data.city = 'Krasnoyarsk'
        data.age = 36
        data.remove('name')

        then:
        data.age  == 36
        data.city == 'Krasnoyarsk'
        data.name == null
    }

    void testToJson() {
        when:
        def jsonString = '{"name": "John", "age": 30}'
        def jsonSlurper = new JsonSlurper()
        def data = jsonSlurper.parseText(jsonString)

        then:
        JsonOutput.toJson(data) == "{\"name\":\"John\",\"age\":30}"
    }
}
