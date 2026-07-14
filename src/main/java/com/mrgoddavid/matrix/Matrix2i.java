package com.mrgoddavid.matrix;

/**
 * This class represents a 2x2 matrix. Each element of this matrix is an integer.
 *
 * @author Mr. GodDavid
 * @since 7/9/2026
 */
public class Matrix2i implements Matrix.Matrix2<Matrix2i>, Matrix.SquareMatrix<Matrix2i> {

    /*
     *       +---+---+
     *       | a | b |  <- row 1
     *       +---+---+
     *       | c | d |  <- row 2
     *       +---+---+
     *
     *       A = [ a b ]
     *           [ c d ]
     * a = r1c1
     * b = r2c1
     * c = r1c2
     * d = r2c2
     */
    private final int a, b, c, d;

    public Matrix2i() {
        this(0, 0, 0, 0);
    }

    public Matrix2i(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Matrix2i multiply(Matrix2i other) {
        return new Matrix2i(
                this.a * other.a + this.b * other.c, this.a * other.b + this.b * other.d,
                this.c * other.a + this.d * other.c, this.c * other.b + this.d * other.d
        );
    }

    public FixedMatrix.Matrix21i multiply(FixedMatrix.Matrix21i other) {
        return new FixedMatrix.Matrix21i(
                this.a * other.a11() + this.b * other.a21(),
                this.c * other.a11() + this.d * other.a21()
        );
    }

    /**
     * Addition of two same-sized matrices.
     *
     * @param other matrix that is not null.
     * @return the sum of the two matrices.
     */
    @Override
    public Matrix2i add(Matrix2i other) {
        return new Matrix2i(this.a + other.a, this.b + other.b, this.c + other.c, this.d + other.d);
    }

    /**
     * Subtraction of two same-sized matrices.
     *
     * @param other matrix that is not null.
     * @return the difference of the two matrices.
     */
    @Override
    public Matrix2i subtract(Matrix2i other) {
        return new Matrix2i(this.a - other.a, this.b - other.b, this.c - other.c, this.d - other.d);
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
    public Matrix2i scale(double scalar) {
        return new Matrix2i((int) (this.a * scalar), (int) (this.b * scalar), (int) (this.c * scalar), (int) (this.d * scalar));
    }

    /**
     * The transpose of a matrix is a new matrix formed by swapping its rows and columns. The rows of the original
     * matrix become the columns of the transposed matrix, and vice versa.
     *
     * @return the transpose of itself.
     */
    @Override
    public Matrix2i transpose() {
        return new Matrix2i(this.a, this.c, this.b, this.d);
    }

    /**
     * Calculates the inverse of 2x2 matrix.
     *
     * @return the inverse matrix of this 2x2 matrix.
     * @author Mr. GodDavid
     * @since 7/13/2026 added this method. Part of Plane-Intersection-Feature update in 7/13/2026.
     */
    @Override
    public Matrix2i inverse() {
        Matrix2i mat = new Matrix2i(this.d, -this.b, -this.c, this.a);
        double det = this.determinant();
        if (det == 0) {
            return null;
        }

        double multiplier = 1d / (det);
        return mat.scale(multiplier);
    }

    /**
     * Calculates the determinant of any square matrix.
     *
     * @return the determinant of a square matrix.
     */
    @Override
    public double determinant() {
        return a * d - b * c;
    }

    @Override
    public String toString() {
        return "[" + a + " " + b + "]\n" +
                "[" + c + " " + d + "]";
    }
}
