/**
 * Created by Administrator on 2016/1/13.
 */
//5.6.5 throw ���
function factorial(x){
    //�����������ǷǷ��ģ����׳�һ���쳣
    if(x < 0)   throw new Error("x�����Ǹ���");
    //���򣬼����һ��ֵ���������ط�����
    for(var f = 1; x > 1; f *= x, x--)  /* empty */
    return f;
}

//5.7.1 with���
with(document.forms[0]){
    //  ֱ�ӷ��ʱ�Ԫ�أ����磺
    name.value = "";
    address.value = "";
    email.value = "";
}

//5.7.2 debugger���
function f(o){
    if(o === undefined) debugger;   //��һ�д���ֻ��������ʱ����
    //...   //��������������
}