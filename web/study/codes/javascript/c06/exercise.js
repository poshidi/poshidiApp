/**
 * Created by Administrator on 2016/1/15.
 */
//6-1:ͨ��ԭ�ͼ��ɴ���һ���¶���
//  inherit() ������һ��������ԭ�Ͷ���p�����Ե��¶���
//  ����ʹ��ECMAScript 5�е�Object.create()���� (������ڵĻ�)
//  ���������Object.create(), ���˻�ʹ����������
function inherit(p){
    if(p == null)   throw TypeError();  // p��һ�����󣬵�������null
    if(Object.create)
        return Object.create(p);
    var t = typeof p;
    if(t !== "object" && t !== "function")  throw TypeError();
    function f(){};
    f.prototype = p;
    return new f();
}