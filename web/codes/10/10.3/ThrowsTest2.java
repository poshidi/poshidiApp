import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author poshidi
 * @date 2015/10/25
 * @link http://www.poshidi.com
 */
public class ThrowsTest2 {
    public static void main(String[] args) throws Exception{
        //��Ϊtest()���������׳�IOException�쳣
        //���Ե��ø÷����Ĵ���Ҫô����try...catch���У�
        //Ҫô������һ����throws�����׳��ķ�����
        test();
    }
    public static void test() throws IOException{
        //��ΪFileInputStream�Ĺ����������׳�IOException�쳣
        //���Ե���FileInputStream�Ĵ���Ҫô����try...catch����
        //Ҫô������һ����throws�����׳��ķ�����
        FileInputStream fis = new FileInputStream("a.txt");
    }
}
