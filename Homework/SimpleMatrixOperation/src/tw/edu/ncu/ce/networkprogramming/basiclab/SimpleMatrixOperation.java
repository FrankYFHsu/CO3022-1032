package tw.edu.ncu.ce.networkprogramming.basiclab;

import javax.swing.JOptionPane;

public class SimpleMatrixOperation {

	public static void main(String[] args) {

		String input = JOptionPane.showInputDialog("請輸入矩陣大小 n");
		int matrixSize = Integer.parseInt(input);
		// TODO
		int[][] myMatrix = getMatrixFromDialogInput(matrixSize, "請輸入第一個矩陣");

	}

	public static int[][] getMatrixFromDialogInput(int matrixSize, String title) {

		int[][] matrixFromDialog = new int[matrixSize][matrixSize];
		for (int row = 0; row < matrixSize; row++) {

			String stringFromDialog = JOptionPane.showInputDialog(title + "第"
					+ (row + 1) + "列");

			String[] values = stringFromDialog.split(" ");

			for (int column = 0; column < matrixSize; column++) {

				matrixFromDialog[row][column] = Integer
						.parseInt(values[column]);
			}
		}

		return matrixFromDialog;
	}
}
