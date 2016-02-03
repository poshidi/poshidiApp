/**
 * Created by Administrator on 2016/1/20.
 */
//7.3
a = new Array(5);
a = [];
a[1000] = 0;

//7.8.1
//Array.join()方法将数组中所有元素都转化为字符串并连接在一起，返回最后生成的字符串。可以指定一个可选的字符串在生成的字符串中来分隔数组的各个元素。如果不指定
//分隔符，默认使用逗号。
var a = [1, 2, 3];
a.join();               //=> "1,2,3"
a.join(" ");            //=> "1 2 3"
a.join("");             //=> "123"
var b =  new Array(10);
b.join('-');            //=>'---------':9个连字号组成的字符串

//7.8.2 reverse()
/*
Array.reverse()方法将数组中的元素颠倒顺序，返回逆序的数组。它是在原数组排序再返回该数组。
*/
var a = [1, 2, 3];
a.reverse().join()  // => "3,2,1",并且现在的a是[3,2,1]

//7.8.3 sort()
/*Array.sort()方法将数组中的元素排序并返回排序后的数组。无参默认按字母顺序排序。如果含undefined元素，他们会排到数组尾部。*/
var a = new Array("banana", "cherry", "apple");
a.sort();
var s = a.join(", ");   // s == "apple, banana, cherry"

//非字母表顺序进行排序的话，要为sort传递一个比较函数。07110
var a = [33, 4, 1111, 222];
a.sort();                   // 字母表排序： 1111, 222, 33, 4
a.sort(function(a, b){      // 数值排序：4, 33, 222, 1111
    return a-b;             // 根据顺序， 返回负数、 0、 正数
});
a.sort(function(a,b){return b-a});  // 数值大小想法的排序

//可区分大小写排序的例子
var a = ['ant', 'Bug', 'cat', 'Dog'];
a.sort();           // 区分大小写的排序：['Bug', 'Dog', 'ant', 'cat']
a.sort(function(s, t){
    var a = s.toLowerCase();
    var b = t.toLowerCase();
    if(a < b) return -1;
    if(a > b) return 1;
    return 0;
});                     // => ['ant', 'Bug', 'cat', 'Dog']

//7.8.5 slice()
var a = [1,2,3,4,5];
a.slice(0,3);
a.slice(3);
a.slice(-1,-1);
a.slice(-3,-2);

//7.8.6 splice()
//Array.splice()方法是在数组中插入或删除元素的通用方法，会修改调用的数组。
var a = [1, 2, 3, 4, 5, 6, 7, 8,];
a.splice(4);    //返回[5, 6, 7, 8]; a是[1, 2, 3, 4]
a.splice(1, 2); //返回[2, 3]; a是[1, 4]
a.splice(1, 1); //返回[4]; a是[1]

var a = [1, 2, 3, 4, 5];
a.splice(2, 0, 'a', 'b');   //  返回[]; a是[1, 2, 'a', 'b', 3, 4, 5]
a.splice(2, 2, [1,2], 3);   //  返回['a', 'b']; a是[1, 2, [1, 2], 3, 3, 4, 5]

//7.9.3 filter()
//返回调用数组的一个子集
var a = [5, 4, 3, 2, 1];
var smallvalues = a.filter(function(x){ return x < 3 });    // [2, 1]
var everyother = a.filter(function(x,i){ return i % 2 == 0});   // [5, 3, 1]
//压缩数组
var sparse = [1,,2,,3,];
var dense = sparse.filter(function(){ return true; });

//7.9.4 every() 和 some()
//every()和some()方法是数组的逻辑判定：它们对数组元素应用指定的函数进行判定，返回true或false
var a = [1, 2, 3, 4, 5];
a.every(function(x){ return x < 10; })      // => true: 所有的值<10
a.every(function(x){ return x % 2 === 0; }) // => false:不是所有的元素都是偶数
//some()当数组中至少有一个元素调用判定函数返回true,它就返回true;并且当且仅当数值中的所有元素调用
//判定函数都返回false,它才返回false：
var a = [1, 2, 3, 4, 5];
a.some(function(x){ return x % 2 === 0;})   // => true: a含有偶数值
a.some(isNaN)                               // => false: a不包含非数值元素

//7.11 类数组对象
var a = {}; // 从一个常规空对象开始
//  添加一些属性，称为"类数组"
var i = 0;
while(i < 10){
    a[i] = i * i;
    i++;
}
a.length = i;

//真正的数组遍历
var total = 0;
for(var j = 0; j < a.length; j++)
    total += a[j];