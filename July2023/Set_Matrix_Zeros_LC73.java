class Solution {
	//Brute Force O((m+n)*(m*n)) ~ O(n^3)
	private void fillRow(int[][] matrix,int row,int col,int index){
		for(int i=0;i<row;i++){
			if(matrix[index][i]!=0){
				matrix[index][i] = -1;
			}
		}

	}
	private void fillCol(int[][] matrix,int row,int col,int index){
		for(int j=0;j<col;col++){
			if(matrix[index][j]!=0){
				matrix[index][j] = -1;
			}
		}
	}

	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		int[][] zero_index = new int[1][1];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(matrix[i][j]==0){
					fillRow(matrix,m,n,i);
					fillCol(matrix,m,n,j);
				}
			}
		}

		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(matrix[i][j]==-1){
					matrix[i][j]=0;
				}
			}
		}

	}

	//Better approach O(2*m*n) uses extra memory of O(m+n)
	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		int[] row_hash = new int[m];
		int[] col_hash = new int[n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(matrix[i][j]==0){
					row_hash[i] = 1;
					col_hash[j] = 1;
				}
			}
		}

		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(row_hash[i]==1){
					matrix[i][j]=0;
				}
				if(col_hash[j]==1){
					matrix[i][j]=0;
				}
			}


			//Optimal approach O(2*m*n)
			public void setZeroes(int[][] matrix) {
				int m = matrix.length;
				int n = matrix[0].length;

				int col0 = 1;
				for(int i=0;i<m;i++){
					for(int j=0;j<n;j++){
						if(matrix[i][j]==0){
							matrix[i][0] = 0;
							if(j>0){
								matrix[0][j] = 0;
							}else{
								col0=0;
							}
						}
					}
				}

				for(int i=1;i<m;i++){
					for(int j=1;j<n;j++){
						if(matrix[i][j]!=0){
							if(matrix[i][0]==0 || matrix[0][j]==0){
								matrix[i][j]=0;
							}
						}
					}
				}

				if(matrix[0][0] == 0){
					for(int j=0;j<n;j++){
						matrix[0][j]=0;
					}
				}

				if(col0 == 0){
					for(int i=0;i<m;i++){
						matrix[i][0]=0;
					}
				}

			}}


	}
