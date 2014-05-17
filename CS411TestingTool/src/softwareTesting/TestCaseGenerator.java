package softwareTesting;

public class TestCaseGenerator {
	
	/*
	 * 6n + 1 test cases
	 */
	public static int[][] genROBBVA (int[][] inputs){
		
		//int uniqueCases = (6 * inputs) + 1; //unique test cases
		int numInputs = inputs.length;
		int totalTestCases = 7 * numInputs; //min-1, min, min+1, nom, max-1, max, max+1
		
		int[][] caseArray = new int[totalTestCases][numInputs];
		
		int colFaultIndex = numInputs - 1;
		
		for(int row=0; row < totalTestCases; row++){
			for(int col=0; col < numInputs; col++){
				
				if (col != colFaultIndex){ //is nomial
					caseArray[row][col] = (inputs[col][0] + inputs[col][1])/2;
				}else if (row % 7 == 0){
					caseArray[row][col] = inputs[col][0]-1;
				}else if (row % 7 == 1){
					caseArray[row][col] = inputs[col][0];
				}else if (row % 7 == 2){
					caseArray[row][col] = inputs[col][0]+1;
				}else if (row % 7 == 3){
					caseArray[row][col] = (inputs[col][0] + inputs[col][1])/2;;
				}else if (row % 7 == 4){
					caseArray[row][col] = inputs[col][1]-1;
				}else if (row % 7 == 5){
					caseArray[row][col] = inputs[col][1];
				}else if (row % 7 == 6){
					caseArray[row][col] = inputs[col][1]+1;
					colFaultIndex--;
				}else{
					caseArray[row][col] = -99;
				}
				
			}
		}
		
		return caseArray;
	}

	/*
	 * Results in 7^n test cases
	 */
	public static int[][] genROBWC (int inputs[][]){
		
		//int uniqueCases = (6 * inputs) + 1; //unique test cases
		
		int numInputs = inputs.length;
		int totalTestCases = (int)Math.pow(7, numInputs); //min-1, min, min+1, nom, max-1, max, max+1
		
		int[][] caseArray = new int[totalTestCases][numInputs];
		
		int[] a = {inputs[0][0]-1,inputs[0][0],inputs[0][0]+1,(inputs[0][0] + inputs[0][1])/2,inputs[0][1]-1,inputs[0][1],inputs[0][1]+1};
		int[] b = {inputs[1][0]-1,inputs[1][0],inputs[1][0]+1,(inputs[1][0] + inputs[1][1])/2,inputs[1][1]-1,inputs[1][1],inputs[1][1]+1};
		int[] c = {inputs[2][0]-1,inputs[2][0],inputs[2][0]+1,(inputs[2][0] + inputs[2][1])/2,inputs[0][1]-1,inputs[2][1],inputs[2][1]+1};
		
		int row = 0;
		int col = 0;
		
		for (int i=0; i < a.length; i++){
			for (int j=0; j < b.length; j++){
				for (int k=0; k < c.length; k++){
					caseArray[row][col] = a[i];
					caseArray[row][col+1] = b[j];
					caseArray[row][col+2] = c[k];
					row++;
				}
			}
		}
		
		return caseArray;
	}
	
	/*
	 * Results in 4n + 1 test cases where n is # of variables
	 * 
	 */
	public static int[][] genBVA (int[][] inputs){
		
		int numInputs = inputs.length;
		
		int totalTestCases = (5 * numInputs);
		int[][] caseArray = new int[totalTestCases][numInputs];
		
		int colFaultIndex = numInputs - 1;
		
		for(int row=0; row < totalTestCases; row++){
			for(int col=0; col < numInputs; col++){
				
				if (col != colFaultIndex){ //is nomial
					caseArray[row][col] = (inputs[col][0] + inputs[col][1])/2;
				}else if (row % 5 == 0){
					caseArray[row][col] = inputs[col][0];
				}else if (row % 5 == 1){
					caseArray[row][col] = inputs[col][0]+1;
				}else if (row % 5 == 2){
					caseArray[row][col] = (inputs[col][0] + inputs[col][1])/2;
				}else if (row % 5 == 3){
					caseArray[row][col] = inputs[col][1]-1;
				}else if (row % 5 == 4){
					caseArray[row][col] = inputs[col][1];
					colFaultIndex--;
				}else{
					caseArray[row][col] = -99;//error
				}
				
			}
		}
		
	return caseArray;
	}
	
	/*
	 * 5^n test cases
	 */
	public static int[][] genWC (int[][] inputs){
		
		int numInputs = inputs.length;
		
		int totalTestCases = (int)Math.pow(5, numInputs); //min-1, min, min+1, nom, max-1, max, max+1
		int[][] caseArray = new int[totalTestCases][numInputs];
		
		int[] a = {inputs[0][0],inputs[0][0]+1,(inputs[0][0] + inputs[0][1])/2,inputs[0][1]-1,inputs[0][1]};
		int[] b = {inputs[1][0],inputs[1][0]+1,(inputs[1][0] + inputs[1][1])/2,inputs[1][1]-1,inputs[1][1]};
		int[] c = {inputs[2][0],inputs[2][0]+1,(inputs[2][0] + inputs[2][1])/2,inputs[0][1]-1,inputs[2][1]};
		
		int row = 0;
		int col = 0;
		
		for (int i=0; i < a.length; i++){
			for (int j=0; j < b.length; j++){
				for (int k=0; k < c.length; k++){
					caseArray[row][col] = a[i];
					caseArray[row][col+1] = b[j];
					caseArray[row][col+2] = c[k];
					row++;
				}
			}
		}
		
		return caseArray;
		
	}
	
	public static void printCases(int[][] testCases){
		
		for(int row=0; row < testCases.length; row++){
			
			System.out.print("Case "+(row+1) +":\t");
			
			if((row+1) < 10){
				System.out.print("\t"); //format tabbing
			}
			
			for (int col=0; col < testCases[0].length; col++){
				
			System.out.print(testCases[row][col] +"\t");
			}
			
			int testCase[] = new int[3];
			
			testCase[0] = testCases[row][0];
			testCase[1] = testCases[row][1];
			testCase[2] = testCases[row][2];
			
			System.out.println("");
		}
		System.out.println();
	}
	

}
