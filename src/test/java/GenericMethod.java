import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import org.apache.commons.io.IOUtils;
import org.junit.Test;


import java.io.IOException;
import java.nio.charset.Charset;

public class GenericMethod {

    @Test
    public void test(){
        String url = "https://restcountries.eu/rest/v1/all";
        String data = null;
        try{
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
            data = IOUtils.toString(response.getEntity().getContent(), Charset.forName("UTF-8"));
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

