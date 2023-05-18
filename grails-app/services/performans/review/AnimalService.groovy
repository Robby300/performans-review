package performans.review

import grails.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import question12.Animal

@Transactional
class AnimalService {

    @Autowired
    List<Animal> animals

    def findAll() {
        animals
    }
}
