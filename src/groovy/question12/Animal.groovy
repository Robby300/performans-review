package question12

abstract class Animal {

    String name
    Double weight
    Integer age
    Boolean isHealthy

    Animal(String name, Double weight, Integer age, Boolean isHealthy) {
        this.name = name
        this.weight = weight
        this.age = age
        this.isHealthy = isHealthy
    }

    Animal() {
    }

    abstract void move()
}
