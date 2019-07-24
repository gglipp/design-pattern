package com.panlijun;

import ch.qos.logback.classic.util.StatusViaSLF4JLoggerFactory;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @author panlijun
 */
public class Client {

    private static Logger logger = LoggerFactory.getLogger(Client.class);

    public static void createHttpClientBak() throws URISyntaxException {
        URI uri = new URIBuilder().setScheme("https")
                .setHost("admin.shunkt.com")
                .setPath("/API/APISHJSON")
                .addParameter("data", "dataValue")
                .addParameter("sign", "signValue")
                .build();
        HttpGet httpGet = new HttpGet(uri);
        String msg = httpGet.getURI().toString();
        logger.info(msg);
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            CloseableHttpResponse response = client.execute(httpGet);
            String s = EntityUtils.toString(response.getEntity());
            logger.info(s);
        } catch (ClientProtocolException e) {
            logger.error("client protocol exception", e);
        } catch (IOException e) {
            logger.error("ioException", e);
        }
    }


    private HttpClient createDefaultHttpClient(){
        return HttpClients.createDefault();
    }

    public CloseableHttpClient createSSLHttpClient() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
            @Override
            public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                return true;
            }
        }).build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

//        return HttpClients.custom().setSSLContext(sslContext).build();
//        return HttpClients.custom().setSSLSocketFactory(new SSLConnectionSocketFactory(sslContext)).build();
        return HttpClients.custom().setSSLSocketFactory(sslsf).build();
    }





}
