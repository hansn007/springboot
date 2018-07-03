package com.example.demo.testip;


import java.io.*;

class DemoObject implements Serializable {
    int date = 23;
}
public class Test3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("/Users/huluwa/Desktop/123.txt")));
        oos.writeObject(new DemoObject());
        oos.flush();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("/Users/huluwa/Desktop/123.txt")));
        DemoObject newObject = (DemoObject)ois.readObject();
        System.out.println(newObject.date);
    }
}
