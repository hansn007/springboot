package com.example.demo.testip;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListenner implements HttpSessionListener{
    private int userNumber = 0;
    public void sessionCreated(HttpSessionEvent arg0) {
        userNumber++;
        arg0.getSession().setAttribute("userNumber", userNumber);
    }
    public void sessionDestroyed(HttpSessionEvent arg0) {
        userNumber--;
        arg0.getSession().setAttribute("userNumber", userNumber);
    }
}
