/**
 * Created by Administrator on 2016/1/13.
 */
//5.6.5 throw 语句
function factorial(x){
    //如果输入参数是非法的，则抛出一个异常
    if(x < 0)   throw new Error("x不能是负数");
    //否则，计算出一个值，并正常地返回它
    for(var f = 1; x > 1; f *= x, x--)  /* empty */
    return f;
}

//5.7.1 with语句
with(document.forms[0]){
    //  直接访问表单元素，例如：
    name.value = "";
    address.value = "";
    email.value = "";
}

//5.7.2 debugger语句
function f(o){
    if(o === undefined) debugger;   //这一行代码只是用于临时调试
    //...   //函数的其他部分
}