package dk.roninit.loppadmin

import grails.rest.RestfulController

class MarkedItemRestController extends RestfulController {
    static responseFormats = ['json', 'xml']

    MarkedItemRestController() {
        super()
    }


    def saveJSON() {
        println "save!!!"

    }
}
