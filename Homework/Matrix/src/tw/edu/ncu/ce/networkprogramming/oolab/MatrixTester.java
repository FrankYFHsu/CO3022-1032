package tw.edu.ncu.ce.networkprogramming.oolab;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MatrixTester {


	
	@Test
	public void checkEqual() {
		double[][] a = {{0.0,0.0,0.0},{0.0,0.0,0.0}};
		double[][] b = {{1.0,0.0,0.0},{0.0,0.0,0.0}};
		Matrix matrixA = new Matrix(a);
		Matrix matrixB = new Matrix(b);
		System.out.println(matrixA);
		assertEquals(false,matrixA.equals(matrixB));
	}
	


	@Test
	public void checkConstructor1AndEqual() {
		double[][] a = {{0.0,0.0,0.0},{0.0,0.0,0.0}};
		Matrix matrixA = new Matrix(a);
		Matrix matrixB = new Matrix(2,3);
		assertEquals(true,matrixA.equals(matrixB));
	}
	
	@Test
	public void checkConstructor2AndEqual() {
		double[][] a = {{1.0,1.0,1.0},{1.0,1.0,1.0}};
		Matrix matrixA = new Matrix(a);
		Matrix matrixB = new Matrix(2,3,1);
		assertEquals(true,matrixA.equals(matrixB));
	}
	
	@Test
	public void checkMatrixAddition() {
		double[][] a = {{1.0,1.0,1.0},{1.0,1.0,1.0}};
		Matrix matrixA = new Matrix(a);
		Matrix matrixB = new Matrix(2,3,1);
		double[][] c = {{2.0,2.0,2.0},{2.0,2.0,2.0}};
		Matrix matrixC = new Matrix(c);
		assertEquals(true,matrixA.add(matrixB).equals(matrixC));
	}
	
	@Test
	public void checkMatrixSubtraction() {
		double[][] a = {{1.0,1.0,1.0},{1.0,1.0,1.0}};
		Matrix matrixA = new Matrix(a);
		Matrix matrixB = new Matrix(2,3,1);
		double[][] c = {{0.0,0.0,0.0},{0.0,0.0,0.0}};
		Matrix matrixC = new Matrix(c);
		assertEquals(true,matrixA.subtract(matrixB).equals(matrixC));
	}
	@Test
	public void checkMatrixMultiplication() {
		double[][] a = {{1.0,2.0,3.0},{4.0,5.0,6.0}};
		Matrix matrixA = new Matrix(a);
		Matrix matrixB = new Matrix(3,2,1);
		double[][] c = {{6.0,6.0},{15.0,15.0}};
		Matrix matrixC = new Matrix(c);
		System.out.println(matrixC);
		assertEquals(true,matrixA.multiply(matrixB).equals(matrixC));
	}
	@Test
	public void checkMatrixScalarMultiplication() {
		double[][] a = {{1.0,2.0,3.0},{4.0,5.0,6.0}};
		Matrix matrixA = new Matrix(a);
		double b = 2.0;
		double[][] c = {{2.0,4.0,6.0},{8.0,10.0,12.0}};
		Matrix matrixC = new Matrix(c);
		assertEquals(true,matrixA.scalarMultiply(b).equals(matrixC));
	}

}
