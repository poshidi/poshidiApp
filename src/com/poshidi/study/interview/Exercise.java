package com.poshidi.study.interview;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2016/1/12.
 */
//http://www.cnblogs.com/lanxuezaipiao/p/3371224.html
//精选30道Java笔试题解答
public class Exercise {
}

//6
class Exe01{
    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run() {
                pong();
            }
        };
        t.run();
        //t.start();
        System.out.print("ping");
    }

    static void pong() {
        System.out.print("pong");
    }
}

//3
class Exe02{
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.err.println(str1 == str2);
    }
}

//11
class Exe03{
    public static void main(String[] args) {
//        float i = 0, j = 0;
        float i = Float.NaN, j = 0;
        if(i > j || i <= j){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}

//12
class Exe04{
    public static void main(String[] args) {

    }
}

//19
class NULL {

    public static void haha(){
        System.out.println("haha");
    }
    public static void main(String[] args) {
        ((NULL)null).haha();
    }

}

//20
class HelloA {

    public HelloA() {
        System.out.println("HelloA");
    }

    { System.out.println("I'm A class"); }

    static { System.out.println("static A"); }

}

class HelloB extends HelloA {
    public HelloB() {
        System.out.println("HelloB");
    }

    { System.out.println("I'm B class"); }

    static { System.out.println("static B"); }

    public static void main(String[] args) {
//        new HelloB();
        System.out.println("-------main start-------");
        new HelloB();
        new HelloB();
        System.out.println("-------main end-------");
    }
}

//21
class Exe05{
    public static void getCustomerInfo() {

        try {

            // do something that may cause an Exception
            throw new IOException();

        } catch (java.io.FileNotFoundException ex) {

            System.out.print("FileNotFoundException!");

        } catch (java.io.IOException ex) {

            System.out.print("IOException!");

        } catch (java.lang.Exception ex) {

            System.out.print("Exception!");

        }

    }

    public static void main(String[] args) {
        getCustomerInfo();
    }
}

//22
class Foo{
    public static void main(String[] args) {
//        String s;
        String s = null;
        System.out.println("s=" + s);
        String s1;
        String s2 = null;
        String s3 = "";
    }
}

//24
class Example {

    String str = new String("good");

    char[] ch = { 'a', 'b', 'c' };

    public static void main(String args[]) {

        Example ex = new Example();

        ex.change(ex.str, ex.ch);

        System.out.print(ex.str + " and ");

        System.out.print(ex.ch);

    }

    public void change(String str, char ch[]) {

        str = "test ok";

        ch[0] = 'g';

    }
}

//25
class FileStreamTest {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        FileOutputStream out = new FileOutputStream("file.dat");

        byte[] b = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        out.write(b);
        out.close();

        FileInputStream in = new FileInputStream("file.dat");
        in.skip(9); // 跳过前面的9个字节
        int c = in.read();
        System.out.println(c);  // 输出为10
        in.close();
    }

}


