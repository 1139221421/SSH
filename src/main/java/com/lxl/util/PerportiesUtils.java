package com.lxl.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
    读取配置文件
 */
public class PerportiesUtils {

    public static Properties loadProperties(String path) {
        Properties properties = new Properties();
        InputStream input = null;
        try {
            input = PerportiesUtils.class.getClassLoader().getResourceAsStream(path);//加载Java项目根路径下的配置文件
            if (null != input) {
                properties.load(input);
                return properties;
            } else {
                return null;
            }
        } catch (IOException io) {
            io.printStackTrace();
            return null;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
