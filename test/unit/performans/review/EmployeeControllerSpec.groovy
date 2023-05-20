package performans.review

import grails.test.mixin.TestFor
import grails.test.spock.IntegrationSpec
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification
import spock.lang.Unroll

//@TestFor(EmployeeController)
class EmployeeControllerSpec extends IntegrationSpec {

//    def setup() {
//        // инициализация данных перед каждым тестом
//        controller.employeeService = Mock(EmployeeService)
//    }
    @Autowired
    EmployeeController employeeController

    @Unroll
    void "test create employee #employee"() {
        given:
        def employee = new Employee(
                firstName: 'John',
                lastName: 'Doe',
                salary: 1000.00,
                position: 'Developer'
        )

        when:
        employeeController.request.method = 'POST'
        employeeController.request.contentType = 'application/json'
        employeeController.request.json = [
                firstName: employee.firstName,
                lastName: employee.lastName,
                salary: employee.salary,
                position: employee.position
        ]
        employeeController.save(employee)

        then:
        response.status == 201
//        response.json['firstName'] == employee.firstName
//        response.json['lastName'] == employee.lastName
//        response.json['salary'] == employee.salary
//        response.json['position'] == employee.position

        where:
        employee << [
                [firstName: 'John', lastName: 'Doe', salary: 1000.00, position: 'Developer'],
                [firstName: 'Jane', lastName: 'Smith', salary: 2000.00, position: 'Manager']
        ]
    }


    @Unroll
    void "test update employee #employee"() {
        given:
        def employee = new Employee(
                firstName: 'John',
                lastName: 'Doe',
                salary: 1000.00,
                position: 'Developer'
        )
//        controller.employeeService.get(employee.id) >> employee

        when:
        controller.request.method = 'PUT'
        controller.request.contentType = 'application/json'
        controller.request.json = [
                firstName: 'UpdatedFirstName',
                lastName: 'UpdatedLastName',
                salary: 2000.00,
                position: 'Manager'
        ]
//        controller.update(employee.id)

        then:
        response.status == 200
        response.json['firstName'] == 'UpdatedFirstName'
        response.json['lastName'] == 'UpdatedLastName'
        response.json['salary'] == 2000.00
        response.json['position'] == 'Manager'

//        where:
//        employee << [
//                [id: 1, firstName: 'John', lastName: 'Doe', salary: 1000.00, position: 'Developer'],
//                [id: 2, firstName: 'Jane', lastName: 'Smith', salary: 2000.00, position: 'Manager']
//        ]
    }

    @Unroll
    void "test delete employee by id #id"() {
        given:
        def employee = new Employee(
                firstName: 'John',
                lastName: 'Doe',
                salary: 1000.00,
                position: 'Developer'
        )
        controller.employeeService.get(employee.id) >> employee

        when:
        controller.request.method = 'DELETE'
        controller.delete(employee.id)

        then:
        response.status == 204

        where:
        id << [1, 2, 3]
    }

}
