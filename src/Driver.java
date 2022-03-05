package cs1302.p2;

import cs1302.adt.Node;
import cs1302.adt.StringList;
import cs1302.adt.FancyStringList;

public class Driver {

    public static void main(String[] args) {


        FancyStringList test1 = new ArrayStringList();


        test1.append("a");
        test1.append("b");
        test1.append("c");
        test1.append("d");
        test1.append("e");
        test1.append("f");
        test1.append("g");
        test1.append("h");
        test1.append("i");
        System.out.println(test1.toString());

        FancyStringList test2 = new LinkedStringList();


        test2.append("j");
        test2.append("k");
        test2.append("l");
        test2.append("m");
        test2.append("n");
        test2.append("o");
        test2.append("p");
        test2.append("q");
        test2.append("r");
        System.out.println(test2.toString());

        test1.add(3, test1);
        System.out.println(test1);
        System.out.println(test1.reverse());
        System.out.println(test1.slice(0, 8));
    } // main
} // Driver
