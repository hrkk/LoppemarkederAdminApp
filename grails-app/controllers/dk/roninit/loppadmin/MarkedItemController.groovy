package dk.roninit.loppadmin

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional


@Transactional(readOnly = true)
class MarkedItemController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond MarkedItem.list(params), model: [markedItemInstanceCount: MarkedItem.count()]
    }

    @Secured(['ROLE_ADMIN'])
    def show(MarkedItem markedItemInstance) {
        respond markedItemInstance
    }

    @Secured(['ROLE_ADMIN'])
    def create() {
        respond new MarkedItem(params)
    }

    @Secured(['ROLE_ADMIN'])
    @Transactional
    def save(MarkedItem markedItemInstance) {
        if (markedItemInstance == null) {
            notFound()
            return
        }

        if (markedItemInstance.hasErrors()) {
            respond markedItemInstance.errors, view: 'create'
            return
        }

        markedItemInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'markedItemInstance.label', default: 'MarkedItem'), markedItemInstance.id])
                redirect markedItemInstance
            }
            '*' { respond markedItemInstance, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def edit(MarkedItem markedItemInstance) {
        respond markedItemInstance
    }

    @Secured(['ROLE_ADMIN'])
    @Transactional
    def update(MarkedItem markedItemInstance) {
        if (markedItemInstance == null) {
            notFound()
            return
        }

        if (markedItemInstance.hasErrors()) {
            respond markedItemInstance.errors, view: 'edit'
            return
        }

        markedItemInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'MarkedItem.label', default: 'MarkedItem'), markedItemInstance.id])
                redirect markedItemInstance
            }
            '*' { respond markedItemInstance, [status: OK] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    @Transactional
    def delete(MarkedItem markedItemInstance) {

        if (markedItemInstance == null) {
            notFound()
            return
        }

        markedItemInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'MarkedItem.label', default: 'MarkedItem'), markedItemInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'markedItemInstance.label', default: 'MarkedItem'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }

    def listJSON() {
        def obj = [markedItemInstanceList: MarkedItem.list(), markedItemInstanceTotal: MarkedItem.count()]
        render obj as JSON
    }


    private Date getDateWithoutTime(Calendar calendarIn) {
        Calendar toDateAsCalendar = Calendar.getInstance();
        toDateAsCalendar.set(Calendar.MILLISECOND, 0)
        toDateAsCalendar.set(calendarIn.get(Calendar.YEAR), calendarIn.get(Calendar.MONTH), calendarIn.get(Calendar.DATE), 0, 0, 0);
        return toDateAsCalendar.getTime();
    }

    def listJSON2() {
        // getAll markedCoreItems
        def allCoreMarkedItems = CoreMarkedItem.findAll()

        // build a MarkedItem list
        def markedItemList = []


        allCoreMarkedItems.eachWithIndex {coreMarkedItem, idx ->

            // dateInterval is added as a new markedItem

            coreMarkedItem.dateInterval.each { dateInterval ->

                MarkedItem mi = new MarkedItem(name: coreMarkedItem.name,
                        address: coreMarkedItem.address.addressLine1,
                        fromDate: dateInterval.fromDate,
                        toDate: dateInterval.toDate,
                        dateExtraInfo: coreMarkedItem.additionalOpenTimePeriod,
                        entreInfo: coreMarkedItem.entreInfo,
                        markedRules: coreMarkedItem.markedRules,
                        markedInformation: coreMarkedItem.markedInformation,
                        latitude: coreMarkedItem.address.latitude,
                        longitude: coreMarkedItem.address.longitude
                )
                mi.setId(++idx)
                markedItemList.add(mi)

            }
        }
        def list = markedItemList

        // remove timeout markets
        def listActive = []

        // if (item.fromDate.after(cal.getTime())) {
        Date nowAsDate = getDateWithoutTime(Calendar.getInstance());
        println "nowAsDate " + nowAsDate

        list.each { it ->
            // fix the dates
            it.setFromDate(getDateWithoutTime(it.fromDate.toCalendar()))

            // first the toDate is checked
            if (it.toDate != null) {
                it.setToDate(getDateWithoutTime(it.toDate.toCalendar()))
                Date toDateAsDate = it.toDate.toCalendar().getTime();
                println toDateAsDate
                // is toDate in the future or current date
                if (toDateAsDate.after(nowAsDate) || toDateAsDate.equals(nowAsDate)) {
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

}
