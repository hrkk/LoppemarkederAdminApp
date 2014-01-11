package dk.roninit.loppadmin

class Country extends BasicEntity {
    static hasMany = [addresses: Address]
    String countryName
    String countryCode

    static constraints = {
        countryName(size:1..50, maxSize: 50, blank: false)
        countryCode(size:1..2, maxSize: 2, blank: false)
        addresses display: false
    }

    def beforeInsert() {
        super.superBeforeInsert()
    }

    def beforeUpdate() {
        super.superBeforeUpdate()
    }


    @Override
    public String toString() {
        return countryName
    }
}
