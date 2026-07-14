package com.mrgoddavid.vector.space.plane;

import com.mrgoddavid.vector.Vector3i;
import com.mrgoddavid.vector.space.line.Line3;

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
    Line3 intersect(Plane3d plane3);

    /**
     * Gets the normal vector of this three-dimensional plane. The normal vector of a plane is the three-dimensional
     * vector that consists the coefficients of x, y, and z of the equation of the plane.
     *
     * @return the normal vector of this plane.
     */
    Vector3i getNormal();
}
