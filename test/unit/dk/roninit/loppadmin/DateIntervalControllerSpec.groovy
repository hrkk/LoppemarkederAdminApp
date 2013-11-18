package dk.roninit.loppadmin



import grails.test.mixin.*
import spock.lang.*

@TestFor(DateIntervalController)
@Mock(DateInterval)
class DateIntervalControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.dateIntervalInstanceList
            model.dateIntervalInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.dateIntervalInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            def dateInterval = new DateInterval()
            dateInterval.validate()
            controller.save(dateInterval)

        then:"The create view is rendered again with the correct model"
            model.dateIntervalInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            dateInterval = new DateInterval(params)

            controller.save(dateInterval)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/dateInterval/show/1'
            controller.flash.message != null
            DateInterval.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def dateInterval = new DateInterval(params)
            controller.show(dateInterval)

        then:"A model is populated containing the domain instance"
            model.dateIntervalInstance == dateInterval
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def dateInterval = new DateInterval(params)
            controller.edit(dateInterval)

        then:"A model is populated containing the domain instance"
            model.dateIntervalInstance == dateInterval
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/dateInterval/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def dateInterval = new DateInterval()
            dateInterval.validate()
            controller.update(dateInterval)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.dateIntervalInstance == dateInterval

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            dateInterval = new DateInterval(params).save(flush: true)
            controller.update(dateInterval)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/dateInterval/show/$dateInterval.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/dateInterval/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def dateInterval = new DateInterval(params).save(flush: true)

        then:"It exists"
            DateInterval.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(dateInterval)

        then:"The instance is deleted"
            DateInterval.count() == 0
            response.redirectedUrl == '/dateInterval/index'
            flash.message != null
    }
}
