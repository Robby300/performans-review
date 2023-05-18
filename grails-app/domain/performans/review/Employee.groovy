package performans.review

class Employee {
    String firstName
    String lastName
    BigDecimal salary
    String position

    static constraints = {
        firstName blank: false
        lastName blank: false
//        salary min: 0
        position nullable: true
    }
}
