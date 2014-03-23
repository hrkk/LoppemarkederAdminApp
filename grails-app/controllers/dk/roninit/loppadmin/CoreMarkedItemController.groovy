package dk.roninit.loppadmin



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CoreMarkedItemController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CoreMarkedItem.list(params), model:[coreMarkedItemInstanceCount: CoreMarkedItem.count()]
    }

    def show(CoreMarkedItem coreMarkedItemInstance) {
        respond coreMarkedItemInstance
    }

    def create() {
        respond new CoreMarkedItem(params)
    }

    @Transactional
    def save(CoreMarkedItem coreMarkedItemInstance) {
        if (coreMarkedItemInstance == null) {
            notFound()
            return
        }

        if (coreMarkedItemInstance.hasErrors()) {
            respond coreMarkedItemInstance.errors, view:'create'
            return
        }

        coreMarkedItemInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'coreMarkedItemInstance.label', default: 'CoreMarkedItem'), coreMarkedItemInstance.id])
                redirect coreMarkedItemInstance
            }
            '*' { respond coreMarkedItemInstance, [status: CREATED] }
        }
    }

    def edit(CoreMarkedItem coreMarkedItemInstance) {
        respond coreMarkedItemInstance
    }

    @Transactional
    def update(CoreMarkedItem coreMarkedItemInstance) {
        if (coreMarkedItemInstance == null) {
            notFound()
            return
        }

        if (coreMarkedItemInstance.hasErrors()) {
            respond coreMarkedItemInstance.errors, view:'edit'
            return
        }
        // bugfix for update more then 1 element
        def dateIntevalParams = params.get("dateInterval")
        boolean isArray = dateIntevalParams instanceof Object[]
        if (isArray) {
            coreMarkedItemInstance.dateInterval.clear();
            dateIntevalParams.each { it ->
                def di = DateInterval.get(it)
                coreMarkedItemInstance.dateInterval.add(di)
            }
        }

        coreMarkedItemInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'CoreMarkedItem.label', default: 'CoreMarkedItem'), coreMarkedItemInstance.id])
                redirect coreMarkedItemInstance
            }
            '*'{ respond coreMarkedItemInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(CoreMarkedItem coreMarkedItemInstance) {

        if (coreMarkedItemInstance == null) {
            notFound()
            return
        }

        coreMarkedItemInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CoreMarkedItem.label', default: 'CoreMarkedItem'), coreMarkedItemInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'coreMarkedItemInstance.label', default: 'CoreMarkedItem'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
