package com.mrgoddavid.transformation.rotation;

import com.mrgoddavid.expression.DoubleExpression;
import com.mrgoddavid.format.annotation.SingletonClass;
import com.mrgoddavid.geometry.angle.Radian;
import com.mrgoddavid.matrix.FixedMatrix;
import com.mrgoddavid.matrix.Matrix2d;

/**
 * A rotation matrix is the matrix that rotates a vector. This 2x2 rotation matrix rotates a two-dimensional vector in
 * two-dimensional space.
 * <p>It defines as following</p>
 * <pre>{@code
 * [cos(theta), -sin(theta)]
 * [sin(theta), cos(theta)]
 * }</pre>
 * This matrix is also a fixed-size matrix. Each element of this matrix is a trigonometric expression instead of a
 * numerical value.
 *
 * @author Mr. GodDavid
 * @since 7/24/2026 part of Transformation &amp; Circles Update.
 */
@SingletonClass
public final class RotationMatrix2x2 extends FixedMatrix {

    private static RotationMatrix2x2 instance;

    /**
     * The expression in row 1 and column 1.
     */
    private final DoubleExpression e11;

    /**
     * The expression in row 1 and column 2.
     */
    private final DoubleExpression e12;

    /**
     * The expression in row 2 and column 1.
     */
    private final DoubleExpression e21;

    /**
     * The expression in row 2 and column 2.
     */
    private final DoubleExpression e22;

    /**
     * No-argument constructor
     */
    @SuppressWarnings("Convert2MethodRef")
    private RotationMatrix2x2() {
        this.e11 = n -> Math.cos(n);
        this.e12 = n -> -Math.sin(n);
        this.e21 = n -> Math.sin(n);
        this.e22 = n -> Math.cos(n);
    }

    /**
     * Gets the instance of this class.
     *
     * @return the instance of this class.
     */
    public static RotationMatrix2x2 getInstance() {
        if (instance == null) {
            instance = new RotationMatrix2x2();
        }
        return instance;
    }

    /**
     * Evaluates this rotation matrix on input angle.
     *
     * @param angle in radians.
     * @return the rotation matrix at the given angle.
     */
    public Matrix2d atAngle(Radian angle) {
        return new Matrix2d(
                e11.calculate(angle.val()), e12.calculate(angle.val()),
                e21.calculate(angle.val()), e22.calculate(angle.val())
        );
    }
}
