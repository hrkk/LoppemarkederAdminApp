package dk.roninit.loppadmin

class Organizer extends BasicEntity {
    static hasMany = [markedItem: MarkedItem]
    String name
    String email
    String phone
    boolean enableBooking // currently it's a link

    static constraints = {
        name size:1..50, maxSize: 50, blank: false
        email email: true, blank: false
        phone minSize: 8, maxSize: 8, blank: false
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
