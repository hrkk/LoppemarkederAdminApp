package dk.roninit.loppadmin

class BasicEntity {
    transient springSecurityService
    String createdBy
    Date dateCreated
    String modifiedBy
    Date lastUpdated

    def superBeforeInsert() {
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
