package com.poshidi.study.javase.reflect;

/**
 * @author poshidi
 * @date 2015/11/7
 * @link http://www.poshidi.com
 */
class MyTest{
    static{
        System.out.println("静态初始化块...");
    }
    //使用一个字符串直接量为static final Field赋值
//    static final String compileConstant = "疯狂Java讲义";
    static final String compileConstant = System.currentTimeMillis() + "";
}
public class CompileConstantTest {
    public static void main(String[] args) {
        //访问、输出MyTest中的compileConstant Field
        System.out.println(MyTest.compileConstant);
    }
}
