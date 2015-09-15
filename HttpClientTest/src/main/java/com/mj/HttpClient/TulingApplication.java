package com.mj.HttpClient;

import com.google.common.base.Strings;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static com.mj.HttpClient.HttpProcessor.getHttpResponse;
import static com.mj.HttpClient.PropertityFileHandler.get;

/**
 * Created by majun on 15/9/14.
 */
public class TulingApplication {

    public static String getJsonString(String input) {
        if(!Strings.isNullOrEmpty(input)){
            try {
                String param = get("apiUrl") + URLEncoder.encode(input, "utf-8");
                return getHttpResponse(param);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
