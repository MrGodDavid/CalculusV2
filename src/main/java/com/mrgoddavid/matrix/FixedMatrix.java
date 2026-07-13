package com.mrgoddavid.matrix;

/**
 * This class holds a collection of fixed matrices.
 *
 * @author Mr. GodDavid
 * @since 7/13/2026
 */
public final class FixedMatrix {

    /**
     * Special 2x1 matrix. This matrix has two rows and one column.
     *
     * @param a11 element at the position row 1 and column 1.
     * @param a21 element at the position row 2 and column 2.
     */
    public record Matrix21i(int a11, int a21) implements Matrix<Matrix21i> {

        /**
         * Addition of two same-sized matrices.
         *
         * @param other matrix that is not null.
         * @return the sum of the two matrices.
         */
        @Override
        public Matrix21i add(Matrix21i other) {
            return new Matrix21i(a11 + other.a11, a21 + other.a21);
        }

        /**
         * Subtraction of two same-sized matrices.
         *
         * @param other matrix that is not null.
         * @return the difference of the two matrices.
         */
        @Override
        public Matrix21i subtract(Matrix21i other) {
            return new Matrix21i(a11 - other.a11, a21 - other.a21);
        }

        /**
         * Scalar multiplication of matrix.
         *
         * @param scalar multiplier.
         * @return the scaled matrix.
         * @author Me. GodDavid
         * @since 7/13/2026 added this method.
         */
        @Override
        public Matrix21i scale(double scalar) {
            return new Matrix21i((int) (this.a11 * scalar), (int) (this.a21 * scalar));
        }
    }
}
