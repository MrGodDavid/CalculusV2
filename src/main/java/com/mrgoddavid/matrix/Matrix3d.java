package com.mrgoddavid.matrix;

import com.mrgoddavid.vector.immutable.ImmutableVector3d;
import com.mrgoddavid.vector.immutable.ImmutableVector3i;

import java.io.Serial;

/**
 * This class constructs a 3x3 matrix. Each element of this matrix is an integer.
 *
 * @author Mr. GodDavid
 * @since 7/13/2026
 */
public class Matrix3d implements Matrix.SquareMatrix<Matrix3d> {

    /**
     * Identity matrix of this 3x3 square matrix.
     */
    public static final Matrix3d IDENTITY = new Matrix3d(
            1d, 0d, 0d,
            0d, 1d, 0d,
            0d, 0d, 1d
    );

    @Serial
    private static final long serialVersionUID = 669933540821370500L;

    /*
     *             c1    c2    c3
     *          +-----+-----+-----+
     *      r1  | a11 | a12 | a13 |
     *          +-----+-----+-----+
     *      r2  | a21 | a22 | a23 |
     *          +-----+-----+-----+
     *      r3  | a31 | a32 | a33 |
     *          +-----+-----+-----+
     *
     *      Entry aij is located at row i, column j.
     */
    /**
     * The element at row 1 and column 1.
     */
    private final double a11;
    /**
     * The element at row 1 and column 2.
     */
    private final double a12;
    /**
     * The element at row 1 and column 3.
     */
    private final double a13;
    /**
     * The element at row 2 and column 1.
     */
    private final double a21;
    /**
     * The element at row 2 and column 2.
     */
    private final double a22;
    /**
     * The element at row 2 and column 3.
     */
    private final double a23;
    /**
     * The element at row 3 and column 1.
     */
    private final double a31;
    /**
     * The element at row 3 and column 2.
     */
    private final double a32;
    /**
     * The element at row 3 and column 3.
     */
    private final double a33;

    /**
     * Constructs a default 3x3 matrix.
     */
    public Matrix3d() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    /**
     * Constructs a 3x3 matrix with each element is a double.
     *
     * @param a11 the element at row 1 and column 1.
     * @param a12 the element at row 1 and column 2.
     * @param a13 the element at row 1 and column 3.
     * @param a21 the element at row 2 and column 1.
     * @param a22 the element at row 2 and column 2.
     * @param a23 the element at row 2 and column 3.
     * @param a31 the element at row 3 and column 1.
     * @param a32 the element at row 3 and column 2.
     * @param a33 the element at row 3 and column 3.
     */
    public Matrix3d(double a11, double a12, double a13, double a21, double a22, double a23, double a31, double a32, double a33) {
        this.a11 = a11;
        this.a12 = a12;
        this.a13 = a13;
        this.a21 = a21;
        this.a22 = a22;
        this.a23 = a23;
        this.a31 = a31;
        this.a32 = a32;
        this.a33 = a33;
    }

    /**
     * Constructs a 3x3 matrix from the 3x3 2d array.
     *
     * @param matrix 3x3 2d array that is not null.
     */
    public Matrix3d(double[][] matrix) {
        if (matrix.length != 3 || matrix[0].length != 3) {
            throw new IllegalArgumentException("Matrix length must be == 3");
        }
        this.a11 = matrix[0][0];
        this.a12 = matrix[0][1];
        this.a13 = matrix[0][2];
        this.a21 = matrix[1][0];
        this.a22 = matrix[1][1];
        this.a23 = matrix[1][2];
        this.a31 = matrix[2][0];
        this.a32 = matrix[2][1];
        this.a33 = matrix[2][2];
    }

    /**
     * Converts its determinant to 3d vector.
     *
     * @return the converted 3d vector from its determinant.
     */
    public ImmutableVector3d determinantToVector() {
        return new MatrixV3d().determinantToVector3d();
    }

    /**
     * Calculates the determinant of any square matrix.
     *
     * @return the determinant of a square matrix.
     */
    @Override
    public double determinant() {
        return firstDeterminant() - secondDeterminant() + thirdDeterminant();
    }

    /**
     * Calculate the determinant of the sub matrix of this 3x3 matrix. The submatrix consists of elements a22, a23, a32,
     * a33
     *
     * @return the determinant of submatrix.
     */
    public double firstDeterminant() {
        return new Matrix2d(a22, a23, a32, a33).determinant();
    }

