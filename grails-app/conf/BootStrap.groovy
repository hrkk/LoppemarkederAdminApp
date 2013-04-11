import loppemarkederadminapp.MarkedItem
import loppemarkederadminapp.Role
import loppemarkederadminapp.User
import loppemarkederadminapp.UserRole

class BootStrap {

    def init = { servletContext ->
        def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

        def adminUser = new User(username: 'luke', enabled: true, password: 'skywalker')
        adminUser.save(flush: true)

        UserRole.create adminUser, adminRole, true

        assert User.count() == 1
        assert Role.count() == 2
        assert UserRole.count() == 1

        if (!MarkedItem.count()) {

            Calendar fromDate =  Calendar.getInstance()
            fromDate.set(Calendar.MONTH, Calendar.APRIL)
            fromDate.set(Calendar.DATE, 20)

            Calendar toDate =  Calendar.getInstance()
            toDate.set(Calendar.MONTH, Calendar.APRIL)
            toDate.set(Calendar.DATE, 21)


            def testMarked = new MarkedItem(name: 'Kræmmermarked i Glostrup Idrætspark',
                    fromDate: fromDate.getTime(),
                    toDate: toDate.getTime(),
                    entreInfo: 'for publikum er 10,- kr. / børn er gratis ifølge med voksen ',
                    address: 'Glostrup Idrætspark, Stadionvej 80, 2600 Glostrup ',
                    latitude: 55.66922, longitude: 12.40214,
                    dateExtraInfo: 'begge dage kl. 10.00-16.00',
                    markedRules: 'markedRules',
                    markedInformation: 'markedInformation'
            )

            testMarked.save(flush: true)
        }
    }
    def destroy = {
    }
}
