package dk.roninit.loppadmin

class MarkedItem extends BasicEntity {

    static hasMany = [dateInterval: DateInterval]
    def Address address
    def Organizer organizer
    static belongsTo = [Address, Organizer]
    String name;
    String additionalOpenTimePeriod;
    String entreInfo;
    String markedRules;
    String markedInformation;

    static constraints = {
        name(size:1..50, maxSize: 50, blank: false)
        additionalOpenTimePeriod(size:1..256, blank: true)
        entreInfo(size:1..256, blank: false)
        markedRules(size:1..256, blank: false)
        markedInformation(size:1..256, blank: false)
    }

    def beforeInsert() {
        super.superBeforeInsert()
    }

    def beforeUpdate() {
        super.superBeforeUpdate()
    }


    @Override
    public java.lang.String toString() {
        return name
    }
}
