package dk.roninit.loppadmin

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DateInterval)
class DateIntervalSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test toString"() {
        when:"toString executed"
        def dateInterval = new DateInterval(fromDate: createDate(1,12,2013,3,2),toDate: createDate(2,12,2013,3,2)).toString()

        then: "toString is fomattet"
        dateInterval == "01-12-2013 - 02-12-2013"
    }

    private static Date createDate(int day, int month, int year, int hour,
                                   int min) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, day);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.HOUR, hour);
        cal.set(Calendar.MINUTE, hour);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}
