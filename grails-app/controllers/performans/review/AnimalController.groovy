package performans.review

class AnimalController {

    def animalService

    def list() {
        def all = animalService.findAll()
        render(view: "animals", model: [animals: all])
    }
}
