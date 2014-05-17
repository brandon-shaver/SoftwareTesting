package softwareTesting;

public class Phase3 {

	public static void run(){
		
		System.out.println("Phase 3 started!");
		
		int[][] commissionInputs = {{1,77}, {1,88}, {1,99}};
		int[][] cases;
		
		cases = TestCaseGenerator.genBVA(commissionInputs);
		System.out.println("=====Commission Boundary Value Analysis=======");
		System.out.println("===============Locks====Stocks====Barrels=============");
		TestCaseGenerator.printCases(cases);
		
		int[] currentCase = new int[3];
		System.out.println("===CASE===============Observed=================Expected=======");
		for(int i=0; i < cases.length;i++){
			currentCase[0] = cases[i][0];
			currentCase[1] = cases[i][1];
			currentCase[2] = cases[i][2];
			System.out.println("Case:  "+ (i+1) + "\t   "+ TestCaseEvaluator.evalCommission(currentCase) + "\t\t"+ TestCaseEvaluator.evalCommission(currentCase));
		}
		System.out.println("");
		
		cases = TestCaseGenerator.genROBBVA(commissionInputs);
		System.out.println("=====Commission Robust Boundary Value Analysis=======");
		System.out.println("===============Locks====Stocks====Barrels=============");
		TestCaseGenerator.printCases(cases);
		
		System.out.println("===CASE===============Observed=================Expected=======");
		for(int i=0; i < cases.length;i++){
			currentCase[0] = cases[i][0];
			currentCase[1] = cases[i][1];
			currentCase[2] = cases[i][2];
			System.out.println("Case:  "+ (i+1) + "\t   "+ TestCaseEvaluator.evalCommission(currentCase) + "\t\t"+ TestCaseEvaluator.evalCommission(currentCase));
		}
		System.out.println("");
		
		cases = TestCaseGenerator.genWC(commissionInputs);
		System.out.println("=====Commission Worst Case=======");
		System.out.println("===============Locks====Stocks====Barrels=============");
		TestCaseGenerator.printCases(cases);
		
		System.out.println("===CASE===============Observed=================Expected=======");
		for(int i=0; i < cases.length;i++){
			currentCase[0] = cases[i][0];
			currentCase[1] = cases[i][1];
			currentCase[2] = cases[i][2];
			System.out.println("Case:  "+ (i+1) + "\t   "+ TestCaseEvaluator.evalCommission(currentCase) + "\t\t"+ TestCaseEvaluator.evalCommission(currentCase));
		}
		System.out.println("");
	}
	
}
