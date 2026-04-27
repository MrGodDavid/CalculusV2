package com.mrgoddavid.test;

import com.mrgoddavid.vector.Vector;
import com.mrgoddavid.vector.Vector2i;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello VectorMath!");

        Vector2i v = new Vector2i(2, 3);
        Vector2i v2 = new Vector2i(3, 8);

        System.out.println(v.compareWith(v2, Vector.ComparisonCommand.LESS_THAN));
    }
}
