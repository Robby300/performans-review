package performans.review

import grails.transaction.Transactional

@Transactional
class EmployeeService {

    def save(Employee employee) {
        employee.validate()
        employee.save(flush: true)
    }

    def delete(Employee employee) {
        employee.delete(flush: true)
    }

    def getAll() {
        Employee.list()
    }
}
