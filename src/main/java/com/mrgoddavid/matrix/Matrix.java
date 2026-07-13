package com.mrgoddavid.matrix;

import com.mrgoddavid.vector.Vector3i;

/**
 * This is the root interface of matrices. This interface contains all operations of matrices.
 *
 * @author Mr. GodDavid
 * @since 6/9/2026
 */
public interface Matrix<T> {

    /**
     * Contains operations of square matrices.
     *
     * @param <T> Class type of implementation of this interface.
     * @author Mr. GodDavid
     * @since 6/9/2026
     */
    interface SquareMatrix<T> extends Matrix<T> {

        /**
         * Calculates the determinant of any square matrix.
         *
         * @return the determinant of a square matrix.
         */
        double determinant();
    }

    /**
     * This interface contains all operations of 2x2 matrices.
     *
     * @param <T> Class type of implementation of this interface.
     * @author Mr. GodDavid
     * @since 6/9/2026
     */
    interface Matrix2<T> extends SquareMatrix<T> {

        /**
         * The transpose of a matrix is a new matrix formed by swapping its rows and columns. The rows of the original
         * matrix become the columns of the transposed matrix, and vice versa.
         *
         * @return the transpose of itself.
         */
        T transpose();

        /**
         * Calculates the inverse of 2x2 matrix.
         *
         * @return the inverse matrix of this 2x2 matrix.
         * @author Mr. GodDavid
         * @since 7/13/2026 added this method. Part of Plane-Intersection-Feature update in 7/13/2026.
         */
        T inverse();

        /**
         * The size by rows of a 2x2 matrix is 2.
         *
         * @return 2 because a 2x2 matrix has 2 rows.
         */
        default int rowSize() {
            return 2;
        }

        /**
         * The size by columns of a 2x2 matrix is 2.
         *
         * @return 2 because a 2x2 matrix has 2 columns.
         */
        default int columnSize() {
            return 2;
        }
    }

    /**
     * This interface contains all operations of 3x3 matrices.
     *
     * @param <T> Class type of implementation of this interface.
     * @author Mr. GodDavid
     * @since 6/9/2026
     */
    interface Matrix3<T> extends SquareMatrix<T> {

    }

    /**
     * Special 3x3 matrix that is used for calculating the cross product of two three-dimensional vectors.
     *
     * @param <T> Class type of implementation of this interface.
     * @author Mr. GodDavid
     * @since 6/9/2026
     */
    interface VectorMatrix<T> extends Matrix3<T> {

        /**
         * Calculates the determinant of this special vector.
         *
         * @return the determinant (which is also a three-dimensional vector).
         */
        Vector3i determinantToVector();
    }

    /**
     * Addition of two same-sized matrices.
     *
     * @param other matrix that is not null.
     * @return the sum of the two matrices.
     */
    T add(T other);

    /**
     * Subtraction of two same-sized matrices.
     *
     * @param other matrix that is not null.
     * @return the difference of the two matrices.
     */
    T subtract(T other);

    /**
     * Scalar multiplication of matrix.
     *
     * @param scalar multiplier.
     * @return the scaled matrix.
     * @author Me. GodDavid
     * @since 7/13/2026 added this method.
     */
    T scale(double scalar);
}
