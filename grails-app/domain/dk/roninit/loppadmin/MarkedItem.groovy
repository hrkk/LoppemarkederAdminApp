package dk.roninit.loppadmin

class MarkedItem {

    static hasMany = [dateInterval: DateInterval]
    def Address address
    def Organizer organizer
    static belongsTo = [Address, Organizer]
    String name;
    String additionalOpenTimePeriod;
    String entreInfo;
    String markedRules;
    String markedInformation;
    def dateCreated
    def lastUpdated

    static constraints = {
        name(size:1..50, maxSize: 50, blank: false)
        additionalOpenTimePeriod(size:1..256, blank: true)
        entreInfo(size:1..256, blank: false)
        markedRules(size:1..256, blank: false)
        markedInformation(size:1..256, blank: false)
    }
}
