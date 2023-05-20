package performans.review



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EmployeeController {

    def employeeService
    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        respond employeeService.getAll(), [status: OK]
    }

    @Transactional
    def save(Employee employeeInstance) {
        if (employeeInstance == null) {
            render status: NOT_FOUND
            return
        }

        employeeInstance.validate()
        if (employeeInstance.hasErrors()) {
            render status: NOT_ACCEPTABLE
            return
        }
        respond employeeService.save(employeeInstance), [status: CREATED]
    }

    @Transactional
    def update(Employee employeeInstance) {
        if (employeeInstance == null) {
            render status: NOT_FOUND
            return
        }

        employeeInstance.validate()
        if (employeeInstance.hasErrors()) {
            render status: NOT_ACCEPTABLE
            return
        }
        respond employeeService.save(employeeInstance), [status: OK]
    }

    @Transactional
    def delete(Employee employeeInstance) {

        if (employeeInstance == null) {
            render status: NOT_FOUND
            return
        }

        employeeService.delete(employeeInstance)
        render status: NO_CONTENT
    }
}
