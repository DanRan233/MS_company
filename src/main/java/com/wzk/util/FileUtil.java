package com.wzk.util;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description: 读取配置文件工具类 TODO
 * @date 2020/11/22 14:33
 */
public class FileUtil {

    /**
     * description：获取配置文件对应值。
     * TODO:
     * date         2020/11/22 14:47
     * @author      DanRan233
     * @Param       [keyWord]
     * @return      java.lang.String
     */
    public  String getProperties(String keyWord) {
        Properties prop = null;
        String value = null;
        try {
            // 通过Spring中的PropertiesLoaderUtils工具类进行获取
            prop = PropertiesLoaderUtils.loadAllProperties("settings.properties");
            // 根据关键字查询相应的值
            value = prop.getProperty(keyWord);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static void main(String[] args) {
//        FileUtil fileUtil=new FileUtil();
//        System.out.println(fileUtil.getProperties("accessKeyId"));
//        System.out.println(fileUtil.getProperties("accessKeySecret"));
    }
}
