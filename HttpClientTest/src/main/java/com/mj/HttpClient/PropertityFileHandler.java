package com.mj.HttpClient;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertityFileHandler {

    //lazy initilize the, 第一次获取成功之后,再次获取,直接取出缓存,中的数据,无需继续执行匿名构造类的逻辑
    private static Supplier<Properties> memoize = Suppliers.memoize(new Supplier<Properties>() {
        public Properties get() {
           InputStream resourceAsStream = PropertityFileHandler.class.getResourceAsStream("/config.properties");
            Properties prop = new Properties();
            try {
                prop.load(resourceAsStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return prop;
        }
    });

    public static Object get(Object key){
        Properties properties = memoize.get();
        if(properties==null){
            System.out.println("文件初始化异常!!!");
        }
        return properties!=null?properties.get(key):null;
    }
}
