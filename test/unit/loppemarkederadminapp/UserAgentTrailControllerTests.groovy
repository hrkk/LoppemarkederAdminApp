package loppemarkederadminapp



import org.junit.*
import grails.test.mixin.*

@TestFor(UserAgentTrailController)
@Mock(UserAgentTrail)
class UserAgentTrailControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/userAgentTrail/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.userAgentTrailInstanceList.size() == 0
        assert model.userAgentTrailInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.userAgentTrailInstance != null
    }

    void testSave() {
        controller.save()

        assert model.userAgentTrailInstance != null
        assert view == '/userAgentTrail/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/userAgentTrail/show/1'
        assert controller.flash.message != null
        assert UserAgentTrail.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/userAgentTrail/list'

        populateValidParams(params)
        def userAgentTrail = new UserAgentTrail(params)

        assert userAgentTrail.save() != null

        params.id = userAgentTrail.id

        def model = controller.show()

        assert model.userAgentTrailInstance == userAgentTrail
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/userAgentTrail/list'

        populateValidParams(params)
        def userAgentTrail = new UserAgentTrail(params)

        assert userAgentTrail.save() != null

        params.id = userAgentTrail.id

        def model = controller.edit()

        assert model.userAgentTrailInstance == userAgentTrail
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/userAgentTrail/list'

        response.reset()

        populateValidParams(params)
        def userAgentTrail = new UserAgentTrail(params)

        assert userAgentTrail.save() != null

        // test invalid parameters in update
        params.id = userAgentTrail.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/userAgentTrail/edit"
        assert model.userAgentTrailInstance != null

        userAgentTrail.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/userAgentTrail/show/$userAgentTrail.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        userAgentTrail.clearErrors()

        populateValidParams(params)
        params.id = userAgentTrail.id
        params.version = -1
        controller.update()

        assert view == "/userAgentTrail/edit"
        assert model.userAgentTrailInstance != null
        assert model.userAgentTrailInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/userAgentTrail/list'

        response.reset()

        populateValidParams(params)
        def userAgentTrail = new UserAgentTrail(params)

        assert userAgentTrail.save() != null
        assert UserAgentTrail.count() == 1

        params.id = userAgentTrail.id

        controller.delete()

        assert UserAgentTrail.count() == 0
        assert UserAgentTrail.get(userAgentTrail.id) == null
        assert response.redirectedUrl == '/userAgentTrail/list'
    }
}
