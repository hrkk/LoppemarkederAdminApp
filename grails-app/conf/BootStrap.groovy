class BootStrap {

    def auditLogService
    def init = { servletContext ->
        auditLogService.makeDomainClassesAuditable()
    }
    def destroy = {
    }
}
