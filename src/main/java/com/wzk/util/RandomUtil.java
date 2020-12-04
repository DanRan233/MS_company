package com.wzk.util;

import java.util.Random;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description: TODO
 * @date 2020/11/22 14:19
 */
public class RandomUtil {

    private Random random = new Random();

    /**
     * description:获取指定长度的随机数字字符串
     * TODO:
     * @date         2020/11/22 14:26
     * @author      DanRan233
     * @Param       [len]
     * @return      java.lang.String
     */
    public String getStrRandom(int len) {
        String result = "";
        for(int i=0;i<len;i++){
            result += random.nextInt(10);
        }
        return result;
    }

    public static void main(String[] args) {
        RandomUtil randomUtil=new RandomUtil();
        //System.out.println(randomUtil.getStrRandom(6));
    }

}
