package dk.roninit.loppadmin

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Organizer)
class OrganizerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test toString"() {
        when:"toString executed"
        def organizer = new Organizer(name: "Kim NNN").toString()

        then: "toString is fomattet"
        organizer == "Kim NNN"
    }
}
