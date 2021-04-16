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

    Properties properties = new Properties();

    public String sendPostGetToken() throws IOException {
        final Collection<NameValuePair> params = new ArrayList<>();
        properties.load(ClassLoader.getSystemResourceAsStream("selfEducation.properties"));
        String requestPost = properties.getProperty("requestPost.path");
        final Content postResultForm = Request.Post(requestPost)
                .bodyForm(params, Charset.defaultCharset())
                .execute().returnContent();
        String token = postResultForm.asString();
        return token;
    }
}