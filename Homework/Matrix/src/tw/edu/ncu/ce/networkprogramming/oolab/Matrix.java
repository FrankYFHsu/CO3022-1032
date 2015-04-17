package tw.edu.ncu.ce.networkprogramming.oolab;


public class Matrix {
	
	//TODO define member variables


	//TODO define constructors
	


	public Matrix add(Matrix val) {

		//TODO

	}

	@Override 
	 public boolean equals(Object other) { 
		 
		 if(this == other){
			 return true;
		 }
		 
		 if (!(other instanceof Matrix)){
			 return false;
		 }
		 
		 Matrix matrix = (Matrix) other;
		 
		 // TODO 
	  
	 return true; 
	 }



	public Matrix multiply(Matrix val) {
		//TODO 
	}

	public Matrix scalarMultiply(double val) {
		//TODO
	}

	public Matrix subtract(Matrix val) {

		//TODO
	}
	
	/*
	@Override
	public String toString(){
		
		
	}
	*/
	
	private String getMatrixString(double[][] array) {

		StringBuffer strings = new StringBuffer();

		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {

				if (column == 0) {
					strings.append("| ");
				}
				strings.append(array[row][column]);
				if (column != array[row].length - 1) {
					strings.append(" ");
				} else {
					strings.append(" |\n");
				}
			}
		}
		return strings.toString();
	}

}
