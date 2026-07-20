package com.mrgoddavid.matrix;

/**
 * This class holds a collection of fixed matrices. We call a matrix with known size a "Fixed Matrix". Follow this rule
 * when reading the class names. The first number after the word "Matrix" indicates the number of rows in that matrix,
 * and the second number indicates the number of columns of that matrix. The last letter is the first-letter initial of
 * the data type of each element in that matrix. For instance, "i" represents integers, "d" represents double, "l"
 * represents long, and "f" represents float.
 *
 * @author Mr. GodDavid
 * @since 7/13/2026
 */
public final class FixedMatrix {

    /**
     * Empty constructor.
     */
    public FixedMatrix() {
    }

    /**
     * This is a fixed matrix. This matrix has two rows and one column. Each element of this matrix is an integer.
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
         * @since 7/13/2026 added this method.
         */
        @Override
        public Matrix21i scale(double scalar) {
            return new Matrix21i((int) (this.a11 * scalar), (int) (this.a21 * scalar));
        }
    }

    public record Matrix21d(double a11, double a21) implements Matrix<Matrix21d> {

        /**
         * Addition of two same-sized matrices.
         *
         * @param other matrix that is not null.
         * @return the sum of the two matrices.
         */
        @Override
        public Matrix21d add(Matrix21d other) {
            return new Matrix21d(a11 + other.a11, a21 + other.a21);
        }

        /**
         * Subtraction of two same-sized matrices.
         *
         * @param other matrix that is not null.
         * @return the difference of the two matrices.
         */
        @Override
        public Matrix21d subtract(Matrix21d other) {
            return new Matrix21d(a11 - other.a11, a21 - other.a21);
        }

        /**
         * Scalar multiplication of matrix.
         *
         * @param scalar multiplier.
         * @return the scaled matrix.
         * @since 7/13/2026 added this method.
         */
        @Override
        public Matrix21d scale(double scalar) {
            return new Matrix21d(a11 * scalar, a21 * scalar);
        }
    }
}
