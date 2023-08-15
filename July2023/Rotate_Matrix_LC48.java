class Solution {
	public void rotate(int[][] matrix) {

		//Find the transpose first and then reverse the transpose
		int m = matrix.length;
		int n = matrix[0].length;
		for(int row=0;row<m;row++){
			for(int col=row;col<n;col++){
				int temp = matrix[row][col];
				matrix[row][col] = matrix[col][row];
				matrix[col][row] = temp;
			}
		}

		//Reverse the transposed matrix
		for(int i=0;i<m;i++){
			int row[] = matrix[i];
			for(int j=0;j<row.length/2;j++){
				int temp = row[j];
				row[j] = row[row.length-1-j];
				row[row.length-1-j] = temp;              
			}
		}
	}
}
