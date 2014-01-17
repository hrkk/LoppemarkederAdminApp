package dk.roninit.loppadmin

import dk.roninit.dk.MarkedItemView
import grails.rest.RestfulController
import org.springframework.http.HttpStatus
import org.springframework.mail.MailSender

import java.text.SimpleDateFormat

class MarkedItemRestController extends RestfulController {

    def mailService

    static responseFormats = ['json', 'xml']

    MarkedItemRestController() {
        super(MarkedItemView)
    }

    def saveJSONAndroid(MarkedItemView view) {
        saveJSON(view, "Android")
    }
    def saveJSON(MarkedItemView view, def mobilePlatform) {
        // Address
        Address address   = Address.findByAddressLine1(view.getAddress())
        if (!address || (address != null && address.longitude != view.longitude && address.latitude != view.latitude)) {
            address = new Address(addressLine1: view.address,
                    latitude: view.latitude,
                    longitude: view.longitude,
                    country: Country.findByCountryCode("DK"));

            address = address.save(flush: true)
        }

        // organizer
        Organizer organizer    = Organizer.findByEmail(view.organizerEmail)
        if (!organizer) {
            organizer = new Organizer(name: view.organizerName, email: view.organizerEmail, phone: view.organizerPhone, enableBooking: false)
            organizer = organizer.save(flush: true)
        }

        DateInterval dateInterval

        DateInterval.findAll().each { it ->
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy")
            String fromDateFormatted = sdf.format(it.fromDate)
            String toDateFormatted = sdf.format(it.toDate)

            if (fromDateFormatted.equals(sdf.format(view.fromDate)) && toDateFormatted.equals(sdf.format(view.toDate))) {
                dateInterval = it
            }
        }

        if (!dateInterval) {
            dateInterval = new DateInterval(fromDate: view.fromDate.getTime(), toDate: view.toDate.getTime())
            dateInterval = dateInterval.save(flush: true)
        }

        // should I check that the marked is already exists
        boolean contiansDateInterval
        boolean isSameAddress
        CoreMarkedItem coreMarkedItem1  = CoreMarkedItem.findByName(view.name)
        if(coreMarkedItem1) {
            // check at dateInterval er forskelligt
            coreMarkedItem1.dateInterval.each {   it ->
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy")
                String fromDateFormatted = sdf.format(it.fromDate)
                String toDateFormatted = sdf.format(it.toDate)

                if (fromDateFormatted.equals(sdf.format(view.fromDate)) && toDateFormatted.equals(sdf.format(view.toDate))) {
                    contiansDateInterval = true
                }
            }
            coreMarkedItem1.address
            if ( coreMarkedItem1.address != null &&  coreMarkedItem1.address.longitude == view.longitude &&  coreMarkedItem1.address.latitude == view.latitude) {
                isSameAddress = true
            }
        }

        // marked exist with the same name but not with the date interval - add date interval
        if (coreMarkedItem1 && !contiansDateInterval && isSameAddress) {
            def intervalSet = coreMarkedItem1.dateInterval
            intervalSet.add(dateInterval)

            coreMarkedItem1.save(flush: true)
            sendMyMail(coreMarkedItem1, "Dato interval tilføjet til marked", mobilePlatform)
        }

        // marked does not exist
        if(!coreMarkedItem1) {
            CoreMarkedItem coreMarkedItem = new CoreMarkedItem(name: view.name,
                    entreInfo: view.entreInfo,
                    additionalOpenTimePeriod: view.additionalOpenTimePeriod,
                    markedRules: view.markedRules,
                    markedInformation: view.markedInformation,
                    enabled: true,
                    dateInterval: dateInterval,
                    address: address,
                    organizer: organizer)
            coreMarkedItem.save(flush: true)
            sendMyMail(coreMarkedItem, "Nyt marked oprettet", mobilePlatform)
        }
        render status: HttpStatus.OK
    }

    def sendMyMail( CoreMarkedItem coreMarkedItem,  def mailSubject, def mobilePlatform) {
        mailService.sendMail {
            to "kasper.odgaard@gmail.com", "markedsbooking@gmail.com"
            subject mailSubject + " fra en ${mobilePlatform}"
            html g.render(model: [marked: coreMarkedItem], template: "markedMailTemplate")
        }
    }
}
