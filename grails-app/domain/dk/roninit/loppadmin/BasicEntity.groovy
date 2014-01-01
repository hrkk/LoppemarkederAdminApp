package dk.roninit.loppadmin

class BasicEntity {
    transient springSecurityService
    Date dateCreated
    Date lastUpdated

    String createdBy
    String modifiedBy

    def superBeforeInsert() {
        println "beforeInsert i BasicEntity domain!!"
        createdBy = getUsername()
    }

    def superBeforeUpdate() {
        modifiedBy = getUsername()
    }

    def getUsername() {
        def user = springSecurityService?.getCurrentUser()
        def username = user?.username
        if (username == null) username = "anonymousUser"
        return username
    }
    static constraints = {
        createdBy(nullable: true)
        modifiedBy(nullable: true)
    }
}
