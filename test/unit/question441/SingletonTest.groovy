package question441


import spock.lang.Specification

class SingletonTest extends Specification {

    void test() {
        when:
        Singleton singleton = new Singleton()
        def instance = Singleton.instance

        then:
        singleton != instance
        instance.hello == "Hello world!"
    }
}
