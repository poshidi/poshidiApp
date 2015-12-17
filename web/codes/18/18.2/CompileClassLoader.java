import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author poshidi
 * @date 2015/11/8
 * @link http://www.poshidi.com
 */
public class CompileClassLoader extends ClassLoader{
    //��ȡһ���ļ�������
    private byte[] getBytes(String filename) throws IOException{
        File file = new File(filename);
        long len = file.length();
        byte[] raw = new byte[(int) len];
        try(FileInputStream fin = new FileInputStream(file)){
            //һ�ζ�ȡclass�ļ���ȫ������������
            int r = fin.read(raw);
            if(r != len) throw new IOException("�޷���ȡȫ���ļ�:" + r + " != " + len);
            return raw;
        }
    }
    //�������ָ��Java�ļ��ķ���
    private boolean compile(String javaFile) throws IOException {
        System.out.println("CompileClassLoader:���ڱ���" + javaFile + "...");
        //����ϵͳ��javac����
        Process p = Runtime.getRuntime().exec("javac " + javaFile);
        try{
            //�����̶߳��ȴ�����߳����
            p.waitFor();
        }catch(InterruptedException ie){
            System.out.println(ie);
        }
        //��ȡjavac�̵߳��˳�ֵ
        int ret = p.exitValue();
        //���ر����Ƿ�ɹ�
        return ret == 0;
    }
    //��дClassLoader��findClass����
    protected Class<?> findClass(String name) throws ClassNotFoundException{
        Class clazz = null;
        //����·���еĵ�(.)�滻��б��(/)
        String fileStub = name.replace(".", "/");
        String javaFilename = fileStub + ".java";
        String classFilename = fileStub + ".class";
        File javaFile = new File(javaFilename);
        File classFile = new File(classFilename);
        //��ָ��JavaԴ�ļ����ڣ���Class�ļ������ڣ�����JavaԴ�ļ�
        //���޸�ʱ���Class�ļ����޸�ʱ��������±���
        if(javaFile.exists() && (!classFile.exists() || javaFile.lastModified() > classFile.lastModified())){
            try{
                //�������ʧ�ܣ����߸�Class�ļ�������
                if(!compile(javaFilename) || !classFile.exists()){
                    throw new ClassNotFoundException("ClassNotFoundException:" + javaFilename);
                }
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }
        //���Class�ļ����ڣ�ϵͳ���𽫸��ļ�ת����Class����
        if(classFile.exists()){
            try{
                //��Class�ļ��Ķ��������ݶ�������
                byte[] raw = getBytes(classFilename);
                //����ClassLoader��defineClass����������������ת����Class����
                clazz = defineClass(name, raw, 0, raw.length);
            }catch (IOException ie){
                ie.printStackTrace();
            }
        }
        //���clazzΪnull,��������ʧ�ܣ����׳��쳣
        if(clazz == null){
            throw new ClassNotFoundException(name);
        }
        return clazz;
    }
    //����һ��������
    public static void main(String[] args) throws Exception{
        //������иó���ʱû�в�������û��Ŀ����
        if(args.length < 1){
            System.out.println("ȱ��Ŀ���࣬�밴���¸�ʽ����JavaԴ�ļ���");
            System.out.println("java CompileClassLoader ClassName");
        }
        //��һ����������Ҫ���е���
        String progClass = args[0];
        //ʣ�µĲ�������Ϊ����Ŀ����ʱ�Ĳ���
        //����Щ�������Ƶ�һ����������
        String[] progArgs = new String[args.length-1];
        System.arraycopy(args, 1, progArgs, 0, progArgs.length);
        CompileClassLoader ccl = new CompileClassLoader();
        //������Ҫ���е���
        Class<?> clazz = ccl.loadClass(progClass);
        //��ȡ��Ҫ���е����������
        Method main = clazz.getMethod("main", (new String[0]).getClass());
        Object argsArray[] = {progArgs};
        main.invoke(null, argsArray);
    }
}
