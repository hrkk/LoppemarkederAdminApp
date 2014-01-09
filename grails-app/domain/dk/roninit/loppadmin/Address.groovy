package dk.roninit.loppadmin

class Address extends BasicEntity {

    static hasMany = [markeditems: CoreMarkedItem]
    def Country country
    static belongsTo = [Country]
    BigDecimal longitude
    BigDecimal latitude

    String postalCode    // zip Code
    String postalArea    // postal district
    String addressLine1  // display in app
    String addressLine2
    String addressLine3

    static constraints = {
        latitude(scale: 9, blank: false)
        longitude(scale: 9, blank: false)
        addressLine1(size: 1..100, maxSize: 100, blank: false)
        addressLine2(nullable: true, size: 0..100, maxSize: 100, blank: true)
        addressLine3(nullable: true, size: 0..100, maxSize: 100, blank: true)
        postalCode(nullable: true, size:4..4, minSize: 4, maxSize: 4, blank: true)
        postalArea(nullable: true, size:1..100, maxSize: 100, blank: true)
    }

    def beforeInsert() {
        super.superBeforeInsert()
    }

    def beforeUpdate() {
        super.superBeforeUpdate()
    }

    public String toString() {
        return addressLine1
    }
}
