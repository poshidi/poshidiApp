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

//6.6:属性getter和setter
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
//例6-4: classof()函数
function classof(o){
    if(o === null)  return "Null";
    if(o === undefined) return "Undefined";
    return Object.prototype.toString.call(0).slice(8,-1);
}