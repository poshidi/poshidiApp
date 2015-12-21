package c03;

/**
 * Created by Administrator on 2015/12/21.
 */
public class WhileTest {
    public static void main(String[] args) {
        double r = 0;
        while(r < 0.99d){
            r = Math.random();
            System.out.println(r);
        }
    }
}
