package loppemarkederadminapp

import grails.converters.JSON
import grails.plugins.springsecurity.Secured
import org.springframework.dao.DataIntegrityViolationException


import java.text.SimpleDateFormat

class MarkedItemController {

    def beforeInterceptor = [action: this.&auth, except: ['index', 'create','save', 'show', 'edit', 'delete', 'list']]

    private auth() {
        def userAgent = request.getHeader('User-Agent')
        new UserAgentTrail(userAgent: "${userAgent}").save(flush: true)
    }

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    @Secured(['ROLE_ADMIN'])
    def index() {
        redirect(action: "list", params: params)
    }

    @Secured(['ROLE_ADMIN'])
    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [markedItemInstanceList: MarkedItem.list(params), markedItemInstanceTotal: MarkedItem.count()]
    }

    def listJSON() {
        def obj = [markedItemInstanceList: MarkedItem.list(), markedItemInstanceTotal: MarkedItem.count()]
        render obj as JSON
    }

    def listJSON2() {
        def list = MarkedItem.list()

        // remove timeout markets
        def listActive = []
        // check date
        Calendar now = Calendar.getInstance();
        now.set(Calendar.MILLISECOND, 0)
        now.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DATE), 0, 0, 0);

        // if (item.fromDate.after(cal.getTime())) {
        Date nowAsDate = now.getTime();

        list.each { it ->
            // first the toDate is checked
            if (it.toDate != null) {
                Date toDateAsDate = it.toDate.toCalendar().getTime();
                // is toDate in the future or current date
                if (toDateAsDate.after(nowAsDate) || toDateAsDate.equals(nowAsDate) ) {
                    listActive << it
                }
            } else {
                Date fromDateAsDate = it.fromDate.toCalendar().getTime();
                // id fromDate in the future or current date
                if (fromDateAsDate.after(nowAsDate) || fromDateAsDate.equals(nowAsDate)) {
                    listActive << it
                }
            }
        }
        def obj = [markedItemInstanceList: listActive, markedItemInstanceTotal: listActive.size()]
        render obj as JSON
    }

    @Secured(['ROLE_ADMIN'])
    def create() {
        [markedItemInstance: new MarkedItem(params)]
    }

    @Secured(['ROLE_ADMIN'])
    def save() {
        def markedItemInstance = new MarkedItem(params)
        if (!markedItemInstance.save(flush: true)) {
            render(view: "create", model: [markedItemInstance: markedItemInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'markedItem.label', default: 'MarkedItem'), markedItemInstance.id])
        redirect(action: "show", id: markedItemInstance.id)
    }

    @Secured(['ROLE_ADMIN'])
    def show(Long id) {
        def markedItemInstance = MarkedItem.get(id)
        if (!markedItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'markedItem.label', default: 'MarkedItem'), id])
            redirect(action: "list")
            return
        }

        [markedItemInstance: markedItemInstance]
    }

    @Secured(['ROLE_ADMIN'])
    def edit(Long id) {
        def markedItemInstance = MarkedItem.get(id)
        if (!markedItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'markedItem.label', default: 'MarkedItem'), id])
            redirect(action: "list")
            return
        }

        [markedItemInstance: markedItemInstance]
    }

    @Secured(['ROLE_ADMIN'])
    def update(Long id, Long version) {
        def markedItemInstance = MarkedItem.get(id)
        if (!markedItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'markedItem.label', default: 'MarkedItem'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (markedItemInstance.version > version) {
                markedItemInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'markedItem.label', default: 'MarkedItem')] as Object[],
                          "Another user has updated this MarkedItem while you were editing")
                render(view: "edit", model: [markedItemInstance: markedItemInstance])
                return
            }
        }

        markedItemInstance.properties = params

        if (!markedItemInstance.save(flush: true)) {
            render(view: "edit", model: [markedItemInstance: markedItemInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'markedItem.label', default: 'MarkedItem'), markedItemInstance.id])
        redirect(action: "show", id: markedItemInstance.id)
    }

    @Secured(['ROLE_ADMIN'])
    def delete(Long id) {
        def markedItemInstance = MarkedItem.get(id)
        if (!markedItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'markedItem.label', default: 'MarkedItem'), id])
            redirect(action: "list")
            return
        }

        try {
            markedItemInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'markedItem.label', default: 'MarkedItem'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'markedItem.label', default: 'MarkedItem'), id])
            redirect(action: "show", id: id)
        }
    }
}
