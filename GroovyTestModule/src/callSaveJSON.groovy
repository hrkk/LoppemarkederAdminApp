import org.apache.commons.httpclient.HttpClient
import org.apache.commons.httpclient.methods.PostMethod
import org.apache.commons.httpclient.methods.StringRequestEntity


def method = new PostMethod("http://localhost:8080/LoppemarkederAdminApp/markedItemRest/saveJSON")
def client = new HttpClient()


String JSON_STRING = "{\"class\":\"grailsrest.PersonView\",\"name\":\"heps\"}"

StringRequestEntity requestEntity = new StringRequestEntity(
        JSON_STRING,
        "application/json",
        "UTF-8");



method.setRequestEntity(requestEntity)

int statusCode = client.executeMethod(method);


println "hello world! ${statusCode}"