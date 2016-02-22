/**
 * Created by Administrator on 2016/2/2.
 */
//8������
//8.3.2 �ɱ䳤��ʵ���б�ʵ�ζ���
function f(x, y, z){
    //���ȣ���֤����ʵ�εĸ����Ƿ���ȷ
    if(arguments.length != 3){
        throw new Error("function f called with " + arguments.length +
        "arguments, but it expects 3 atguments.");
    }
    //��ִ�к����������߼�...
}

function max(/* ... */){
    var max = Number.NEGATIVE_INFINITY;
    //����ʵ�Σ����Ҳ���ס���ֵ
    for(var i = 0; i < arguments.length; i++)
        if(arguments[i] > max) max = arguments[i];
    //�������ֵ
    return max;
}
var largest = max(1, 10, 100, 2, 3, 1000, 4, 5, 10000, 6);  // => 10000

function f(x){
    console.log(x);         //���ʵ�εĳ�ʼֵ
    arguments[0] = null;    //�޸�ʵ�������Ԫ��ͬ�����޸�x��ֵ
    console.log(x);         //��� "null"
}

//callee��caller����
var factorial = function(x){
    if(x <= 1) return 1;
    return x * arguments.callee(x - 1);
}

//8.3.3
//���鸴�ƣ�����汾��ʵ��Ч����΢��Щ�ͣ����㲻����ȥ��סʵ�ε�˳��
//����from_start��to_start��Ĭ��Ϊ0
function easycopy(args){
    arraycopy(args.from,
              args.from_start || 0, //ע������������Ĭ��ֵ
              args.to,
              args.to_start || 0, args.length);
}
// ������ε���easycopy()
var a = [1, 2, 3, 4],   b = [];
easycopy({ from:a, to: b, length: 4});

//8.3.4
// �������飨�����������a��Ԫ�ص��ۼӺ�
// ����a�б���Ϊ���֡�null��undefined��Ԫ�ض�������
function sum(a){
    if(isArrayLike(a)){
        var total = 0;
        for(var i = 0; i < a.length; i++){  //��������Ԫ��
            var element = a[i];
            if(element == null) continue;   // ����null��undefined
            if(isFinite(element)) total += element;
            else throw new Error("sum(): elements must be finite numbers");
        }
        return total;
    }
    else throw new Error("sum(): argument must be array-like");
}