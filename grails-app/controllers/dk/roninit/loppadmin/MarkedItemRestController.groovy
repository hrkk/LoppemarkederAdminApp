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

    def saveJSONIPhone(MarkedItemView view) {
        log.info(view)
        if(!view.latitude || !view.longitude )  {
            sendMailManuelIphone(view, "Iphone", "Manuel!")
            render status: HttpStatus.OK
        } else {
            saveJSON(view, "Iphone")
        }
    }

    def saveJSON(MarkedItemView view, def mobilePlatform) {
            log.info(view)
            try {
            // organizer
            Organizer organizer = Organizer.findByEmail(view.organizerEmail)
            if (!organizer) {
                organizer = new Organizer(name: view.organizerName
                        , email: view.organizerEmail
                        , phone: view.organizerPhone
                        , enableBooking: false)
                organizer = organizer.save(flush: true, failOnError: true)
            }
            // Address
            Address address = Address.findByAddressLine1(view.getAddress())
            if (!address && view.longitude != 0.0d && view.latitude != 0.0d || (address != null && address.longitude != view.longitude && address.latitude != view.latitude)) {
                address = new Address(addressLine1: view.address,
                        latitude: view.latitude,
                        longitude: view.longitude,
                        country: Country.findByCountryCode("DK"));

                address = address.save(flush: true, failOnError: true)
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
                dateInterval = dateInterval.save(flush: true, failOnError: true)
            }

            // should I check that the marked is already exists
            boolean contiansDateInterval
            boolean isSameAddress
            CoreMarkedItem coreMarkedItem1 = CoreMarkedItem.findByName(view.name)
            if (coreMarkedItem1) {
                // check at dateInterval er forskelligt
                coreMarkedItem1.dateInterval.each { it ->
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy")
                    String fromDateFormatted = sdf.format(it.fromDate)
                    String toDateFormatted = sdf.format(it.toDate)

                    if (fromDateFormatted.equals(sdf.format(view.fromDate)) && toDateFormatted.equals(sdf.format(view.toDate))) {
                        contiansDateInterval = true
                    }
                }
                coreMarkedItem1.address
                if (coreMarkedItem1.address != null && coreMarkedItem1.address.longitude == view.longitude && coreMarkedItem1.address.latitude == view.latitude) {
                    isSameAddress = true
                }
            }

            // marked exist with the same name but not with the date interval - add date interval
            if (coreMarkedItem1 && !contiansDateInterval && isSameAddress) {
                def intervalSet = coreMarkedItem1.dateInterval
                intervalSet.add(dateInterval)

                coreMarkedItem1.save(flush: true, failOnError: true)
                sendMyMail(coreMarkedItem1, view, "Dato interval tilføjet til marked", mobilePlatform)
            }

            // marked does not exist
            if (!coreMarkedItem1) {
                CoreMarkedItem coreMarkedItem = new CoreMarkedItem(name: view.name,
                        entreInfo: view.entreInfo,
                        additionalOpenTimePeriod: view.additionalOpenTimePeriod,
                        markedRules: view.markedRules,
                        markedInformation: view.markedInformation,
                        enabled: true,
                        dateInterval: dateInterval,
                        address: address,
                        organizer: organizer)
                coreMarkedItem.save(flush: true, failOnError: true)
                sendMyMail(coreMarkedItem, view, "Nyt marked oprettet", mobilePlatform)
            }
            } catch (Exception e) {
                sendMailManuel(view, mobilePlatform, e.getMessage())
                log.error "Error: ${e.message}", e
                render status: HttpStatus.INTERNAL_SERVER_ERROR
            }
        render status: HttpStatus.OK
    }

    private void sendMyMail(CoreMarkedItem coreMarkedItem, MarkedItemView view, def mailSubject, def mobilePlatform) {
        mailService.sendMail {
            to "info@markedsbooking.dk", "markedsbooking@gmail.com"
            //to "markedsbooking@gmail.com"
            subject mailSubject + " fra en ${mobilePlatform}"
            html g.render(model: [marked: coreMarkedItem, view: view], template: "markedMailTemplate")
        }
    }

    private void sendMailManuel(MarkedItemView view, def mobilePlatform, def strackTrace) {
        mailService.sendMail {
            to "info@markedsbooking.dk", "markedsbooking@gmail.com"
            //to "markedsbooking@gmail.com"
            subject "Fejl ved oprettelse af nyt marked oprettet fra en ${mobilePlatform}"
            html g.render(model: [view: view, strackTrace: strackTrace], template: "markedMailManuelTemplate")
        }
    }

    private void sendMailManuelIphone(MarkedItemView view, def mobilePlatform, def strackTrace) {
        mailService.sendMail {
            to "info@markedsbooking.dk", "markedsbooking@gmail.com"
            //to "markedsbooking@gmail.com"
            subject "Nyt marked til manuel oprettelse, oprettet fra en ${mobilePlatform}"
            html g.render(model: [view: view, strackTrace: strackTrace], template: "markedMailManuelTemplate")
        }
    }

    private void sendMailTestIphone(MarkedItemView view, def mobilePlatform, def strackTrace) {
        mailService.sendMail {
            to "markedsbooking@gmail.com"
            subject "Test af automatisk oprettelse - oprettet fra en ${mobilePlatform}"
            html g.render(model: [view: view, strackTrace: strackTrace], template: "markedMailManuelTemplate")
        }
    }
}
