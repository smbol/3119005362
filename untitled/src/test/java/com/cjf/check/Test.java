package com.cjf.check;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author junfu
 * @description
 * @date 2021/9/19 1:06
 */
public class Test {

    //测试文件进行测试
    @org.junit.Test
    public void testCheck(){
        String origin = "E:\\project2021\\untitled\\src\\main\\resources\\static\\orig.txt";
        String result = "E:\\project2021\\untitled\\src\\main\\resources\\static\\result.txt";
        String[] sample = new String[]{
               "E:\\project2021\\untitled\\src\\main\\resources\\static\\orig_0.8_add.txt",
               "E:\\project2021\\untitled\\src\\main\\resources\\static\\orig_0.8_del.txt",
               "E:\\project2021\\untitled\\src\\main\\resources\\static\\orig_0.8_dis_1.txt",
               "E:\\project2021\\untitled\\src\\main\\resources\\static\\orig_0.8_dis_10.txt",
               "E:\\project2021\\untitled\\src\\main\\resources\\static\\orig_0.8_dis_15.txt"
        };
        for (String s : sample) {
            Main.main((String[]) Arrays.asList(origin,s,result).toArray());
        }
    }

    @org.junit.Test
    public void testNullOrinexistentFile(){
        String origin = "E:\\project2021\\untitled\\src\\main\\resources\\static\\orig.txt";
        String result = "E:\\project2021\\untitled\\src\\main\\resources\\static\\result.txt";
        String sample =  "E:\\project2021\\untitled\\src\\main\\resources\\static\\inexistent.txt";


        Main.main((String[]) Arrays.asList(origin,sample,result).toArray());

    }
}