    /**
     * Calculate the determinant of the sub matrix of this 3x3 matrix. The submatrix consists of elements a21, a23, a31,
     * a33
     *
     * @return the determinant of submatrix.
     */
    public double secondDeterminant() {
        return new Matrix2d(a21, a23, a31, a33).determinant();
    }

    /**
     * Calculate the determinant of the sub matrix of this 3x3 matrix. The submatrix consists of elements a21, a22, a31,
     * a32.
     *
     * @return the determinant of submatrix.
     */
    public double thirdDeterminant() {
        return new Matrix2d(a21, a22, a31, a32).determinant();
    }


    /**
     * Addition of two same-sized matrices.
     *
     * @param other matrix that is not null.
     * @return the sum of the two matrices.
     */
    @Override
    public Matrix3d add(Matrix3d other) {
        return new Matrix3d(
                a11 + other.a11, a12 + other.a12, a13 + other.a13,
                a21 + other.a21, a22 + other.a22, a23 + other.a23,
                a31 + other.a31, a32 + other.a32, a33 + other.a33
        );
    }

    /**
     * Subtraction of two same-sized matrices.
     *
     * @param other matrix that is not null.
     * @return the difference of the two matrices.
     */
    @Override
    public Matrix3d subtract(Matrix3d other) {
        return new Matrix3d(
                a11 - other.a11, a12 - other.a12, a13 - other.a13,
                a21 - other.a21, a22 - other.a22, a23 - other.a23,
                a31 - other.a31, a32 - other.a32, a33 - other.a33
        );
    }

    /**
     * Scalar multiplication of matrix.
     *
     * @param scalar multiplier.
     * @return the scaled matrix.
     * @since 7/13/2026 added this method.
     */
    @Override
    public Matrix3d scale(double scalar) {
        return new Matrix3d(
                a11 * scalar, a12 * scalar, a13 * scalar,
                a21 * scalar, a22 * scalar, a23 * scalar,
                a31 * scalar, a32 * scalar, a33 * scalar
        );
    }

    /**
     * Special 3x3 matrix that contains i, j, and k in the first row.
     *
     * @author Mr. GodDavid
     * @since 7/13/2026
     */
    public class MatrixV3d implements Matrix.VectorMatrix<MatrixV3d> {

        /**
         * Default constructor. Empty constructor.
         */
        public MatrixV3d() {
        }

        /**
         * Calculates the determinant of this special vector.
         *
         * @return the determinant (which is also a three-dimensional vector).
         * @deprecated not suitable for this class. The returned result should be doubles instead of integers.
         */
        @Override
        @Deprecated
        public ImmutableVector3i determinantToVector() {
            return null;
        }

        /**
         * Converts its determinant to three-dimensional vector with double in each component.
         *
         * @return the three-dimensional vector that has double for each its component.
         */
        public ImmutableVector3d determinantToVector3d() {
            double i = firstDeterminant();
            double j = -secondDeterminant();
            double k = thirdDeterminant();
            return new ImmutableVector3d(i, j, k);
        }

        /**
         * Calculates the determinant of any square matrix.
         *
         * @return the determinant of a square matrix.
         * @deprecated not suitable for this class usage.
         */
        @Deprecated
        @Override
        public double determinant() {
            return -999;
        }

        /**
         * Addition of two same-sized matrices.
         *
         * @param other matrix that is not null.
         * @return the sum of the two matrices.
         * @deprecated not suitable for using this method here.
         */
        @Deprecated
        @Override
        public MatrixV3d add(MatrixV3d other) {
            return null;
        }

        /**
         * Subtraction of two same-sized matrices.
         *
         * @param other matrix that is not null.
         * @return the difference of the two matrices.
         * @deprecated not suitable for using this method here.
         */
        @Deprecated
        @Override
        public MatrixV3d subtract(MatrixV3d other) {
            return null;
        }

        /**
         * Scalar multiplication of matrix.
         *
         * @param scalar multiplier.
         * @return the scaled matrix.
         * @since 7/13/2026 added this method.
         * @deprecated not suitable for using this method here.
         */
        @Deprecated
        @Override
        public MatrixV3d scale(double scalar) {
            return null;
        }
    }
}
