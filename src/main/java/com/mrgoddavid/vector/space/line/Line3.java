package com.mrgoddavid.vector.space.line;

import com.mrgoddavid.vector.Vector3i;
import com.mrgoddavid.vector.space.point.Point3;

/**
 * The definition of a three-dimensional line is in this form:
 * {@code r(t) = <x_0,y_0,z_0> + t<a, b, c>}.
 *
 * @author Mr. GodDavid
 * @since 7/13/2026
 */
public final class Line3 {

    private final Point3 startingPoint;
    private final Vector3i direction;

    public Line3(Point3 startingPoint, Vector3i direction) {
        this.startingPoint = startingPoint;
        this.direction = direction;
    }

    public Point3 getStartingPoint() {
        return startingPoint;
    }

    public Vector3i getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "r(t) = " + "<" + startingPoint.getX() + ", " + startingPoint.getY() + ", " + startingPoint.getZ() + ">" + " + t" +
                direction.toString();
    }
}
