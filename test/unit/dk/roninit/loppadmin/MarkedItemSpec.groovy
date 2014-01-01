package dk.roninit.loppadmin

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(MarkedItem)
class MarkedItemSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test toString"() {
        when:"toString executed"
        def markedItem = new MarkedItem(name: "Marked 1").toString()

        then: "toString is fomattet"
        markedItem == "Marked 1"
    }
}
