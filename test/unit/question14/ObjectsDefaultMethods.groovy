package question14

import question12.Animal
import question12.impl.Fish
import spock.lang.Specification

class ObjectsDefaultMethods extends Specification {

    private Animal someFish = new Fish(name : "Shark",
            weight : 100.5,
            age : 4,
            isHealthy : false)

    void objectsDefaultMethods() {
        def methods = someFish.metaClass.methods
        methods.each {println(it.name)}
        expect: methods.size() == 25
    }
}
