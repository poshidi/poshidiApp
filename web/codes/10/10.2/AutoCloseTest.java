import java.io.*;

/**
 * @author poshidi
 * @date 2015/10/25
 * @link http://www.poshidi.com
 */
public class AutoCloseTest {
    public static void main(String[] args) throws IOException{
        try(
                //声明，初始化两个可关闭的资源
                //try语句会自动关闭着两个资源
                BufferedReader br = new BufferedReader(new FileReader("AutoCloseTest.java"));
                PrintStream ps = new PrintStream(new FileOutputStream("a.txt"))
        )
        {
            //使用两个资源
            System.out.println(br.readLine());
            ps.println("庄生晓梦迷蝴蝶");
        }

    }
}
