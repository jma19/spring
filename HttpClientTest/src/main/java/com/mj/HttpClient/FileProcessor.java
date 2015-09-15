package com.mj.HttpClient;

import java.io.*;

/**
 * Created by majun on 15/9/15.
 */
public class FileProcessor {
    public static String getContext(String filePath){
        StringBuffer stringBuffer = new StringBuffer();
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(filePath));
            String result;
            while ((result=bufferedReader.readLine())!=null){
                stringBuffer.append(result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    public static String getContext(){
        File file = new File("");
        return null;
    }
}
