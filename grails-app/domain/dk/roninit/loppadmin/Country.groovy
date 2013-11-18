package dk.roninit.loppadmin

class Country {

    static hasMany = [addresses: Address]
    String countryName
    String countryCode

    Date dateCreated
    Date lastUpdated

    static auditable

    static constraints = {
        countryName(size:1..50, maxSize: 50, blank: false)
        countryCode(size:1..2, maxSize: 2, blank: false)
    }
}
