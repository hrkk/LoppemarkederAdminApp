package dk.roninit.loppadmin



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DateIntervalController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond DateInterval.list(params), model:[dateIntervalInstanceCount: DateInterval.count()]
    }

    def show(DateInterval dateIntervalInstance) {
        respond dateIntervalInstance
    }

    def create() {
        respond new DateInterval(params)
    }

    @Transactional
    def save(DateInterval dateIntervalInstance) {
        if (dateIntervalInstance == null) {
            notFound()
            return
        }

        if (dateIntervalInstance.hasErrors()) {
            respond dateIntervalInstance.errors, view:'create'
            return
        }

        dateIntervalInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'dateIntervalInstance.label', default: 'DateInterval'), dateIntervalInstance.id])
                redirect dateIntervalInstance
            }
            '*' { respond dateIntervalInstance, [status: CREATED] }
        }
    }

    def edit(DateInterval dateIntervalInstance) {
        respond dateIntervalInstance
    }

    @Transactional
    def update(DateInterval dateIntervalInstance) {
        if (dateIntervalInstance == null) {
            notFound()
            return
        }

        if (dateIntervalInstance.hasErrors()) {
            respond dateIntervalInstance.errors, view:'edit'
            return
        }

        dateIntervalInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'DateInterval.label', default: 'DateInterval'), dateIntervalInstance.id])
                redirect dateIntervalInstance
            }
            '*'{ respond dateIntervalInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(DateInterval dateIntervalInstance) {

        if (dateIntervalInstance == null) {
            notFound()
            return
        }

        dateIntervalInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'DateInterval.label', default: 'DateInterval'), dateIntervalInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'dateIntervalInstance.label', default: 'DateInterval'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
