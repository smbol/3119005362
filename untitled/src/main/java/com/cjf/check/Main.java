package com.cjf.check;

import java.io.*;
import java.text.DecimalFormat;

/**
 * @author junfu
 * @description
 * @date 2021/9/18 23:58
 */
public class Main {




    public static void main(String[] args) {

        File origin = new File(args[0]);
        File result = new File(args[2]);
        try {
            FileInputStream fisOrigin = new FileInputStream(origin);
            byte[] bytes= new byte[1024];
            int len1 = fisOrigin.read(bytes);
            String s1 = new String(bytes, 0, len1);
            FileWriter fwResult = new FileWriter(result,true);

            File other = new File(args[1]);
            FileInputStream fisOther = new FileInputStream(other);
            int len2 = fisOther.read(bytes);
            String s2 = new String(bytes, 0, len2);
            double similarity = FileUtil.getSimilarity(s1, s2);
            DecimalFormat decimalFormat = new DecimalFormat("0.00%");
            fwResult.write("原文本"+origin.getName()+"与抄袭文本"+other.getName()+"相似率为："+decimalFormat.format(similarity)+"\n");
            System.out.println("原文本的地址：" + args[0]);
            System.out.println("抄袭文的地址：" + args[1]);
            System.out.println("重复率为：" + decimalFormat.format(similarity));
            System.out.println("结果保存地址：" + result + "\n");

            fisOther.close();
            fisOrigin.close();
            fwResult.close();
        } catch (IOException e) {
            System.err.print("读写异常");
        }
    }
}
