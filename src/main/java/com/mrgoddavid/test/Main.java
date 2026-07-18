package com.mrgoddavid.test;

import com.mrgoddavid.vector.Vector;
import com.mrgoddavid.vector.Vector3i;
import com.mrgoddavid.vector.space.plane.RestrictedPlane3d;

/**
 * Main class.
 */
public class Main {

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
//        Vector3i a =  new Vector3i(1,0,1);
//        Vector3i b = new Vector3i(-1,1,0);
//        System.out.println(a.crossProduct(b, false));


        RestrictedPlane3d plane1 = new RestrictedPlane3d("2x + 3y + 2z = 12"); // x + y + z = 1
        RestrictedPlane3d plane2 = new RestrictedPlane3d("2x + 3y + 2z = 1"); // x + 2y + z = 1
        System.out.println(plane1.distance(plane2, true));

        System.out.println(new Vector3i(2, 3, 1).compareWith(new Vector3i(2, 3, 1), Vector.ComparisonCommand.EQUALS));
    }
}
