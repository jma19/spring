package com.mj.HttpClient;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;


public class HttpProcessor {

    public static String getHttpResponse(String param) throws IOException {
        HttpGet request = new HttpGet(param);
        HttpResponse response = HttpClients.createDefault().execute(request);
        return EntityUtils.toString(response.getEntity());
    }
}
