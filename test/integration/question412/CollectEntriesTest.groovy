package question412

import grails.test.spock.IntegrationSpec
import org.springframework.beans.factory.annotation.Autowired
import question12.Animal

class CollectEntriesTest extends IntegrationSpec{

// question 412
    @Autowired
    List<Animal> animals

    void entriesTest() {

        when:
        def ageByName = animals.collectEntries({[it.name, it.age]})
        ageByName.each {key, value -> println("ageByName: name = $key and his age = $value")}

        then:
        animals.size() == 6
        ageByName
    }

    void entriesTestWithCollect() {
        when:
        def collectHealthByAnimal = animals.collect({ [it, it.isHealthy] })
        def healthByAnimal = collectHealthByAnimal.collectEntries()
        healthByAnimal.each {println("animal $it.key.name is ${it.value? "healthy" : "sick"}")}

        then:
        collectHealthByAnimal
        healthByAnimal
    }

    void thirdTest() {
        when:
        def letters = "abc"
        // collect letters with index

        then:
        (0..2).collectEntries( [:] ) { index -> [index, letters[index]] } == [0:'a', 1:'b', 2:'c']
        (0..2).collectEntries( [4:'d'] ) { index ->
            [(index+1): letters[index]] } == [1:'a', 2:'b', 3:'c', 4:'d']
    }

    void collectFromTwoLists() {
        when:
        def keys = [1, 2, 3]
        def values = ['one', 'two', 'three']
        def map = [keys, values].transpose().collectEntries()
        println(map)
        then:
        map.size() == 3
        map[2] == 'two'
    }

    void collectFromTwoListsUsingFor() {
        when:
        def keys = [1, 2, 3]
        def values = ['one', 'two', 'three']
        def map = [:]
        for(int i = 0; i < keys.size(); i++) {
            map[keys[i]] = values[i]
        }
        println map
        then:
        map.size() == 3
        map[2] == 'two'
    }
}
