package dk.roninit.loppadmin

class DateInterval {

    Date fromDate;
    Date toDate;

    def dateCreated
    def lastUpdated

    static constraints = {
        fromDate blank: false
        toDate blank: false
    }
}
