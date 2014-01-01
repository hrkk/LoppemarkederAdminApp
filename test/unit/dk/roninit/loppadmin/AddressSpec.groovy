package dk.roninit.loppadmin

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Address)
class AddressSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        when:"toString executed"
        def adr = new Address(addressLine1 : "Skolestien 3").toString()

        then: "toString is fomattet"
          adr == "Skolestien 3"
    }
}
