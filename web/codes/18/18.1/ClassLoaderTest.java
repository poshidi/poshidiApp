/**
 * @author poshidi
 * @date 2015/11/7
 * @link http://www.poshidi.com
 */
class Tester{
    static{
        System.out.println("Tester类的静态初始化块...");
    }
}
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        //下面的语句仅仅是加载Tester类
        cl.loadClass("Tester");
        System.out.println("系统加载Tester类");
        //下面语句才会初始化Tester类
        Class.forName("Tester");
    }
}
