package com.mrgoddavid.vector;

import com.mrgoddavid.vector.immutable.*;

import java.io.Serializable;

/**
 * This is the root class for any vectors in this library,
 *
 * @param <T> class type of classes that implement this interface.
 * @author Mr. GodDavid
 * @since 8/6/2026
 */
public interface Vector<T> extends Serializable {

    /**
     * Comparison command.
     */
    enum ComparisonCommand {
        /**
         * Less-than-or-equal-to command.
         */
        LESS_THAN_OR_EQUALS_TO,
        /**
         * Less-than command.
         */
        LESS_THAN,
        /**
         * Equal command.
         */
        EQUALS,
        /**
         * Greater-than command.
         */
        GREATER_THAN,
        /**
         * Greater-than-or-equal-to command.
         */
        GREATER_THAN_OR_EQUALS_TO;
    }

    /**
     * Return a reference of itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: returns a reference of itself.</p>
     *
     * @return Return a reference of itself.
     */
    T getSelf();

    /**
     * Performs entrywise comparison of vector itself and the second vector. The comparison is specified in the
     * enum of {@code Vector}.
     * <p>Precondition: second input vector is not null.</p>
     * <p>Postcondition: return a boolean value that the first vector pass/fail the comparison test to the second
     * vector.</p>
     *
     * @param second  vector that is not null.
     * @param command specifies the comparison operation between the current vector and the second input vector.
     * @return true if the current vector passes the comparison test to the second input vector and false otherwise.
     */
    default boolean compareWith(T second, ComparisonCommand command) {
        if (!(second instanceof ImmutableVector)) return false;
        boolean result = false;
        T self = getSelf();
        switch (command) {
            case LESS_THAN_OR_EQUALS_TO -> {
                if (second instanceof ImmutableVector2i second_v2i) {
                    ImmutableVector2i self_v2i = (ImmutableVector2i) self;
                    result = (self_v2i.getX() <= second_v2i.getX()) && (self_v2i.getY() <= second_v2i.getY());
                } else if (second instanceof ImmutableVector2d second_v2d) {
                    ImmutableVector2d self_v2d = (ImmutableVector2d) self;
                    result = (self_v2d.getX() <= second_v2d.getX()) && (self_v2d.getY() <= second_v2d.getY());
                } else if (second instanceof ImmutableVector2f second_v2f) {
                    ImmutableVector2f self_v2f = (ImmutableVector2f) self;
                    result = (self_v2f.getX() <= second_v2f.getX()) && (self_v2f.getY() <= second_v2f.getY());
                } else if (second instanceof ImmutableVector2l second_v2l) {
                    ImmutableVector2l self_v2l = (ImmutableVector2l) self;
                    result = (self_v2l.getX() <= second_v2l.getX()) && (self_v2l.getY() <= second_v2l.getY());
                } else if (second instanceof ImmutableVector3i second_v3i) {
                    ImmutableVector3i self_v3d = (ImmutableVector3i) self;
                    result = (self_v3d.getX() <= second_v3i.getX()) && (self_v3d.getY() <= second_v3i.getY()) && (self_v3d.getZ() <= second_v3i.getZ());
                } else if (second instanceof ImmutableVector3d second_v3d) {
                    ImmutableVector3d self_v3d = (ImmutableVector3d) self;
                    result = (self_v3d.getX() <= second_v3d.getX()) && (self_v3d.getY() <= second_v3d.getY()) && (self_v3d.getZ() <= second_v3d.getZ());
                }
            }
            case LESS_THAN -> {
                if (second instanceof ImmutableVector2i second_v2i) {
                    ImmutableVector2i self_v2i = (ImmutableVector2i) self;
                    result = (self_v2i.getX() < second_v2i.getX()) && (self_v2i.getY() < second_v2i.getY());
                } else if (second instanceof ImmutableVector2d second_v2d) {
                    ImmutableVector2d self_v2d = (ImmutableVector2d) self;
                    result = (self_v2d.getX() < second_v2d.getX()) && (self_v2d.getY() < second_v2d.getY());
                } else if (second instanceof ImmutableVector2f second_v2f) {
                    ImmutableVector2f self_v2f = (ImmutableVector2f) self;
                    result = (self_v2f.getX() < second_v2f.getX()) && (self_v2f.getY() < second_v2f.getY());
                } else if (second instanceof ImmutableVector2l second_v2l) {
                    ImmutableVector2l self_v2l = (ImmutableVector2l) self;
                    result = (self_v2l.getX() < second_v2l.getX()) && (self_v2l.getY() < second_v2l.getY());
                } else if (second instanceof ImmutableVector3i second_v3i) {
                    ImmutableVector3i self_v3d = (ImmutableVector3i) self;
                    result = (self_v3d.getX() < second_v3i.getX()) && (self_v3d.getY() < second_v3i.getY()) && (self_v3d.getZ() < second_v3i.getZ());
                } else if (second instanceof ImmutableVector3d second_v3d) {
                    ImmutableVector3d self_v3d = (ImmutableVector3d) self;
                    result = (self_v3d.getX() < second_v3d.getX()) && (self_v3d.getY() < second_v3d.getY()) && (self_v3d.getZ() < second_v3d.getZ());
                }
            }
            case EQUALS -> {
                if (second instanceof ImmutableVector2i second_v2i) {
                    ImmutableVector2i self_v2i = (ImmutableVector2i) self;
                    result = (self_v2i.getX() == second_v2i.getX()) && (self_v2i.getY() == second_v2i.getY());
                } else if (second instanceof ImmutableVector2d second_v2d) {
                    ImmutableVector2d self_v2d = (ImmutableVector2d) self;
                    result = (self_v2d.getX() == second_v2d.getX()) && (self_v2d.getY() == second_v2d.getY());
                } else if (second instanceof ImmutableVector2f second_v2f) {
                    ImmutableVector2f self_v2f = (ImmutableVector2f) self;
                    result = (self_v2f.getX() == second_v2f.getX()) && (self_v2f.getY() == second_v2f.getY());
                } else if (second instanceof ImmutableVector2l second_v2l) {
                    ImmutableVector2l self_v2l = (ImmutableVector2l) self;
                    result = (self_v2l.getX() == second_v2l.getX()) && (self_v2l.getY() == second_v2l.getY());
                } else if (second instanceof ImmutableVector3i second_v3i) {
                    ImmutableVector3i self_v3d = (ImmutableVector3i) self;
                    result = (self_v3d.getX() == second_v3i.getX()) && (self_v3d.getY() == second_v3i.getY()) && (self_v3d.getZ() == second_v3i.getZ());
                } else if (second instanceof ImmutableVector3d second_v3d) {
                    ImmutableVector3d self_v3d = (ImmutableVector3d) self;
                    result = (self_v3d.getX() == second_v3d.getX()) && (self_v3d.getY() == second_v3d.getY()) && (self_v3d.getZ() == second_v3d.getZ());
                }
            }
            case GREATER_THAN -> {
                if (second instanceof ImmutableVector2i second_v2i) {
                    ImmutableVector2i self_v2i = (ImmutableVector2i) self;
                    result = (self_v2i.getX() > second_v2i.getX()) && (self_v2i.getY() > second_v2i.getY());
                } else if (second instanceof ImmutableVector2d second_v2d) {
                    ImmutableVector2d self_v2d = (ImmutableVector2d) self;
                    result = (self_v2d.getX() > second_v2d.getX()) && (self_v2d.getY() > second_v2d.getY());
                } else if (second instanceof ImmutableVector2f second_v2f) {
                    ImmutableVector2f self_v2f = (ImmutableVector2f) self;
                    result = (self_v2f.getX() > second_v2f.getX()) && (self_v2f.getY() > second_v2f.getY());
                } else if (second instanceof ImmutableVector2l second_v2l) {
                    ImmutableVector2l self_v2l = (ImmutableVector2l) self;
                    result = (self_v2l.getX() > second_v2l.getX()) && (self_v2l.getY() > second_v2l.getY());
                } else if (second instanceof ImmutableVector3i second_v3i) {
                    ImmutableVector3i self_v3d = (ImmutableVector3i) self;
                    result = (self_v3d.getX() > second_v3i.getX()) && (self_v3d.getY() > second_v3i.getY()) && (self_v3d.getZ() > second_v3i.getZ());
                } else if (second instanceof ImmutableVector3d second_v3d) {
                    ImmutableVector3d self_v3d = (ImmutableVector3d) self;
                    result = (self_v3d.getX() > second_v3d.getX()) && (self_v3d.getY() > second_v3d.getY()) && (self_v3d.getZ() > second_v3d.getZ());
                }
            }
            case GREATER_THAN_OR_EQUALS_TO -> {
                if (second instanceof ImmutableVector2i second_v2i) {
                    ImmutableVector2i self_v2i = (ImmutableVector2i) self;
                    result = (self_v2i.getX() >= second_v2i.getX()) && (self_v2i.getY() >= second_v2i.getY());
                } else if (second instanceof ImmutableVector2d second_v2d) {
                    ImmutableVector2d self_v2d = (ImmutableVector2d) self;
                    result = (self_v2d.getX() >= second_v2d.getX()) && (self_v2d.getY() >= second_v2d.getY());
                } else if (second instanceof ImmutableVector2f second_v2f) {
                    ImmutableVector2f self_v2f = (ImmutableVector2f) self;
                    result = (self_v2f.getX() >= second_v2f.getX()) && (self_v2f.getY() >= second_v2f.getY());
                } else if (second instanceof ImmutableVector2l second_v2l) {
                    ImmutableVector2l self_v2l = (ImmutableVector2l) self;
                    result = (self_v2l.getX() >= second_v2l.getX()) && (self_v2l.getY() <= second_v2l.getY());
                } else if (second instanceof ImmutableVector3i second_v3i) {
                    ImmutableVector3i self_v3d = (ImmutableVector3i) self;
                    result = (self_v3d.getX() >= second_v3i.getX()) && (self_v3d.getY() >= second_v3i.getY()) && (self_v3d.getZ() >= second_v3i.getZ());
                } else if (second instanceof ImmutableVector3d second_v3d) {
                    ImmutableVector3d self_v3d = (ImmutableVector3d) self;
                    result = (self_v3d.getX() >= second_v3d.getX()) && (self_v3d.getY() >= second_v3d.getY()) && (self_v3d.getZ() >= second_v3d.getZ());
                }
            }
            default -> {
            }
        }
        return result;
    }
}
