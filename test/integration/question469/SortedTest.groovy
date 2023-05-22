package question469

import grails.test.spock.IntegrationSpec
import org.springframework.beans.factory.annotation.Autowired
import question12.Animal

import java.util.stream.Collectors

class SortedTest extends IntegrationSpec {

    @Autowired
    List<Animal> animals

    // сортировка по возрастанию
    void shouldSortByAge() {
        when:
        def sortedByAge = animals.stream()
                .sorted({ animal1, animal2 -> animal1.age - animal2.age })
                .collect(Collectors.toList())
        then:
        sortedByAge[0].age <= sortedByAge[1].age
        sortedByAge[1].age <= sortedByAge[2].age
        sortedByAge[2].age <= sortedByAge[3].age
    }
    // сортировка по возрастанию с помощью Integer.compare
    void shouldSortByAgeUsingInteger() {
        when:
        def sortedByAge = animals.stream()
                .sorted({animal1, animal2 -> Integer.compare(animal1.age, animal2.age)})
                .collect(Collectors.toList())
        then:
        sortedByAge[0].age <= sortedByAge[1].age
        sortedByAge[1].age <= sortedByAge[2].age
        sortedByAge[2].age <= sortedByAge[3].age
    }

    // сортировка по алфавиту лексикографически
    void shouldSortByName() {
        when:
        def sortedByName = animals.stream()
                .sorted({ animal1, animal2 -> (animal1.name <=> animal2.name) })
                .collect(Collectors.toList())
        then:
        sortedByName[0].name.compareTo(sortedByName[1].name) < 0
        sortedByName[1].name.compareTo(sortedByName[2].name) < 0
    }
}
