package dk.roninit.loppadmin

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Country)
class CountrySpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test toString"() {
        when:"toString executed"
        def country = new Country(countryName: "Danmark").toString()

        then: "toString is fomattet"
        country == "Danmark"
    }
}
