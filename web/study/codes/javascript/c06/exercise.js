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

//6.6:����getter��setter
var p = {
    x:  1.0,
    y:  1.0,

    get r(){
        return Math.sqrt(this.x * this.x + this.y * this.y);
    },
    set r(newvalue){
        var oldvalue = Math.sqrt(this.x * this.x + this.y * this.y);
        var ratio = newvalue / oldvalue;
        this.x *= ratio;
        this.y *= ratio;
    },
    get theta(){
        return Math.atan2(this.y, this.x);
    }
};

//6.8.2
//��6-4: classof()����
function classof(o){
    if(o === null)  return "Null";
    if(o === undefined) return "Undefined";
    return Object.prototype.toString.call(0).slice(8,-1);
}