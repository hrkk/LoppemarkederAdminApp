package dk.roninit.loppadmin



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AuditLogController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond AuditLog.list(params), model: [auditLogInstanceCount: AuditLog.count()]
    }

    def show(AuditLog auditLogInstance) {
        respond auditLogInstance
    }

    def create() {
        respond new AuditLog(params)
    }

    @Transactional
    def save(AuditLog auditLogInstance) {
        if (auditLogInstance == null) {
            notFound()
            return
        }

        if (auditLogInstance.hasErrors()) {
            respond auditLogInstance.errors, view: 'create'
            return
        }

        auditLogInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'auditLogInstance.label', default: 'AuditLog'), auditLogInstance.id])
                redirect auditLogInstance
            }
            '*' { respond auditLogInstance, [status: CREATED] }
        }
    }

    def edit(AuditLog auditLogInstance) {
        respond auditLogInstance
    }

    @Transactional
    def update(AuditLog auditLogInstance) {
        if (auditLogInstance == null) {
            notFound()
            return
        }

        if (auditLogInstance.hasErrors()) {
            respond auditLogInstance.errors, view: 'edit'
            return
        }

        auditLogInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'AuditLog.label', default: 'AuditLog'), auditLogInstance.id])
                redirect auditLogInstance
            }
            '*' { respond auditLogInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(AuditLog auditLogInstance) {

        if (auditLogInstance == null) {
            notFound()
            return
        }

        auditLogInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'AuditLog.label', default: 'AuditLog'), auditLogInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'auditLogInstance.label', default: 'AuditLog'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
