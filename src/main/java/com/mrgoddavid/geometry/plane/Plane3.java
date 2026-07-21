package com.mrgoddavid.geometry.plane;

import com.mrgoddavid.vector.Vector3d;
import com.mrgoddavid.geometry.line.Line3d;
import com.mrgoddavid.geometry.point.Point3d;

import java.io.Serializable;

/**
 * The interface of a three-dimensional plane. The definition of three-dimensional plane is {@code Ax + By + Cz = D}
 *
 * @author Mr. GodDavid
 * @since 7/13/2026
 */
public interface Plane3 extends Serializable {

    /**
     * The intersection of two three-dimensional planes is a three-dimensional line. This method finds that intersecting
     * line of this plane and the plane in the parameter of this method.
     *
     * @param plane3 other three-dimensional plane that is not null.
     * @return the intersecting line of this plane and the parameter plane3.
     */
    Line3d intersect(RestrictedPlane3d plane3);

    /**
     * Gets the normal vector of this three-dimensional plane. The normal vector of a plane is the three-dimensional
     * vector that consists the coefficients of x, y, and z of the equation of the plane.
     *
     * @return the normal vector of this plane.
     */
    Vector3d getNormal();

    /**
     * Calculates the distance between two three-dimensional parallel planes.
     *
     * @param other plane that is not null.
     * @return the distance between this plane and the other plane.
     * @since 7/14/2026 part of Plane-to-Plane-Distance equation update.
     */
    double distance(RestrictedPlane3d other);

    /**
     * Calculate the distance from a plane to point.
     *
     * @param other point that is not null.
     * @return the distance from plane to point.
     * @since 7/14/2026 part of Plane-to-Plane-Distance equation update.
     */
    double distance(Point3d other);

    /**
     * Calculate the distance from a line to the plane. If the line is not parallel to the plane, the distance between
     * them is zero.
     *
     * @param other three-dimensional line that is not null.
     * @return the distance between line and plane.
     * @since 7/17/2026
     */
    double distance(Line3d other);
}
