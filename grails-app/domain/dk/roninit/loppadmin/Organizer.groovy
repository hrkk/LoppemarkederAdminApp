package dk.roninit.loppadmin

class Organizer {
    static hasMany = [markedItem: MarkedItem]
    String firstName
    String lastName
    String email
    String phone

    Date dateCreated
    Date lastUpdated

    static constraints = {
        firstName size:1..50, maxSize: 50
        lastName size:1..50, maxSize: 50
        email email: true, blank: false
        phone minSize: 8, maxSize: 8, blank: false
    }
}
