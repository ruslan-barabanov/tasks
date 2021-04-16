package testAutomationSelfEducation.util;

import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

public class FluentApi {

    public FluentApi() {
    }
    private final Properties properties = PathsProperties.readFile();
    private final String requestPost = properties.getProperty("requestPost.path");

    public String sendPostGetToken() throws IOException {
        int myVariant = 4;
        final Collection<NameValuePair> params = new ArrayList<>();
        final Content postResultForm = Request.Post(requestPost + myVariant)
                .bodyForm(params, Charset.defaultCharset())
                .execute().returnContent();
        String token = postResultForm.asString();
        return token;
    }
}