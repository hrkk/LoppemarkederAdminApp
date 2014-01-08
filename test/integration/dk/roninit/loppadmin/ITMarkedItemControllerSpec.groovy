package dk.roninit.loppadmin

import grails.test.mixin.TestFor
import org.codehaus.groovy.grails.web.json.JSONArray
import spock.lang.*

@TestFor(MarkedItemController)
class ITMarkedItemControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test listJSON"() {
        when: "call to listJSON"
        controller != null
        controller.listJSON()

        then: "listJson has values"
        controller.response.json != null
        def json = controller.response.json

        JSONArray aJSONArray = json.getAt("markedItemInstanceList")

        aJSONArray.length() == 4

        aJSONArray.each { item ->
            assert item.name != null
            assert item.address != null
            assert item.dateExtraInfo != null
            assert item.entreInfo != null
            assert item.fromDate != null
            assert item.latitude != null
            assert item.longitude != null
            assert item.markedInformation != null
            assert item.markedRules != null
            assert item.toDate != null
        }
    }

    void "test listJSON2 (iPhone)"() {
        when: "call to listJSON"
        controller != null
        controller.listJSON2()

        then: "listJson has values"
        controller.response.json != null
        def json = controller.response.json

        JSONArray aJSONArray = json.getAt("markedItemInstanceList")

        aJSONArray.length() == 4

        aJSONArray.each { item ->
            assert item.name != null
            assert item.address != null
            assert item.dateExtraInfo != null
            assert item.entreInfo != null
            assert item.fromDate != null
            assert item.latitude != null
            assert item.longitude != null
            assert item.markedInformation != null
            assert item.markedRules != null
            assert item.toDate != null
        }
    }
}