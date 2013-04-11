package loppemarkederadminapp

class MarkedItem {

    String name;
    String address;
    Date fromDate; // inclusive time
    Date toDate; // can be null
    String dateExtraInfo;
    String entreInfo;
    String markedRules;
    String markedInformation;
    BigDecimal latitude;
    BigDecimal longitude;

    static constraints = {
        name(size:1..50, maxSize: 50)
        address(size: 1..100, maxSize: 100)
        fromDate()
        toDate(nullable: true)
        dateExtraInfo(size:1..256)
        entreInfo(size:1..256)
        markedRules(size:1..256)
        markedInformation(size:1..256)
        latitude(scale: 9)
        longitude(scale: 9)
    }
}
