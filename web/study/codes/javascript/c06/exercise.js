/**
 * Created by Administrator on 2016/1/15.
 */
//6-1:通过原型集成创建一个新对象
//  inherit() 返回了一个集成自原型对象p的属性的新对象
//  这里使用ECMAScript 5中的Object.create()函数 (如果存在的话)
//  如果不存在Object.create(), 则退化使用其他方法
function inherit(p){
    if(p == null)   throw TypeError();  // p是一个对象，但不能是null
    if(Object.create)
        return Object.create(p);
    var t = typeof p;
    if(t !== "object" && t !== "function")  throw TypeError();
    function f(){};
    f.prototype = p;
    return new f();
}