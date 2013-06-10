package loppemarkederadminapp


class UserAgentTrail {

    Date dateCreated

    def beforeInsert = {
        dateCreated = new Date()
    }
    String userAgent

    static constraints = {
    }
}
