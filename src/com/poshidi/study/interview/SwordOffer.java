package com.poshidi.study.interview;

/**
 * Created by Administrator on 2016/1/22.
 */
public class SwordOffer {
}
/*
1、二维数组中的查找
在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
http://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
*/
class Exe1{
    class Solution{
        public boolean Find(int [][] array, int target){
            /*for(int i = array.length - 1; i != 0;){
                for(int j = 0; j < array[i].length - 1;){
                    if(target > array[i][j]){
                        j++;
                    }else if(target < array[i][j]){
                        i--;
                    }else{
                        return true;
                    }
                }
            }
            return false;*/
            int len = array.length-1;
            int i = 0;
            while((len >= 0)&& (i < array[0].length)){
                if(array[len][i] > target){
                    len--;
                }else if(array[len][i] < target){
                    i++;
                }else{
                    return true;
                }
            }
            return false;
        }
    }

    public  Solution getSolution(){
        return new Solution();
    }

    public static void main(String[] args) {
        //初始化：
        int array[][] = new int[5][5];
        int c = 1;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                array[i][j] = c++;
            }
        }
        Exe1 e = new Exe1();
        Solution s = e.getSolution();
        boolean flag = s.Find(array, 25);
        System.out.println(flag);
        //遍历
      /*  for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                int val = array[i][j];
                System.out.print(val + " ");
                if(val % 5 == 0){
                    System.out.println();
                }
            }
        }*/

    }
}

/*
2、请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
http://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
*/
class Exe2{
    class Solution {
        public String replaceSpace(StringBuffer str) {
            /*for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                if(ch == ' '){
                    str.charAt()
                }
            }
            return null;*/

            String sti = str.toString();
            char[] strChar = sti.toCharArray();
            StringBuffer stb = new StringBuffer();
            for(int i=0;i<strChar.length;i++){
                if(strChar[i]==' '){
                    stb.append("%20");
                }else{
                    stb.append(strChar[i]);
                }
            }
            return stb.toString();

//            return str.toString().replaceAll(" ", "%20");
        }
    }

    public  Solution getSolution(){
        return new Solution();
    }

    public static void main(String[] args) {

        StringBuffer str = new StringBuffer("We Are Happy and    ho ho po j i o");
        Exe2 e = new Exe2();
        Solution s =e.getSolution();
        Long start = System.currentTimeMillis();
        String s2 = s.replaceSpace(str);
        Long end = System.currentTimeMillis();
        System.out.println("time:" + (end - start));
        System.out.println("result:" + s2);
    }
}
