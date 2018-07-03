package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@RestController
@RequestMapping(value = "ip")
public class GetAddressController {

    @RequestMapping(value = "getaddress")
    public String getAddressByIP() {
        try {
            //测试ip 114.80.166.240
            String strIP = "192.168.1.103";
            URL url = new URL("http://ip.qq.com/cgi-bin/searchip?searchip1=" + strIP);
            URLConnection conn = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "GBK"));
            String line = null;
            StringBuffer result = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
            strIP = result.substring(result.indexOf("该IP所在地为："));
            strIP = strIP.substring(strIP.indexOf("：") + 1);
            String province = strIP.substring(6, strIP.indexOf("省"));
            String city = strIP.substring(strIP.indexOf("省") + 1, strIP.indexOf("市"));

        } catch (IOException e) {
            return "读取失败";
        }
       return null;
    }
}
