package com.poshidi.study.thinkinjava;

/**
 * Created by Administrator on 2015/12/21.
 */
public class Literals {
    public static void main(String[] args) {
        char c = 0xffff;    // max char hex value
        byte b = 0x7f;  //max byte hex value
        short s = 0x7fff;   //max short hex value
        int i1 = 0x2f;  //Hexadecimal (lowercase)
        int i2 = 0X2F; //Hexadecimal (uppercase)
        int i3 = 0177; //0ctal (leading zero)
        //Hex and 0ct also work with long.
        long n1 = 200L; //long suffix
        long n2 = 200l; //long suffix
        long n3 = 200;
        //! long 16(200); //not allowed
        float f1 = 1;
        float f2 = 1F; //float suffix
        float f3 = 1f; //float fuffix
        float f4 = 1e-45f; //10 to the power
        float f5 = 1e+9f; //float suffix
        double d1 = 1d; //double suffix
        double d2 = 1D; //double suffix
        double d3 = 47e47d; //10 to the power
        System.out.println(n2);
    }

}
