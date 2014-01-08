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

    void "test something"() {
        when: "halløj"
            def str = "str"

        then: "halløj 2"
            str == "str"
    }
}
