package dk.roninit.loppadmin

import dk.roninit.dk.MarkedItemView
import grails.rest.RestfulController
import org.springframework.http.HttpStatus

class MarkedItemRestController extends RestfulController {
    static responseFormats = ['json', 'xml']

    MarkedItemRestController() {
        super(MarkedItemView)
    }


    def saveJSON(MarkedItemView view) {
        println "save!!! " + view

        // Address
        Address address   = Address.findByAddressLine1(view.getAddress())
        if (!address || (address != null && address.longitude != view.longitude && address.latitude != view.latitude)) {
            address = new Address(addressLine1: view.address,
                    latitude: view.latitude,
                    longitude: view.longitude,
                    country: Country.findByCountryCode("DK"));

            address = address.save(flush: true)
        }



        render status: HttpStatus.OK
    }
}
