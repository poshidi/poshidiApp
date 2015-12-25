package c04;
//: SimpleConstructor.java
//  Demostration of a simple constructor
/**
 * Created by Administrator on 2015/12/25.
 */
class Rock{
    Rock(int i){ //This is the constructor
        System.out.println("Creating Rock" + i);

    }
}
public class SimpleConstructor {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            new Rock(i);
        }
    }
}   ///:~
