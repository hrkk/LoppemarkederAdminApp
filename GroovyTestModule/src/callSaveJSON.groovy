import org.apache.commons.httpclient.HttpClient
import org.apache.commons.httpclient.methods.PostMethod
import org.apache.commons.httpclient.methods.StringRequestEntity
import org.json.simple.JSONObject

import java.text.SimpleDateFormat


def method = new PostMethod("http://localhost:8080/LoppemarkederAdminApp/markedItemRest/saveJSONAndroid")
def client = new HttpClient()

JSONObject fromDateJSONObj = new JSONObject();


fromDateJSONObj.put("latitude",BigDecimal.valueOf(111.123456));

println fromDateJSONObj.toJSONString()

SimpleDateFormat formatter = new SimpleDateFormat(
        "yyyy-MM-dd'T'HH:mm:ss'Z'"); // 2013-04-10T04:00:00Z
def fromDate = formatter.format(new Date())
Calendar cal = Calendar.getInstance()
cal.setTime(new Date())
cal.add(Calendar.DATE,1)
def toDate = formatter.format(cal.getTime())

String JSON_STRING = "{\"class\":\" dk.roninit.dk.MarkedItemView\"" +
        ",\"name\":\"JSON marked3\"" +
        ",\"additionalOpenTimePeriod\":\"JSON har altid åbent\"" +
        ",\"entreInfo\":\"JSON entreInfo\"" +
        ",\"markedRules\":\"JSON markedRules\"" +
        ",\"markedInformation\":\"JSON markedInformation\"" +
        ",\"address\":\"JSON address\"" +
        ",\"fromDate\":\"${fromDate}\"" +
        ",\"toDate\":\"${toDate}\"" +
    //    ",\"latitude\":${BigDecimal.valueOf(111.123451)}" +
    //    ",\"longitude\":${BigDecimal.valueOf(91.000002)}" +
        ",\"organizerName\":\"JSON organizerName\"" +
        ",\"organizerEmail\":\"json@mail.dk\"" +
        ",\"organizerPhone\":\"12345678\"" +
        "}"

println JSON_STRING

StringRequestEntity requestEntity = new StringRequestEntity(
        JSON_STRING,
        "application/json",
        "UTF-8");



method.setRequestEntity(requestEntity)

int statusCode = client.executeMethod(method);


println "hello world! ${statusCode}"