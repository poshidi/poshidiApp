/**
 * Created by Administrator on 2016/1/20.
 */
//7.3
a = new Array(5);
a = [];
a[1000] = 0;

//7.8.1
//Array.join()����������������Ԫ�ض�ת��Ϊ�ַ�����������һ�𣬷���������ɵ��ַ���������ָ��һ����ѡ���ַ��������ɵ��ַ��������ָ�����ĸ���Ԫ�ء������ָ��
//�ָ�����Ĭ��ʹ�ö��š�
var a = [1, 2, 3];
a.join();               //=> "1,2,3"
a.join(" ");            //=> "1 2 3"
a.join("");             //=> "123"
var b =  new Array(10);
b.join('-');            //=>'---------':9�����ֺ���ɵ��ַ���

//7.8.2 reverse()
/*
Array.reverse()�����������е�Ԫ�صߵ�˳�򣬷�����������顣������ԭ���������ٷ��ظ����顣
*/
var a = [1, 2, 3];
a.reverse().join()  // => "3,2,1",�������ڵ�a��[3,2,1]

//7.8.3 sort()
/*Array.sort()�����������е�Ԫ�����򲢷������������顣�޲�Ĭ�ϰ���ĸ˳�����������undefinedԪ�أ����ǻ��ŵ�����β����*/
var a = new Array("banana", "cherry", "apple");
a.sort();
var s = a.join(", ");   // s == "apple, banana, cherry"

//����ĸ��˳���������Ļ���ҪΪsort����һ���ȽϺ�����07110
var a = [33, 4, 1111, 222];
a.sort();                   // ��ĸ������ 1111, 222, 33, 4
a.sort(function(a, b){      // ��ֵ����4, 33, 222, 1111
    return a-b;             // ����˳�� ���ظ����� 0�� ����
});
a.sort(function(a,b){return b-a});  // ��ֵ��С�뷨������

//�����ִ�Сд���������
var a = ['ant', 'Bug', 'cat', 'Dog'];
a.sort();           // ���ִ�Сд������['Bug', 'Dog', 'ant', 'cat']
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
//Array.splice()�������������в����ɾ��Ԫ�ص�ͨ�÷��������޸ĵ��õ����顣
var a = [1, 2, 3, 4, 5, 6, 7, 8,];
a.splice(4);    //����[5, 6, 7, 8]; a��[1, 2, 3, 4]
a.splice(1, 2); //����[2, 3]; a��[1, 4]
a.splice(1, 1); //����[4]; a��[1]

var a = [1, 2, 3, 4, 5];
a.splice(2, 0, 'a', 'b');   //  ����[]; a��[1, 2, 'a', 'b', 3, 4, 5]
a.splice(2, 2, [1,2], 3);   //  ����['a', 'b']; a��[1, 2, [1, 2], 3, 3, 4, 5]

//7.9.3 filter()
//���ص��������һ���Ӽ�
var a = [5, 4, 3, 2, 1];
var smallvalues = a.filter(function(x){ return x < 3 });    // [2, 1]
var everyother = a.filter(function(x,i){ return i % 2 == 0});   // [5, 3, 1]
//ѹ������
var sparse = [1,,2,,3,];
var dense = sparse.filter(function(){ return true; });

//7.9.4 every() �� some()
//every()��some()������������߼��ж������Ƕ�����Ԫ��Ӧ��ָ���ĺ��������ж�������true��false
var a = [1, 2, 3, 4, 5];
a.every(function(x){ return x < 10; })      // => true: ���е�ֵ<10
a.every(function(x){ return x % 2 === 0; }) // => false:�������е�Ԫ�ض���ż��
//some()��������������һ��Ԫ�ص����ж���������true,���ͷ���true;���ҵ��ҽ�����ֵ�е�����Ԫ�ص���
//�ж�����������false,���ŷ���false��
var a = [1, 2, 3, 4, 5];
a.some(function(x){ return x % 2 === 0;})   // => true: a����ż��ֵ
a.some(isNaN)                               // => false: a����������ֵԪ��

//7.11 ���������
var a = {}; // ��һ������ն���ʼ
//  ���һЩ���ԣ���Ϊ"������"
var i = 0;
while(i < 10){
    a[i] = i * i;
    i++;
}
a.length = i;

//�������������
var total = 0;
for(var j = 0; j < a.length; j++)
    total += a[j];