/**
 * Created by Administrator on 2016/2/2.
 */
//8、函数
//8.3.2 可变长的实参列表：实参对象
function f(x, y, z){
    //首先，验证传入实参的个数是否正确
    if(arguments.length != 3){
        throw new Error("function f called with " + arguments.length +
        "arguments, but it expects 3 atguments.");
    }
    //再执行函数的其他逻辑...
}

function max(/* ... */){
    var max = Number.NEGATIVE_INFINITY;
    //遍历实参，查找并记住最大值
    for(var i = 0; i < arguments.length; i++)
        if(arguments[i] > max) max = arguments[i];
    //返回最大值
    return max;
}
var largest = max(1, 10, 100, 2, 3, 1000, 4, 5, 10000, 6);  // => 10000

function f(x){
    console.log(x);         //输出实参的初始值
    arguments[0] = null;    //修改实参数组的元素同样会修改x的值
    console.log(x);         //输出 "null"
}

//callee和caller属性
var factorial = function(x){
    if(x <= 1) return 1;
    return x * arguments.callee(x - 1);
}

//8.3.3
//数组复制，这个版本的实现效率稍微有些低，但你不必再去记住实参的顺序
//并且from_start和to_start都默认为0
function easycopy(args){
    arraycopy(args.from,
              args.from_start || 0, //注意这里设置了默认值
              args.to,
              args.to_start || 0, args.length);
}
// 来看如何调用easycopy()
var a = [1, 2, 3, 4],   b = [];
easycopy({ from:a, to: b, length: 4});

//8.3.4
// 返回数组（或类数组对象）a的元素的累加和
// 数组a中必须为数字、null和undefined的元素都将忽略
function sum(a){
    if(isArrayLike(a)){
        var total = 0;
        for(var i = 0; i < a.length; i++){  //遍历所有元素
            var element = a[i];
            if(element == null) continue;   // 跳过null和undefined
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
        if(element == null) continue;   //忽略null和undefined实参
        if(isArrayLike(element))    //如果实参是数组
            n = flexisum.apply(this, element);  //递归地计算累加和
        else if(typeof element === "function")  //否则，如果是函数...
            n = Number(element());  //调用它并做类型转换
        else
            n = Number(element);    //否则直接做类型转换
        if(isNaN(n))    //如果无法转换为数字，则抛出异常
            throw Error("flexisum():can't convert " + element + " to number");
        total += n; //否则，将n累加至total
    }
    return total;
}

//例8-2: 将函数用做值
//在这里定义一些简单的函数
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

// 这里的函数以上面的某个函数作为参数
// 并给它传入两个操作数然后调用它
function operate(operator, operand1, operand2){
    return operator(operand1, operand2);
}

//这行代码所示的函数调用实际上计算了 (2+3) + (4*5)的值
var i = operate(add, operate(add, 2, 3), operate(multiply, 4, 5));

//我们为这个例子重复实现一个简单的函数
//这次实现使用函数直接量，这些函数直接量定义在一个对象直接量中
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
    pow: Math.pow //使用预定义的函数
};

// 这个函数接收一个名字作为运算符，在对象中查找这个运算符
// 然后将它作用于所提供的操作数
// 注意这里调用运算符函数的语法
function operate2(operation, operand1, operand2){
    if(typeof operators[operation] === "function")
        return operators[operation](operand1, operand2);
    else throw "Unknown operator";
}

// 这样来计算 ("hello" + " " + "world") 的值
var j = operate2("add", "hello", operate2("add", " ", "world"));
// 使用预定义的函数Math.pow()
var k = operate("pow", 10, 2);

// 初始化函数对象的计数器属性
// 由于函数声明被提前了，因此这里是可以在函数声明
// 之前给它的成员赋值的
uniqueInteger.counter = 0;

// 每次调用这个函数都会返回一个不同的整数
// 它使用一个属性来记住下一次将要返回的值
function uniqueInteger(){
    return uniqueInteger.counter++; // 先返回计数器的值，然后计数器自增1
}

// 计算阶乘，并将结果缓存至函数的属性中
function factorial(n){
    if(isFinite(n) && n > 0 && n == Math.round(n)){ //有限的正整数
        if(!(n in factorial))       //如果没有缓存结果
            factorial[n] = n * factorial(n - 1);    //计算结果并缓存之
        return factorial[n];    // 返回缓存结果
    }
    else return NaN;    // 如果输入有误
}
factorial[1] = 1;   // 初始化缓存以保存这种基本情况

//例8-3: 特定场景下返回带补丁的extend()版本
// 定义一个拓展函数，用来将第二个以及后续参数复制至第一个参数
// 这里我们处理了IE bug: 在多数IE版本中
// 如果o的属性拥有一个不可枚举的同名属性，则for/in循环
// 不会枚举对象o的可枚举属性，也就是说，将不会正确地处理诸如toString的属性
// 除非我们显式检测它
var extend = (function(){   // 将这个函数的返回值复制给extend
    // 在修复它之前，首先检查是否存在bug
    for(var p in {toString: null}){
        // 如果代码执行到这里，那么for/in循环会正确工作并返回
        // 一个简单版本的extend()函数
        return function extend(o){
            for(var i = 1; i < arguments.length; i++){
                var source = arguments[i];
                for(var prop in source) o[prop] = source[prop];
            }
            return o;
        };
    }
    // 如果代码执行到这里，说明for/in循环不会枚举测试对象的toString属性
    // 因此返回另一个版本的extend()函数，这个函数显式测试
    // Object.prototype中的不可枚举属性
    return function pached_extend(o){
        for(var i = 1; i < arguments.length; i++){
            var source = arguments[i];
            //复制所有的可枚举属性
            for(var prop in source) o[prop] = source[prop];

            //现在检查特殊属性
            for(var j = 0; j < protoprops.length; j++){
                prop = protoprops[j];
                if(source.hasOwnProperty(prop)) o[prop] = source[prop];
            }
        }
        return o;
    };
    // 这个列表列出了需要检查的特殊属性
    var protoprops = ["toString", "valueOf", "constructor", "hasOwnProperty",
                      "isPrototypeOf", "propertyIsEnumerable", "toLocaleString"];
})();

//8.6 闭包
var scope = "global scope"; // 全局变量
function checkscope(){
    var scope = "local scope";  // 局部变量
    function f(){
        return scope;   // 在作用域中返回这个值
    }
    return f();
}
checkscope()    // => "local scope"

var scope = "global scope"; // 全局变量
function checkscope(){
    var scope = "local scope";  //局部变量
    function f(){
        return scope;   // 在作用域中返回这个值
    }
    return f;
}
checkscope()(); // 返回

//-----------------分割
var uniqueInteger = (function(){    // 定义函数并立即调用
    var counter = 0;            // 函数的私有状态
    return function(){
        return counter++;
    }
}());