package dk.roninit.loppadmin

class Address {

    static hasMany = [markeditems: MarkedItem]
    def Country country
    static belongsTo = [Country]
    double longitude
    double latitude

    String postalCode
    String addressLine

    def dateCreated
    def lastUpdated

    static constraints = {
        addressLine(size: 1..100, maxSize: 100, blank: false)
        postalCode(size:4..4, minSize: 4, maxSize: 4, blank: false)
        latitude(scale: 9, blank: false)
        longitude(scale: 9, blank: false)
    }
}
