package dk.roninit.loppadmin



import grails.test.mixin.*
import spock.lang.*

@TestFor(MarkedItemController)
@Mock(MarkedItem)
class MarkedItemControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when: "The index action is executed"
        controller.index()

        then: "The model is correct"
        !model.markedItemInstanceList
        model.markedItemInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when: "The create action is executed"
        controller.create()

        then: "The model is correctly created"
        model.markedItemInstance != null
    }

    void "Test the save action correctly persists an instance"() {

        when: "The save action is executed with an invalid instance"
        def markedItem = new MarkedItem()
        markedItem.validate()
        controller.save(markedItem)

        then: "The create view is rendered again with the correct model"
        model.markedItemInstance != null
        view == 'create'

        when: "The save action is executed with a valid instance"
        response.reset()
        populateValidParams(params)
        markedItem = new MarkedItem(params)

        controller.save(markedItem)

        then: "A redirect is issued to the show action"
        response.redirectedUrl == '/markedItem/show/1'
        controller.flash.message != null
        MarkedItem.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when: "The show action is executed with a null domain"
        controller.show(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the show action"
        populateValidParams(params)
        def markedItem = new MarkedItem(params)
        controller.show(markedItem)

        then: "A model is populated containing the domain instance"
        model.markedItemInstance == markedItem
    }

    void "Test that the edit action returns the correct model"() {
        when: "The edit action is executed with a null domain"
        controller.edit(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the edit action"
        populateValidParams(params)
        def markedItem = new MarkedItem(params)
        controller.edit(markedItem)

        then: "A model is populated containing the domain instance"
        model.markedItemInstance == markedItem
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when: "Update is called for a domain instance that doesn't exist"
        controller.update(null)

        then: "A 404 error is returned"
        response.redirectedUrl == '/markedItem/index'
        flash.message != null


        when: "An invalid domain instance is passed to the update action"
        response.reset()
        def markedItem = new MarkedItem()
        markedItem.validate()
        controller.update(markedItem)

        then: "The edit view is rendered again with the invalid instance"
        view == 'edit'
        model.markedItemInstance == markedItem

        when: "A valid domain instance is passed to the update action"
        response.reset()
        populateValidParams(params)
        markedItem = new MarkedItem(params).save(flush: true)
        controller.update(markedItem)

        then: "A redirect is issues to the show action"
        response.redirectedUrl == "/markedItem/show/$markedItem.id"
        flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when: "The delete action is called for a null instance"
        controller.delete(null)

        then: "A 404 is returned"
        response.redirectedUrl == '/markedItem/index'
        flash.message != null

        when: "A domain instance is created"
        response.reset()
        populateValidParams(params)
        def markedItem = new MarkedItem(params).save(flush: true)

        then: "It exists"
        MarkedItem.count() == 1

        when: "The domain instance is passed to the delete action"
        controller.delete(markedItem)

        then: "The instance is deleted"
        MarkedItem.count() == 0
        response.redirectedUrl == '/markedItem/index'
        flash.message != null
    }
}
