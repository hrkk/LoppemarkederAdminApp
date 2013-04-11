package loppemarkederadminapp



import org.junit.*
import grails.test.mixin.*

@TestFor(MarkedItemController)
@Mock(MarkedItem)
class MarkedItemControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/markedItem/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.markedItemInstanceList.size() == 0
        assert model.markedItemInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.markedItemInstance != null
    }

    void testSave() {
        controller.save()

        assert model.markedItemInstance != null
        assert view == '/markedItem/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/markedItem/show/1'
        assert controller.flash.message != null
        assert MarkedItem.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/markedItem/list'

        populateValidParams(params)
        def markedItem = new MarkedItem(params)

        assert markedItem.save() != null

        params.id = markedItem.id

        def model = controller.show()

        assert model.markedItemInstance == markedItem
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/markedItem/list'

        populateValidParams(params)
        def markedItem = new MarkedItem(params)

        assert markedItem.save() != null

        params.id = markedItem.id

        def model = controller.edit()

        assert model.markedItemInstance == markedItem
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/markedItem/list'

        response.reset()

        populateValidParams(params)
        def markedItem = new MarkedItem(params)

        assert markedItem.save() != null

        // test invalid parameters in update
        params.id = markedItem.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/markedItem/edit"
        assert model.markedItemInstance != null

        markedItem.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/markedItem/show/$markedItem.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        markedItem.clearErrors()

        populateValidParams(params)
        params.id = markedItem.id
        params.version = -1
        controller.update()

        assert view == "/markedItem/edit"
        assert model.markedItemInstance != null
        assert model.markedItemInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/markedItem/list'

        response.reset()

        populateValidParams(params)
        def markedItem = new MarkedItem(params)

        assert markedItem.save() != null
        assert MarkedItem.count() == 1

        params.id = markedItem.id

        controller.delete()

        assert MarkedItem.count() == 0
        assert MarkedItem.get(markedItem.id) == null
        assert response.redirectedUrl == '/markedItem/list'
    }
}
