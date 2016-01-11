/**
 * Created by Administrator on 2016/1/5.
 */
//4.9.3 in ÔËËã·û
var point = { x:1, y:2};
"x" in point
"z" in point
"toString" in point

var data = [7,8,9];
"0" in data
1 in data
3 in data

//4.12.2 È«¾Öeval()
var geval = eval;
var x = "global", y = "global";
function f(){
    var x = "local";
    eval("x += 'changed';");
    return x;
}
function g(){
    var y = "local";
    geval("y += 'changed';");
    return y;
}
console.log(f(), x);
console.log(g(), y);