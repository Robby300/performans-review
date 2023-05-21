package question468

import grails.test.spock.IntegrationSpec
import org.springframework.beans.factory.annotation.Autowired
import question12.Animal

class FindInStreamTest extends IntegrationSpec {

    @Autowired
    Collection<Animal> animals

    // находим первый найденный по предикату
    void shouldFindFisrtTest() {
        when:
        def firstFound = animals
                .stream()
                .filter({ animal -> animal.getAge() > 2 })
                .findFirst()
                .orElseThrow({ -> new RuntimeException("не найден") })
        then:
        firstFound
    }
    // не находим первый найденный по предикату, кидаем исключение
    void shouldNotFindFisrtTest() {
        when:
        def firstFound = animals
                .stream()
                .filter({ animal -> animal.getAge() > 20 })
                .findFirst()
                .orElseThrow({ -> new RuntimeException("не найден") })
        then:
        thrown RuntimeException
    }

    // находим первый попавшийся по предикату
    void shouldFindAnyTest() {
        when:
        def firstFound = animals
                .stream()
                .filter({ animal -> animal.getAge() > 2 })
                .findAny()
                .orElseThrow({ -> new RuntimeException("не найден") })
        then:
        firstFound
    }

    // не находим по предикату ничего
    void shouldNotFindFisrtTest() {
        when:
        def firstFound = animals
                .stream()
                .filter({ animal -> animal.getAge() > 20 })
                .findAny()
                .orElseThrow({ -> new RuntimeException("не найден") })
        then:
        thrown RuntimeException
    }
}
