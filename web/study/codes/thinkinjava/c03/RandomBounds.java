package c03;
//: RandomBounds.java
// Does Math.random() produce 0.0 and 1.0?
/**
 * Created by Administrator on 2015/12/23.
 */
public class RandomBounds {
    static void usage(){
        System.out.println("usage: \n\t" +
        "RandomBounds lower\n\t" +
        "RandomBounds upper");
        System.exit(1);
    }

    public static void main(String[] args) {
        if(args.length != 1) usage();
        if(args[0].equals("lower")){
            while(Math.random() != 0.0);    // Keep trying
            System.out.println("Produced 0.0!");
        }else if(args[0].equals("uppser")){
            while(Math.random() != 1.0);    // Keep trying
            System.out.println("Produced 1.0!");
        }else
            usage();
    }
} ///:~
