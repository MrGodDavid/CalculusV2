package com.mrgoddavid.matrix;

import com.mrgoddavid.vector.Vector3i;

/**
 * This class constructs a 3x3 matrix. Each element of this matrix is an integer.
 *
 * @author Mr. GodDavid
 * @since 7/9/2026
 */
public class Matrix3i implements Matrix.SquareMatrix<Matrix3i> {

    /**
     * Identity matrix of this 3x3 matrix.
     */
    public static final Matrix3i IDENTITY = new Matrix3i(
            1, 0, 0,
            0, 1, 0,
            0, 0, 1
    );

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
    private final int a11;
    /**
     * The element at row 1 and column 2.
     */
    private final int a12;
    /**
     * The element at row 1 and column 3.
     */
    private final int a13;
    /**
     * The element at row 2 and column 1.
     */
    private final int a21;
    /**
     * The element at row 2 and column 2.
     */
    private final int a22;
    /**
     * The element at row 2 and column 3.
     */
    private final int a23;
    /**
     * The element at row 3 and column 1.
     */
    private final int a31;
    /**
     * The element at row 3 and column 2.
     */
    private final int a32;
    /**
     * The element at row 3 and column 3.
     */
    private final int a33;

    /**
     * Constructs a default 3x3 matrix.
     */
    public Matrix3i() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    /**
     * Constructs a 3x3 matrix with each element is an integer.
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
    public Matrix3i(int a11, int a12, int a13, int a21, int a22, int a23, int a31, int a32, int a33) {
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
    public Matrix3i(int[][] matrix) {
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
     * {@link MatrixV3i#determinantToVector()}.
     *
     * @return the determinant of vector 3x3 matrix.
     */
    public Vector3i determinantToVector() {
        return new MatrixV3i().determinantToVector();
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
    public int firstDeterminant() {
        return (int) new Matrix2i(a22, a23, a32, a33).determinant();
    }

    /**
     * Calculate the determinant of the sub matrix of this 3x3 matrix. The submatrix consists of elements a21, a23, a31,
     * a33
     *
     * @return the determinant of submatrix.
     */
    public int secondDeterminant() {
        return (int) new Matrix2i(a21, a23, a31, a33).determinant();
    }

    /**
     * Calculate the determinant of the sub matrix of this 3x3 matrix. The submatrix consists of elements a21, a22, a31,
     * a32.
     *
     * @return the determinant of submatrix.
     */
    public int thirdDeterminant() {
        return (int) new Matrix2i(a21, a22, a31, a32).determinant();
    }

    /**
     * Addition of two same-sized matrices.
     *
     * @param other matrix that is not null.
     * @return the sum of the two matrices.
     */
    @Override
    public Matrix3i add(Matrix3i other) {
        return new Matrix3i(
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
    public Matrix3i subtract(Matrix3i other) {
        return new Matrix3i(
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
    public Matrix3i scale(double scalar) {
        return new Matrix3i(
                (int) (a11 * scalar), (int) (a12 * scalar), (int) (a13 * scalar),
                (int) (a21 * scalar), (int) (a22 * scalar), (int) (a23 * scalar),
                (int) (a31 * scalar), (int) (a32 * scalar), (int) (a33 * scalar)
        );
    }

    /**
     * Special 3x3 matrix that is used for calculating the cross product of two three-dimensional vectors.
     *
     * @author Mr. GodDavid
     * @since 7/9/2026
     */
    public class MatrixV3i implements Matrix.VectorMatrix<MatrixV3i> {

        /**
         * Empty constructor.
         */
        public MatrixV3i() {
        }

        /**
         * Calculates the determinant of this special vector.
         *
         * @return the determinant (which is also a three-dimensional vector).
         */
        @Override
        public Vector3i determinantToVector() {
            int i = firstDeterminant();
            int j = -secondDeterminant();
            int k = thirdDeterminant();
            return new Vector3i(i, j, k);
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
        public MatrixV3i add(MatrixV3i other) {
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
        public MatrixV3i subtract(MatrixV3i other) {
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
        public MatrixV3i scale(double scalar) {
            return null;
        }
    }
}
