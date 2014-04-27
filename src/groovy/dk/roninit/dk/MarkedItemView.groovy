package dk.roninit.dk

import java.text.SimpleDateFormat

class MarkedItemView {
    String name
    String additionalOpenTimePeriod
    String entreInfo
    String markedRules
    String markedInformation

    String address
    Date fromDate
    Date toDate

    BigDecimal latitude
    BigDecimal longitude

    // organizer
    String organizerName
    String organizerEmail
    String organizerPhone

    BigDecimal getLatitude() {
        return latitude
    }

    public String getFromDateAsString() {
        getDateAsString(fromDate)
    }

    public String getToDateAsString() {
        getDateAsString(toDate)
    }

    String getDateAsString(Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy")
            String formattedDate = sdf.format(date)
            return formattedDate
        }
        return "";
    }

    def getName() {
        danishCharFix(name)
    }

    def getAdditionalOpenTimePeriod() {
        danishCharFix(additionalOpenTimePeriod)
    }

    def getAddress() {
        danishCharFix(address)
    }

    def getEntreInfo() {
        danishCharFix(entreInfo)
    }

    def getMarkedRules() {
        danishCharFix(markedRules)
    }

    def getMarkedInformation() {
        danishCharFix(markedInformation)
    }

    def getOrganizerName() {
        danishCharFix(organizerName)
    }

    @Override
    public java.lang.String toString() {
        return "MarkedItemView{" +
                "name='" + getName() + '\'' +
                ", additionalOpenTimePeriod='" + getAdditionalOpenTimePeriod() + '\'' +
                ", entreInfo='" + getEntreInfo() + '\'' +
                ", markedRules='" + getMarkedRules() + '\'' +
                ", markedInformation='" + getMarkedInformation() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", organizerName='" + getOrganizerName() + '\'' +
                ", organizerEmail='" + organizerEmail + '\'' +
                ", organizerPhone='" + organizerPhone + '\'' +
                '}';
    }

    private String danishCharFix(String w) {
        if(w!= null) {
            return w.replaceAll("::OE::", "Ø").replaceAll("::AE::", "Æ").replaceAll("::AA::", "Å").replaceAll("::oe::", "ø").replaceAll("::ae::", "æ").replaceAll("::aa::", "å")
        }
        return w
    }
}
