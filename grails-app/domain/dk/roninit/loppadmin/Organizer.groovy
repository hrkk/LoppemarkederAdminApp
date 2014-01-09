package dk.roninit.loppadmin

class Organizer extends BasicEntity {
    static hasMany = [markedItem: CoreMarkedItem]
    String name
    String email
    String phone
    boolean enableBooking = false// currently it's a link

    static constraints = {
        name size:1..50, maxSize: 50, blank: false
        email email: true, blank: false
        phone nullable: true, minSize: 8, maxSize: 8, blank: true
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
