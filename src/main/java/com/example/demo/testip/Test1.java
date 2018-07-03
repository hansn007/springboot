package com.example.demo.testip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test1 {
    public static void main(String[] args) {
        File fil1 = new File("/Users/huluwa/Downloads/111.png");
        File fil2 = new File("/Users/huluwa/Downloads/333.png");
        try (FileInputStream fi = new FileInputStream(fil1);
             FileOutputStream fs = new FileOutputStream(fil2);
        ) {
            byte[] buf = new byte[521];
            int len = -1;
            while((len = fi.read(buf)) != -1){
                fs.write(buf, 0, len);
            }
            fs.flush();
        } catch (Exception e) {
        }

    }
}
