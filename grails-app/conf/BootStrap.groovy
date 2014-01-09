import dk.roninit.loppadmin.Address
import dk.roninit.loppadmin.CoreMarkedItem
import dk.roninit.loppadmin.Country
import dk.roninit.loppadmin.DateInterval
import dk.roninit.loppadmin.MarkedItem
import dk.roninit.loppadmin.Organizer
import dk.roninit.loppadmin.Role
import dk.roninit.loppadmin.User
import dk.roninit.loppadmin.UserRole

import java.text.SimpleDateFormat

class BootStrap {

    def init = { servletContext ->
        if (!Role.findByAuthority('ROLE_ADMIN')) {
            def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
            def adminUser = new User(username: 'luke', enabled: true, password: 'skywalker')
            adminUser.save(flush: true)

            UserRole.create adminUser, adminRole, true
        }

        Calendar fromDateBroenshoejTorv = Calendar.getInstance()
        fromDateBroenshoejTorv.set(Calendar.MONTH, Calendar.APRIL)
        fromDateBroenshoejTorv.set(Calendar.DATE, 5)

        Calendar toDateBroenshoejTorv = Calendar.getInstance()
        toDateBroenshoejTorv.set(Calendar.MONTH, Calendar.APRIL)
        toDateBroenshoejTorv.set(Calendar.DATE, 5)

        Calendar fromDateFarumArena = Calendar.getInstance()
        fromDateFarumArena.set(Calendar.MONTH, Calendar.FEBRUARY)
        fromDateFarumArena.set(Calendar.DATE, 22)

        Calendar toDateFarumArena = Calendar.getInstance()
        toDateFarumArena.set(Calendar.MONTH, Calendar.FEBRUARY)
        toDateFarumArena.set(Calendar.DATE, 23)

        Calendar fromDateFrederiksborghallen = Calendar.getInstance()
        fromDateFrederiksborghallen.set(Calendar.MONTH, Calendar.JANUARY)
        fromDateFrederiksborghallen.set(Calendar.DATE, 25)

        Calendar toDateFrederiksborghallen = Calendar.getInstance()
        toDateFrederiksborghallen.set(Calendar.MONTH, Calendar.JANUARY)
        toDateFrederiksborghallen.set(Calendar.DATE, 26)

        Calendar fromDateSlagelse = Calendar.getInstance()
        fromDateSlagelse.set(Calendar.MONTH, Calendar.JANUARY)
        fromDateSlagelse.set(Calendar.DATE, 25)

        Calendar toDateSlagelse = Calendar.getInstance()
        toDateSlagelse.set(Calendar.MONTH, Calendar.JANUARY)
        toDateSlagelse.set(Calendar.DATE, 26)



        if (!MarkedItem.findByName('Brønshøj Torv')) {
            def marked1 = new MarkedItem(name: 'Brønshøj Torv',
                    fromDate: fromDateBroenshoejTorv.getTime(),
                    toDate: toDateBroenshoejTorv.getTime(),
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
            def marked = new MarkedItem(name: 'Loppemarked i Farum Arena',
                    fromDate: fromDateFarumArena.getTime(),
                    toDate: toDateFarumArena.getTime(),
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
            def marked = new MarkedItem(name: 'Loppemarked i Frederiksborghallen',
                    fromDate: fromDateFrederiksborghallen.getTime(),
                    toDate: toDateFrederiksborghallen.getTime(),
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
            def marked = new MarkedItem(name: 'Loppe- og kræmmermarked i Slagelse',
                    fromDate: fromDateSlagelse.getTime(),
                    toDate: toDateSlagelse.getTime(),
                    entreInfo: '25 kr.',
                    address: 'Parkvej 33',
                    latitude: 55.40096, longitude: 11.3628,
                    dateExtraInfo: 'kl. 10-15',
                    markedRules: 'ej beskrevet',
                    markedInformation: 'Markedet er en blanding af private "loppekræmmere" med behov for oprydning i gemmerne samt mere rutinerede loppekræmmere. hovedsageligt gammelt og brugt, men få stader med nye kvalitetseffekter. foregår i Slagelse Hallen'
            )

            marked.save(flush: true)
        }

        // ny struktur

        if (!Country.findByCountryCode("DK")) {
            def dkCountry = new Country(countryCode: "DK", countryName: "Danmark")
            dkCountry.save(flush: true)
        }

        // addresse
        Address adrBroenshoej
        if (!Address.findByAddressLine1("Frederikssundsvej, 2700 Brønshøj")) {
            adrBroenshoej = new Address(addressLine1: "Frederikssundsvej, 2700 Brønshøj",
                    latitude: 55.7043,
                    longitude: 12.49906,
                    postalCode: "2700",
                    postalArea: "Brønshøj",
                    country: Country.findByCountryCode("DK"));

            adrBroenshoej = adrBroenshoej.save(flush: true)
        }

        Address adrFarum
        if (!Address.findByAddressLine1("Stavnsholtvej 41, 3520 Farum")) {
            adrFarum = new Address(addressLine1: "Stavnsholtvej 41, 3520 Farum",
                    latitude: 55.81447,
                    longitude: 12.39431,
                    postalCode: "3520",
                    postalArea: "Farum",
                    country: Country.findByCountryCode("DK"));

            adrFarum = adrFarum.save(flush: true)
        }

        Address adrHilleroed
        if (!Address.findByAddressLine1("Milnersvej 39, 3400 Hillerød")) {
            adrHilleroed = new Address(addressLine1: "Milnersvej 39, 3400 Hillerød",
                    latitude: 55.92213,
                    longitude: 12.29992,
                    postalCode: "3400",
                    postalArea: "Hillerød",
                    country: Country.findByCountryCode("DK"));

            adrHilleroed = adrHilleroed.save(flush: true)
        }

        Address adrSlagelse
        if (!Address.findByAddressLine1("Parkvej 33")) {
            adrSlagelse = new Address(addressLine1: "Parkvej 33",
                    latitude: 55.40096,
                    longitude: 11.3628,
                    country: Country.findByCountryCode("DK"));

            adrSlagelse = adrSlagelse.save(flush: true)
        }

        // organizer
        Organizer torbenKruseOrganizer
        if (!Organizer.findByEmail("info@markedsbooking.dk")) {
            torbenKruseOrganizer = new Organizer(name: "Loppekompagniet ApS v/ Torben Kruse", email: "info@markedsbooking.dk", enableBooking: true)
            torbenKruseOrganizer = torbenKruseOrganizer.save(flush: true)
        }
        Organizer anonymousOrganizer
        if (!Organizer.findByEmail("mail@mail.dk")) {
            anonymousOrganizer = new Organizer(name: "anonymousOrganizer", email: "mail@mail.dk", enableBooking: false)
            anonymousOrganizer = anonymousOrganizer.save(flush: true)
        }

        // DateInterval
        boolean contiansfromDateBroenshoejTorv
        boolean contiansfromDateFarumArena
        boolean contiansfromDateFrederiksborghallen
        DateInterval.findAll().each { it ->
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy")
            String formatted = sdf.format(it.fromDate)
            if (formatted.equals("05-04-2014")) {
                contiansfromDateBroenshoejTorv = true
            }

            if (formatted.equals("22-02-2014")) {
                contiansfromDateFarumArena = true
            }

            if (formatted.equals("25-01-2014")) {
                contiansfromDateFrederiksborghallen = true
            }
        }

        DateInterval dateIntervalDateBroenshoejTorv
        if (!contiansfromDateBroenshoejTorv) {
            dateIntervalDateBroenshoejTorv = new DateInterval(fromDate: fromDateBroenshoejTorv.getTime(), toDate: toDateBroenshoejTorv.getTime())
            dateIntervalDateBroenshoejTorv = dateIntervalDateBroenshoejTorv.save(flush: true)
        }
        DateInterval dateIntervalFarumArena
        if (!contiansfromDateFarumArena) {
            dateIntervalFarumArena = new DateInterval(fromDate: fromDateFarumArena.getTime(), toDate: toDateFarumArena.getTime())
            dateIntervalFarumArena = dateIntervalFarumArena.save(flush: true)
        }
        DateInterval dateIntervalFrederiksborghallen

        if (!contiansfromDateFrederiksborghallen) {
            dateIntervalFrederiksborghallen = new DateInterval(fromDate: fromDateFrederiksborghallen.getTime(), toDate: toDateFrederiksborghallen.getTime())
            dateIntervalFrederiksborghallen = dateIntervalFrederiksborghallen.save(flush: true)
        }

        // coreMarkedItem
        if (!CoreMarkedItem.findByName("Brønshøj Torv")) {
            CoreMarkedItem coreMarkedItem = new CoreMarkedItem(name: "Brønshøj Torv",
                    entreInfo: 'Gratis adgang',
                    additionalOpenTimePeriod: 'Åbent fra 9 til 15',
                    markedRules: 'Loppemarkedet på Brønshøj torv er et loppemarked, hvor du kun kan købe brugte ting.',
                    markedInformation: 'Markedet er udendørs med 70 pladser',
                    enabled: true,
                    dateInterval: dateIntervalDateBroenshoejTorv,
                    address: adrBroenshoej,
                    organizer: torbenKruseOrganizer)
            coreMarkedItem.save(flush: true)
        }

        if (!CoreMarkedItem.findByName("Loppemarked i Farum Arena")) {
            CoreMarkedItem coreMarkedItem = new CoreMarkedItem(name: "Loppemarked i Farum Arena",
                    entreInfo: 'Entre 40,00 for voksne, børn under 12 år er gratis iflg. med en voksen.',
                    markedRules: 'Loppemarkedet i Farum Arena er et loppemarked, hvor der kun sælges brugt.',
                    additionalOpenTimePeriod: "Åbent begge dage fra 10 til 16.",
                    markedInformation: 'Der er 140 stader.',
                    enabled: true,
                    dateInterval: dateIntervalFarumArena,
                    address: adrFarum,
                    organizer: anonymousOrganizer)
            coreMarkedItem.save(flush: true)
        }


        if (!CoreMarkedItem.findByName("Loppemarked i Frederiksborghallen")) {
            CoreMarkedItem coreMarkedItem = new CoreMarkedItem(name: "Loppemarked i Frederiksborghallen",
                    entreInfo: 'Entre 40,00 for voksne, børn under 12 år gratis adgang iflg. med voksen.',
                    additionalOpenTimePeriod: "Åbent begge dage fra 10 til 16.",
                    markedRules: 'Loppemarkedet i Frederiksborghallen er et vaskeægte loppemarked, hvor der kun sælges gamle brugte ting.',
                    markedInformation: 'Der er over 160 stader, og markedet er indendørs. Du booker stade online på markedsbooking.dk',
                    enabled: true,
                    dateInterval: dateIntervalFrederiksborghallen,
                    address: adrHilleroed,
                    organizer: torbenKruseOrganizer)
            coreMarkedItem.save(flush: true)
        }

        if (!CoreMarkedItem.findByName("Loppe- og kræmmermarked i Slagelse")) {
            CoreMarkedItem coreMarkedItem = new CoreMarkedItem(name: "Loppe- og kræmmermarked i Slagelse",
                    entreInfo: '25 kr.',
                    additionalOpenTimePeriod: "kl. 10-15",
                    markedRules: 'ej beskrevet',
                    markedInformation: 'Markedet er en blanding af private "loppekræmmere" med behov for oprydning i gemmerne samt mere rutinerede loppekræmmere. hovedsageligt gammelt og brugt, men få stader med nye kvalitetseffekter. foregår i Slagelse Hallen',
                    enabled: true,
                    dateInterval: dateIntervalFrederiksborghallen,
                    address: adrSlagelse,
                    organizer: anonymousOrganizer)
            coreMarkedItem.save(flush: true)
        }



    }
    def destroy = {
    }
}
