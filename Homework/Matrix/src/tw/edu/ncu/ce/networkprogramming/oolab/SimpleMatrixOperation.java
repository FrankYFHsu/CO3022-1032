package tw.edu.ncu.ce.networkprogramming.oolab;

import javax.swing.JOptionPane;

public class SimpleMatrixOperation {

	public static void main(String[] args) {

		int TEST_CASES = 2;

		String[] operations = { "+", "-", "X" };

		String chosenOperation = (String) JOptionPane.showInputDialog(null, "請輸入運算",
				"矩陣運算", JOptionPane.PLAIN_MESSAGE, null, operations, "+");

		if (chosenOperation == null) {
			System.exit(0);
		}

		Matrix[] matrices = new Matrix[TEST_CASES];

		for (int i = 0; i < TEST_CASES; i++) {

			String matrixDimensionFromDialog = JOptionPane
					.showInputDialog("請輸入第" + (i + 1) + "個矩陣大小:n m(中間空白隔開)");

			String[] dimensions = matrixDimensionFromDialog.split(" ");

			int rowDimension = Integer.parseInt(dimensions[0]);

			int columnDimension = Integer.parseInt(dimensions[1]);

			//TODO 
			// matrices[i] = ?
			System.out.println(matrices[i]);

		}

		Matrix result = null;
		switch (chosenOperation) {

		case "+":
			//TODO result =?
			break;
		case "-":
			//TODO result =?
			break;
		case "X":
			//TODO result =?
			break;

		}
		System.out.println("=====結果=====");
		System.out.println(result);

	}

	// You will call this method
	public static double[][] getMatrixFromDialogInput(int rowDimension,
			int columnDimension, String title) {

		double[][] matrixFromDialog = new double[rowDimension][columnDimension];
		for (int row = 0; row < rowDimension; row++) {

			String stringFromDialog = JOptionPane.showInputDialog(title + "第"
					+ (row + 1) + "列(行數為" + columnDimension + ")");

			String[] values = stringFromDialog.split(" ");
			// String[] values = stringFromDialog.split("\\s");// 在正則表示式裡\s為空元

			for (int column = 0; column < columnDimension; column++) {

				matrixFromDialog[row][column] = Integer
						.parseInt(values[column]);
			}
		}

		return matrixFromDialog;
	}

}
