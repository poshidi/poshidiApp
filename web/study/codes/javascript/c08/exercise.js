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

function flexisum(a){
    var total = 0;
    for(var i = 0; i < arguments.length; i++){
        var element = arguments[i], n;
        if(element == null) continue;   //����null��undefinedʵ��
        if(isArrayLike(element))    //���ʵ��������
            n = flexisum.apply(this, element);  //�ݹ�ؼ����ۼӺ�
        else if(typeof element === "function")  //��������Ǻ���...
            n = Number(element());  //��������������ת��
        else
            n = Number(element);    //����ֱ��������ת��
        if(isNaN(n))    //����޷�ת��Ϊ���֣����׳��쳣
            throw Error("flexisum():can't convert " + element + " to number");
        total += n; //���򣬽�n�ۼ���total
    }
    return total;
}

//��8-2: ����������ֵ
//�����ﶨ��һЩ�򵥵ĺ���
function add(x, y){
    return x + y;
}
function subtract(x, y){
    return x - y;
}
function multiply(x, y){
    return x * y;
}
function divide(x, y){
    return x / y;
}

// ����ĺ����������ĳ��������Ϊ����
// ��������������������Ȼ�������
function operate(operator, operand1, operand2){
    return operator(operand1, operand2);
}

//���д�����ʾ�ĺ�������ʵ���ϼ����� (2+3) + (4*5)��ֵ
var i = operate(add, operate(add, 2, 3), operate(multiply, 4, 5));

//����Ϊ��������ظ�ʵ��һ���򵥵ĺ���
//���ʵ��ʹ�ú���ֱ��������Щ����ֱ����������һ������ֱ������
var operators = {
    add: function(x, y){
        return x + y;
    },
    subtract: function(x, y){
        return x - y;
    },
    multiply: function(x, y){
        return x * y;
    },
    divide: function(x, y){
        return x / y;
    },
    pow: Math.pow //ʹ��Ԥ����ĺ���
};

// �����������һ��������Ϊ��������ڶ����в�����������
// Ȼ�������������ṩ�Ĳ�����
// ע���������������������﷨
function operate2(operation, operand1, operand2){
    if(typeof operators[operation] === "function")
        return operators[operation](operand1, operand2);
    else throw "Unknown operator";
}

// ���������� ("hello" + " " + "world") ��ֵ
var j = operate2("add", "hello", operate2("add", " ", "world"));
// ʹ��Ԥ����ĺ���Math.pow()
var k = operate("pow", 10, 2);

// ��ʼ����������ļ���������
// ���ں�����������ǰ�ˣ���������ǿ����ں�������
// ֮ǰ�����ĳ�Ա��ֵ��
uniqueInteger.counter = 0;

// ÿ�ε�������������᷵��һ����ͬ������
// ��ʹ��һ����������ס��һ�ν�Ҫ���ص�ֵ
function uniqueInteger(){
    return uniqueInteger.counter++; // �ȷ��ؼ�������ֵ��Ȼ�����������1
}

// ����׳ˣ��������������������������
function factorial(n){
    if(isFinite(n) && n > 0 && n == Math.round(n)){ //���޵�������
        if(!(n in factorial))       //���û�л�����
            factorial[n] = n * factorial(n - 1);    //������������֮
        return factorial[n];    // ���ػ�����
    }
    else return NaN;    // �����������
}
factorial[1] = 1;   // ��ʼ�������Ա������ֻ������

//��8-3: �ض������·��ش�������extend()�汾
// ����һ����չ�������������ڶ����Լ�����������������һ������
// �������Ǵ�����IE bug: �ڶ���IE�汾��
// ���o������ӵ��һ������ö�ٵ�ͬ�����ԣ���for/inѭ��
// ����ö�ٶ���o�Ŀ�ö�����ԣ�Ҳ����˵����������ȷ�ش�������toString������
// ����������ʽ�����
var extend = (function(){   // ����������ķ���ֵ���Ƹ�extend
    // ���޸���֮ǰ�����ȼ���Ƿ����bug
    for(var p in {toString: null}){
        // �������ִ�е������ôfor/inѭ������ȷ����������
        // һ���򵥰汾��extend()����
        return function extend(o){
            for(var i = 1; i < arguments.length; i++){
                var source = arguments[i];
                for(var prop in source) o[prop] = source[prop];
            }
            return o;
        };
    }
    // �������ִ�е����˵��for/inѭ������ö�ٲ��Զ����toString����
    // ��˷�����һ���汾��extend()���������������ʽ����
    // Object.prototype�еĲ���ö������
    return function pached_extend(o){
        for(var i = 1; i < arguments.length; i++){
            var source = arguments[i];
            //�������еĿ�ö������
            for(var prop in source) o[prop] = source[prop];

            //���ڼ����������
            for(var j = 0; j < protoprops.length; j++){
                prop = protoprops[j];
                if(source.hasOwnProperty(prop)) o[prop] = source[prop];
            }
        }
        return o;
    };
    // ����б��г�����Ҫ������������
    var protoprops = ["toString", "valueOf", "constructor", "hasOwnProperty",
                      "isPrototypeOf", "propertyIsEnumerable", "toLocaleString"];
})();

//8.6 �հ�
var scope = "global scope"; // ȫ�ֱ���
function checkscope(){
    var scope = "local scope";  // �ֲ�����
    function f(){
        return scope;   // ���������з������ֵ
    }
    return f();
}
checkscope()    // => "local scope"

var scope = "global scope"; // ȫ�ֱ���
function checkscope(){
    var scope = "local scope";  //�ֲ�����
    function f(){
        return scope;   // ���������з������ֵ
    }
    return f;
}
checkscope()(); // ����

//-----------------�ָ�
var uniqueInteger = (function(){    // ���庯������������
    var counter = 0;            // ������˽��״̬
    return function(){
        return counter++;
    }
}());