package com.mrgoddavid.test;

import com.mrgoddavid.vector.Vector;
import com.mrgoddavid.vector.Vector2i;
import com.mrgoddavid.vector.Vector3i;

public class Main {

    public static void main(String[] args) {
        System.out.println("=====> Hello Mr. GodDavid's Calculus Utils! <=====");

//        Vector2i v = new Vector2i(2, 3);
//        Vector2i v2 = new Vector2i(3, 8);
//
//        System.out.println(v.compareWith(v2, Vector.ComparisonCommand.LESS_THAN));
        Vector3i a =  new Vector3i(0,1,-1);
        Vector3i b = new Vector3i(2,2,1);
        System.out.println(a.crossProduct(b, false));
    }
}
