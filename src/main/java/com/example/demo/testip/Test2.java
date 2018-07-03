package com.example.demo.testip;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Test2 {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/huluwa/Desktop/123.txt ");
        //复制源文件
        File file2 = new File("/Users/huluwa/Desktop/456.txt ");
        //复制结果文件
        StringBuffer sb = new StringBuffer();
        //用于输出到控制台
        if(!file2.exists()){
            file2.createNewFile();
        }
        FileReader fr = new FileReader(file);
        FileWriter fw = new FileWriter(file2);
        char[] ch = new char[256];
        int len = -1;
        while((len = fr.read(ch)) != -1){
            fw.write(ch, 0, ch.length);
            sb.append(new String(ch, 0, ch.length));
        }
        fw.flush();
        fw.close();
        fr.close();
        System.out.println(sb.toString());
    }
}
