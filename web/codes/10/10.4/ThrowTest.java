/**
 * @author poshidi
 * @date 2015/10/25
 * @link http://www.poshidi.com
 */
public class ThrowTest {
    public static void main(String[] args){
        try{
            //���������׳�Checked�쳣�ķ�����Ҫô��ʾ������쳣
            //Ҫô��main�������ٴ������׳�
            throwChecked(-3);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        //���������׳�Runtime�쳣�ķ����ȿ�����ʽ������쳣
        //Ҳ�ɲ������쳣
        throwRuntime(3);
    }
    public static void throwChecked(int a) throws Exception{
        if(a > 0){
            //�����׳�Exception�쳣
            //�ô�����봦��try������ڴ�throws�����ķ�����
            throw new Exception("a��ֵ����0��������Ҫ��");
        }
    }
    public static void throwRuntime(int a){
        if(a > 0){
            //�����׳�RuntimeException�쳣����������ʽ������쳣
            //Ҳ����ȫ�������쳣���Ѹ��쳣�����÷��������ߴ���
            throw new RuntimeException("a��ֵ����0��������Ҫ��");
        }
    }
}
