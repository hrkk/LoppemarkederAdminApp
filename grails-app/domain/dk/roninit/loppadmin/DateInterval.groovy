package dk.roninit.loppadmin

import java.text.SimpleDateFormat

class DateInterval extends BasicEntity {
    private static final String DATE_FORMAT = "dd-MM-yyyy";
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

    Date fromDate
    Date toDate

    static constraints = {
        fromDate blank: false
        toDate blank: false
    }

    def beforeInsert() {
        super.superBeforeInsert()
    }

    def beforeUpdate() {
        super.superBeforeUpdate()
    }


    @Override
    public java.lang.String toString() {
        return sdf.format(fromDate) + " - " + sdf.format(toDate);
    }
}
