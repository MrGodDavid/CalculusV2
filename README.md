# CalculusV2

A Java vector and matrix mathematics library designed for **Calculus III**, **linear algebra**, **computer graphics**, **game development**, and **scientific computing**.

CalculusV2 provides clean, object-oriented implementations of mathematical structures such as vectors, matrices, lines, planes, and geometric transformations.

The goal of this project is to create an easy-to-use Java mathematics toolkit for students, developers, and researchers who need reliable mathematical operations.

---

# Features

## Vector Mathematics

- 2D, 3D, and 4D vectors
- Vector addition and subtraction
- Scalar multiplication
- Dot product
- Cross product
- Magnitude calculations
- Normalization
- Distance calculations
- Projection

Example:

```java
Vector3i a = new Vector3i(1, 2, 3);

Vector3i b = new Vector3i(4, 5, 6);

Vector3i result = a.cross(b);
```

---

## Matrix Mathematics

Supported operations:

- Matrix addition
- Matrix subtraction
- Scalar multiplication
- Matrix multiplication
- Transpose
- Determinants
- Inverse matrices
- Identity matrices

Example:

```java
Matrix3d matrix = Matrix3d.identity();

Vector3d result = matrix.multiply(vector);
```

---

## Calculus III Geometry

Designed for topics commonly covered in Multivariable Calculus:

- Lines in 3D space
- Planes
- Normal vectors
- Parametric equations
- Vector fields
- Geometric transformations

Example:

```java
import com.mrgoddavid.vector.space.plane.RestrictedPlane3d;

RestrictedPlane3d plane = new RestrictedPlane3d(
        2.3, 1.2, 1.1, 7.5
);
```

---

# Installation

CalculusV2 is available through **JitPack**.

## Step 1: Add the JitPack repository

Add this to your `pom.xml`:

```xml
<repositories>

    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>

</repositories>
```

---

## Step 2: Add the dependency

```xml
<dependency>
    <groupId>com.github.MrGodDavid</groupId>
    <artifactId>CalculusV2</artifactId>
    <version>v1.2.0</version>
</dependency>
```

Replace:

```
v1.2.0
```

with the latest release version.

---

# Basic Usage

## Creating a Vector

```java
import com.mrgoddavid.vector.Vector3d;

Vector3d velocity = new Vector3D(10, 5, 0);
```

---

## Vector Addition

```java
Vector3d a = new Vector3D(1,2,3);

Vector3d b = new Vector3D(4,5,6);


Vector3d sum = a.add(b);
```

Result:

```
(5,7,9)
```

---

## Dot Product

The dot product measures the projection relationship between two vectors.

```java
double result = a.dot(b);
```

---

## Cross Product

The cross product returns a vector perpendicular to two input vectors.

```java
Vector3D normal = a.cross(b);
```
---

# Documentation

CalculusV2 provides complete JavaDoc documentation.

The release package includes:

```
CalculusV2.jar
CalculusV2-sources.jar
CalculusV2-javadoc.jar
```

IntelliJ IDEA users can access:

- Method descriptions
- Parameter explanations
- Source navigation
- API documentation

---

# Testing

CalculusV2 uses **JUnit 5** for unit testing.

Run all tests:

```bash
mvn test
```

Run a complete build:

```bash
mvn clean package
```

Example test:

```java
@Test
void crossProductShouldReturnPerpendicularVector()
{
    Vector3d x =
        new Vector3D(1,0,0);

    Vector3d y =
        new Vector3D(0,1,0);


    Vector3d result =
        x.cross(y);


    assertEquals(0,result.dot(x));
    assertEquals(0,result.dot(y));
}
```

---

# Requirements

## Development

- Java 21+
- Maven 3.9+
- JUnit 5

## Runtime

- Java 21+

---

# Roadmap

Future features:

- [ ] Quaternion mathematics
- [ ] Eigenvalues and eigenvectors
- [ ] Advanced linear algebra algorithms
- [ ] Vector fields
- [ ] Gradient, divergence, and curl operations
- [ ] Numerical integration tools
- [ ] Physics-oriented transformations

---

See:

```
LICENSE
```

for details.

---

# Author

**David Liu**

GitHub:

https://github.com/MrGodDavid

Project:

https://github.com/MrGodDavid/CalculusV2

---

# Acknowledgments

Inspired by mathematical libraries and tools used in:

- Linear algebra
- Computer graphics
- Game development
- Scientific computing

Built with Java and Maven.

-> Generated with ChatGPT <-