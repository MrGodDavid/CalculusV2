package com.mrgoddavid.test;

import com.mrgoddavid.function.domain.Domain;
import com.mrgoddavid.function.Function;
import com.mrgoddavid.function.piecewise.PiecewiseFunction;

/**
 * Main class.
 */
class Main {

    /**
     * Empty constructor.
     */
    public Main() {
    }

    /**
     * Entry point of this class.
     *
     * @param args args.
     */
    public static void main(String[] args) {
        /*
         *       ___           ___                         ___           ___                         ___           ___                    ___                                                   ___
         *      /\__\         /\  \                       /\__\         /\  \                       /\  \         /\__\                  /\  \                                                 /\__\
         *     /:/  /        /::\  \                     /:/  /         \:\  \                      \:\  \       /:/ _/_                 \:\  \         ___         ___                       /:/ _/_
         *    /:/  /        /:/\:\  \                   /:/  /           \:\  \                      \:\  \     /:/ /\  \                 \:\  \       /\__\       /\__\                     /:/ /\  \
         *   /:/  /  ___   /:/ /::\  \   ___     ___   /:/  /  ___   ___  \:\  \   ___     ___   ___  \:\  \   /:/ /::\  \            ___  \:\  \     /:/  /      /:/__/      ___     ___   /:/ /::\  \
         *  /:/__/  /\__\ /:/_/:/\:\__\ /\  \   /\__\ /:/__/  /\__\ /\  \  \:\__\ /\  \   /\__\ /\  \  \:\__\ /:/_/:/\:\__\          /\  \  \:\__\   /:/__/      /::\  \     /\  \   /\__\ /:/_/:/\:\__\
         *  \:\  \ /:/  / \:\/:/  \/__/ \:\  \ /:/  / \:\  \ /:/  / \:\  \ /:/  / \:\  \ /:/  / \:\  \ /:/  / \:\/:/ /:/  /          \:\  \ /:/  /  /::\  \      \/\:\  \__  \:\  \ /:/  / \:\/:/ /:/  /
         *   \:\  /:/  /   \::/__/       \:\  /:/  /   \:\  /:/  /   \:\  /:/  /   \:\  /:/  /   \:\  /:/  /   \::/ /:/  /            \:\  /:/  /  /:/\:\  \      ~~\:\/\__\  \:\  /:/  /   \::/ /:/  /
         *    \:\/:/  /     \:\  \        \:\/:/  /     \:\/:/  /     \:\/:/  /     \:\/:/  /     \:\/:/  /     \/_/:/  /              \:\/:/  /   \/__\:\  \        \::/  /   \:\/:/  /     \/_/:/  /
         *     \::/  /       \:\__\        \::/  /       \::/  /       \::/  /       \::/  /       \::/  /        /:/  /                \::/  /         \:\__\       /:/  /     \::/  /        /:/  /
         *      \/__/         \/__/         \/__/         \/__/         \/__/         \/__/         \/__/         \/__/                  \/__/           \/__/       \/__/       \/__/         \/__/
         */
        String headline = " __  __         ___         _ ___           _    _ _    \n" +
                "|  \\/  |_ _    / __|___  __| |   \\ __ ___ _(_)__| ( )___\n" +
                "| |\\/| | '_|  | (_ / _ \\/ _` | |) / _` \\ V / / _` |/(_-<\n" +
                "|_|  |_|_|(_)  \\___\\___/\\__,_|___/\\__,_|\\_/|_\\__,_| /__/\n" +
                "  ___      _         _           _   _ _   _ _    _     \n" +
                " / __|__ _| |__ _  _| |_  _ ___ | | | | |_(_) |__| |    \n" +
                "| (__/ _` | / _| || | | || (_-< | |_| |  _| | (_-<_|    \n" +
                " \\___\\__,_|_\\__|\\_,_|_|\\_,_/__/  \\___/ \\__|_|_/__(_)    \n";
        System.out.println(headline);
        System.out.println("[===============================HAVE FUN!===============================]");
        // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
        // Edit stuffs below.
        // Be sure to comment out unnecessary code blocks before running.
        // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

//        Vector2i v = new Vector2i(2, 3);
//        Vector2i v2 = new Vector2i(3, 8);
//
//        System.out.println(v.compareWith(v2, Vector.ComparisonCommand.LESS_THAN));
//        Vector3d a = new Vector3d(2, -1, -2);
//        Vector3d b = new Vector3d(4, -3, -3);
//        System.out.println(a.crossProduct(b, false));
//
//
//        System.out.println(new Vector3i(2, 3, 1).compareWith(new Vector3i(2, 3, 1), Vector.ComparisonCommand.EQUALS));
//
//        Line3d line1 = new Line3d(new Point3d(0, 0, 0), new Vector3d(1, 0, 0));
//        Line3d line2 = new Line3d(new Point3d(1, 1, 9), new Vector3d(1, 0, 1));
//        System.out.println(line1.intersect(line2));
//        System.out.println(line1.distance(line2));
//
//        Point3d A = new Point3d(2, 4, 1);
//        // RestrictedPlane3d planeA = new RestrictedPlane3d(4, -2, 7, 4);
//        RestrictedPlane3d planeA = new RestrictedPlane3d("4x -2y + 7z = 4");
//        System.out.println(planeA.distance(A, true));
//
//        RestrictedPlane3d PA = new RestrictedPlane3d(1, 1, 1, 3);
//        RestrictedPlane3d PB = new RestrictedPlane3d(1, 2, 3, 7);
//        System.out.println(PA.intersect(PB));
//
//        Radian angle = new Radian(Math.PI / 4);
//        Circle2d circle = new Circle2d(new Point2d(1, 0), 4);
//        System.out.println(circle.contains(new Point2d()));
//        System.out.println(circle.detailedInfo());
//
//        System.out.println((1.0 / 0) == Double.POSITIVE_INFINITY);
//
////        Function f = new Function(x -> (x * x + 2.0 * x + 1.0) / (x * x));
//        Function f = new Function(x -> ((x * x - 25.0) / (x * x + 2 * x - 15.0)));
//        f.debug();
//        System.out.println(f.limitAt(-5.0));
//        System.out.println(DavidMath.tan(Constants.PI));
//
//        System.out.println(1.0 / Double.NEGATIVE_INFINITY);
//
//        System.out.println(f.leftLimitAt(5.0));
//        System.out.println(f.rightLimitAt(5.0));

        PiecewiseFunction f = new PiecewiseFunction(
                new Function[] {
                        new Function(x -> x + 1),
                        new Function(x -> x + 2)
                },
                new Domain[]{
                        new Domain(0, 1, false, false),
                        new Domain(1, 2, true, true),
                }
        );

        Domain d1 = new Domain(0, 1, true, true);
        Domain d2 = new Domain(-1, 3, false, true);
        System.out.println(d1.overlaps(d2));

        System.out.println(f.limitAt(2.5));
    }
}
