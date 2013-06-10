package loppemarkederadminapp

import grails.plugins.springsecurity.Secured
import org.springframework.dao.DataIntegrityViolationException

@Secured(['ROLE_ADMIN'])
class UserAgentTrailController {

    static scaffold = true

    def deleteAll() {
        UserAgentTrail.all.each { userAgentTrailInstance ->
            userAgentTrailInstance.delete(flush: true)
        }
        flash.message = message(code: 'default.deleted.message', args: [message(code: 'userAgentTrail.labels', default: 'Delete all done!')])
        redirect(action: "list")
    }
}
