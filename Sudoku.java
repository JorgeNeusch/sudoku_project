
import java.util.Random;
import java.util.ArrayList;
public class Sudoku {
	
	int arr[][] = new int[9][9];
	
	Random rand = new Random();
	
	ArrayList<Integer> nums = new ArrayList<Integer>();
	
	public boolean checkRow(int row, int num) {
		
		for(int i = 0; i < 9; ++i) {
			if(num == arr[row][i]) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean checkCol(int col, int num) {
		
		for(int i = 0; i < 9; ++i) {
			if(num == arr[i][col]) {
				return false;
			}
		}
		return true;
		
	}
	
	public boolean checkSquare(int row, int col, int num) {
		
		int rowLowBound = 0;
		int rowHighBound = 0;
		int colLowBound = 0;
		int colHighBound = 0;
		
		if(row<=2) {
			rowLowBound = 0;
			rowHighBound = 2;
		}
		else if (row<=5) {
			rowLowBound = 3;
			rowHighBound = 5;
		}
		else if (row<=8) {
			rowLowBound = 6;
			rowHighBound = 8;
		}
		
		if(col<=2) {
			colLowBound = 0;
			colHighBound = 2;
		}
		else if (col<=5) {
			colLowBound = 3;
			colHighBound = 5;
		}
		else if (col<=8) {
			colLowBound = 6;
			colHighBound = 8;
		}
		
		for(int i = rowLowBound; i <= rowHighBound; ++i) {
			
			for(int j = colLowBound; j <= colHighBound; ++j) {
				
				if(num == arr[i][j])
					return false;
			}
			
		}
		
		return true;
		
	}
	
	public void printSudoku() {
		
		for(int i = 0; i < 9; ++i) {
			for(int j = 0; j < 9; ++j) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
			
		}
	}
	
	public void fillSudoku() {
		
		for(int i = 0; i < 9; ++i) {
			for(int j = 0; j < 9; ++j) {
				arr[i][j] = getNum(i,j);
				
				if(arr[i][j] == -1) {
					i = 0;
					j = -1;
				}
				
				
			}
		}
		
		
	}
	
	public int getNum(int row, int col) {
		
		// builds a list of valid numbers that follow the rules
		for(int x = 1; x <= 9; ++x) {
			
			boolean isAvailable = true;
			
			if(!checkRow(row, x)) {
				isAvailable = false;
			}
			else if (!checkCol(col, x)) {
				isAvailable = false;
			}
			else if (!checkSquare(row, col, x)) {
				isAvailable = false;
			}
			
			if(isAvailable) {
				nums.add(x);
			}
			
			
		}
		// if nums is zero, then we must reset the board and try again
		if(nums.size()==0) {
			// resets board
			for(int v = 0; v < 9; ++v) {
				for(int z = 0; z < 9; ++z) {
					arr[v][z] = 0;
				}
			}
			
			return -1;
		}
		
		int nextNum = nums.get(rand.nextInt(nums.size()));
		
		nums.clear();
		
		return nextNum;
		
	}
	
	

}
