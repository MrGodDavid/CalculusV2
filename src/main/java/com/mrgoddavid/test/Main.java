package com.mrgoddavid.test;

import com.mrgoddavid.vector.Vector3i;
import com.mrgoddavid.vector.space.plane.Plane3d;

public class Main {

    public static void main(String[] args) {
        System.out.println("=====> Hello Mr. GodDavid's Calculus Utils! <=====");

//        Vector2i v = new Vector2i(2, 3);
//        Vector2i v2 = new Vector2i(3, 8);
//
//        System.out.println(v.compareWith(v2, Vector.ComparisonCommand.LESS_THAN));
//        Vector3i a =  new Vector3i(2,3,-1);
//        Vector3i b = new Vector3i(1,-4,2);
//        System.out.println(a.crossProduct(b, false));


        Plane3d plane1 = new Plane3d("x + y + z = 12"); // x + y + z = 1
        Plane3d plane2 = new Plane3d("x + 2y + z = 1"); // x + 2y + z = 1
        System.out.println(plane1.intersect(plane2));
    }
}
