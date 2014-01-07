import dk.roninit.loppadmin.MarkedItem
import dk.roninit.loppadmin.Role
import dk.roninit.loppadmin.User
import dk.roninit.loppadmin.UserRole

class BootStrap {

    def init = { servletContext ->
        if (!Role.findByAuthority('ROLE_ADMIN')) {
            def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
            def adminUser = new User(username: 'luke', enabled: true, password: 'skywalker')
            adminUser.save(flush: true)

            UserRole.create adminUser, adminRole, true
        }

        if (!MarkedItem.findByName('Brønshøj Torv')) {

            Calendar fromDate = Calendar.getInstance()
            fromDate.set(Calendar.MONTH, Calendar.APRIL)
            fromDate.set(Calendar.DATE, 5)

            Calendar toDate = Calendar.getInstance()
            toDate.set(Calendar.MONTH, Calendar.APRIL)
            toDate.set(Calendar.DATE, 5)

            def marked1 = new MarkedItem(name: 'Brønshøj Torv',
                    fromDate: fromDate.getTime(),
                    toDate: toDate.getTime(),
                    entreInfo: 'Gratis adgang',
                    address: 'Frederikssundsvej, 2700 Brønshøj',
                    latitude: 55.7043, longitude: 12.49906,
                    dateExtraInfo: 'Åbent fra 9 til 15',
                    markedRules: 'Loppemarkedet på Brønshøj torv er et loppemarked, hvor du kun kan købe brugte ting.',
                    markedInformation: 'Markedet er udendørs med 70 pladser'
            )

            marked1.save(flush: true)
        }


        if (!MarkedItem.findByName('Loppemarked i Farum Arena')) {

            Calendar fromDate = Calendar.getInstance()
            fromDate.set(Calendar.MONTH, Calendar.FEBRUARY)
            fromDate.set(Calendar.DATE, 22)

            Calendar toDate = Calendar.getInstance()
            toDate.set(Calendar.MONTH, Calendar.FEBRUARY)
            toDate.set(Calendar.DATE, 23)

            def marked = new MarkedItem(name: 'Loppemarked i Farum Arena',
                    fromDate: fromDate.getTime(),
                    toDate: toDate.getTime(),
                    entreInfo: 'Entre 40,00 for voksne, børn under 12 år er gratis iflg. med en voksen.',
                    address: 'Stavnsholtvej 41, 3520 Farum',
                    latitude: 55.81447, longitude: 12.39431,
                    dateExtraInfo: 'Åbent begge dage fra 10 til 16.',
                    markedRules: 'Loppemarkedet i Farum Arena er et loppemarked, hvor der kun sælges brugt.',
                    markedInformation: 'Der er 140 stader.'
            )

            marked.save(flush: true)
        }

        if (!MarkedItem.findByName('Loppemarked i Frederiksborghallen')) {

            Calendar fromDate = Calendar.getInstance()
            fromDate.set(Calendar.MONTH, Calendar.JANUARY)
            fromDate.set(Calendar.DATE, 25)

            Calendar toDate = Calendar.getInstance()
            toDate.set(Calendar.MONTH, Calendar.JANUARY)
            toDate.set(Calendar.DATE, 26)

            def marked = new MarkedItem(name: 'Loppemarked i Frederiksborghallen',
                    fromDate: fromDate.getTime(),
                    toDate: toDate.getTime(),
                    entreInfo: 'Entre 40,00 for voksne, børn under 12 år gratis adgang iflg. med voksen.',
                    address: 'Milnersvej 39, 3400 Hillerød',
                    latitude: 55.92213, longitude: 12.29992,
                    dateExtraInfo: 'Åbent begge dage fra 10 til 16.',
                    markedRules: 'Loppemarkedet i Frederiksborghallen er et vaskeægte loppemarked, hvor der kun sælges gamle brugte ting.',
                    markedInformation: 'Der er over 160 stader, og markedet er indendørs. Du booker stade online på markedsbooking.dk'
            )

            marked.save(flush: true)
        }

        if (!MarkedItem.findByName('Loppe- og kræmmermarked i Slagelse')) {

            Calendar fromDate = Calendar.getInstance()
            fromDate.set(Calendar.MONTH, Calendar.JANUARY)
            fromDate.set(Calendar.DATE, 25)

            Calendar toDate = Calendar.getInstance()
            toDate.set(Calendar.MONTH, Calendar.JANUARY)
            toDate.set(Calendar.DATE, 26)

            def marked = new MarkedItem(name: 'Loppe- og kræmmermarked i Slagelse',
                    fromDate: fromDate.getTime(),
                    toDate: toDate.getTime(),
                    entreInfo: '25 kr.',
                    address: 'Parkvej 33',
                    latitude: 55.40096, longitude: 11.3628,
                    dateExtraInfo: 'kl. 10-15',
                    markedRules: 'ej beskrevet',
                    markedInformation: 'Markedet er en blanding af private "loppekræmmere" med behov for oprydning i gemmerne samt mere rutinerede loppekræmmere. hovedsageligt gammelt og brugt, men få stader med nye kvalitetseffekter. foregår i Slagelse Hallen'
            )

            marked.save(flush: true)
        }
    }
    def destroy = {
    }
}
