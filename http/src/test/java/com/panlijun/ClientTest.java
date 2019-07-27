package com.panlijun;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import static org.assertj.core.api.Assertions.*;

public class ClientTest {

    Logger logger = LoggerFactory.getLogger(ClientTest.class);

    @Test
    public void ssl() throws URISyntaxException {
        URI uri = new URIBuilder().setScheme("https")
                .setHost("admin.shunkt.com")
                .setPath("/API/APISHJSON")
                .addParameter("data", "dataValue")
                .addParameter("sign", "signValue")
                .build();
        HttpGet httpGet = new HttpGet(uri);
        String msg = httpGet.getURI().toString();
        logger.info(msg);

        try (CloseableHttpClient client = new Client().createDefaultHttpClient()) {
            CloseableHttpResponse response = client.execute(httpGet);
            String s = EntityUtils.toString(response.getEntity());
            logger.info(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
