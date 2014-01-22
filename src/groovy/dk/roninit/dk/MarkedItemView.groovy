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


    public String getFromDateAsString() {
        getDateAsString(fromDate)
    }

    public String getToDateAsString() {
        getDateAsString(toDate)
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

    String toHtml() {
        StringBuilder sb = new StringBuilder(256)

        sb.append("<b>").append("Markeds Arrangør").append("</b>").append("</br>")
        sb.append("Navn :").append(organizerName).append("</br>")
        sb.append("E-mail :").append(organizerEmail).append("</br>")
        sb.append("Telefon nr. :").append(organizerPhone).append("</br>")
        sb.append("<b>").append("Markeds data").append("</b>").append("</br>")
        sb.append("Markedsnavn :").append(name).append("</br>")
        sb.append("Adresse :").append(address).append("</br>")
        sb.append("Fra dato :").append(getDateAsString(fromDate)).append("</br>")
        sb.append("Til dato :").append(getDateAsString(toDate)).append("</br>")
        sb.append("Evt. åbent tidsrum :").append(additionalOpenTimePeriod).append("</br>")
        sb.append("Entre pris :").append(entreInfo).append("</br>")
        sb.append("Regler :").append(markedRules).append("</br>")
        sb.append("Markeds information :").append(markedInformation).append("</br>")
        return sb.toString()
    }



    String getDateAsString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy")
        String formattedDate = sdf.format(date)
        return formattedDate
    }
}
