package dk.roninit.dk

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

    void setLatitude(BigDecimal latitude) {
        if(latitude==null) {
            latitude = new BigDecimal(0)
        }
        latitude.setScale(9)
        this.latitude = latitude
    }

    BigDecimal getLongitude() {
        return longitude
    }

    void setLongitude(BigDecimal longitude) {
        if(longitude==null) {
            longitude = new BigDecimal(0)
        }
        longitude.setScale(9)
        this.longitude = longitude
    }



    @Override
    public java.lang.String toString() {
        return "MarkedItemView{" +
                "name='" + name + '\'' +
                ", additionalOpenTimePeriod='" + additionalOpenTimePeriod + '\'' +
                ", entreInfo='" + entreInfo + '\'' +
                ", markedRules='" + markedRules + '\'' +
                ", markedInformation='" + markedInformation + '\'' +
                ", address='" + address + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", organizerName='" + organizerName + '\'' +
                ", organizerEmail='" + organizerEmail + '\'' +
                ", organizerPhone='" + organizerPhone + '\'' +
                '}';
    }
}
