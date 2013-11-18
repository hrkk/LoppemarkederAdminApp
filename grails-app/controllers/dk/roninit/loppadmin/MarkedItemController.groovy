package dk.roninit.loppadmin



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MarkedItemController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond MarkedItem.list(params), model:[markedItemInstanceCount: MarkedItem.count()]
    }

    def show(MarkedItem markedItemInstance) {
        respond markedItemInstance
    }

    def create() {
        respond new MarkedItem(params)
    }

    @Transactional
    def save(MarkedItem markedItemInstance) {
        if (markedItemInstance == null) {
            notFound()
            return
        }

        if (markedItemInstance.hasErrors()) {
            respond markedItemInstance.errors, view:'create'
            return
        }

        markedItemInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'markedItemInstance.label', default: 'MarkedItem'), markedItemInstance.id])
                redirect markedItemInstance
            }
            '*' { respond markedItemInstance, [status: CREATED] }
        }
    }

    def edit(MarkedItem markedItemInstance) {
        respond markedItemInstance
    }

    @Transactional
    def update(MarkedItem markedItemInstance) {
        if (markedItemInstance == null) {
            notFound()
            return
        }

        if (markedItemInstance.hasErrors()) {
            respond markedItemInstance.errors, view:'edit'
            return
        }

        markedItemInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'MarkedItem.label', default: 'MarkedItem'), markedItemInstance.id])
                redirect markedItemInstance
            }
            '*'{ respond markedItemInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(MarkedItem markedItemInstance) {

        if (markedItemInstance == null) {
            notFound()
            return
        }

        markedItemInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'MarkedItem.label', default: 'MarkedItem'), markedItemInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'markedItemInstance.label', default: 'MarkedItem'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
