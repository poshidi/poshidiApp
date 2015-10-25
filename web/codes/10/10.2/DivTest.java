/**
 * @author poshidi
 * @date 2015/10/25
 * @link http://www.poshidi.com
 */
public class DivTest {
    public static void main(String[] args){
        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c = a / b;
            System.out.println("�����������������Ľ����:" + c);
        }
        catch (IndexOutOfBoundsException ie){
            System.out.println("����Խ�磺���г���ʱ����Ĳ�����������");
        }
        catch (NumberFormatException ne){
            System.out.println("���ָ�ʽ�쳣������ֻ�ܽ�����������");
        }
        catch (ArithmeticException ae){
            System.out.println("�����쳣");
        }
        catch (Exception e){
            System.out.println("δ֪�쳣");
        }
    }
}
