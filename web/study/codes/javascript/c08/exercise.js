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