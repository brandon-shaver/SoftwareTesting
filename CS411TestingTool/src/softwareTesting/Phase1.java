package softwareTesting;

public class Phase1 {
	
	public static void run(){
		
		System.out.println("Phase 1 started!");
		
		int[][] triInputs ={{5,205}, {5,205}, {5,205}};
		int[][] cases;
		
		cases = TestCaseGenerator.genROBBVA(triInputs);
		System.out.println("=====Triangle Robust Boundary Value Analysis=======");
		System.out.println("============SIDE A    SIDE B   SIDE C=======");
		TestCaseGenerator.printCases(cases);
		
		int[] currentCase = new int[3];
		System.out.println("===CASE===============Observed=================Expected=======");
		for(int i=0; i < cases.length;i++){
			currentCase[0] = cases[i][0];
			currentCase[1] = cases[i][1];
			currentCase[2] = cases[i][2];
			System.out.println("Case:  "+ (i+1) + "\t   "+ TestCaseEvaluator.evalTriangle(currentCase) + "\t\t"+ TestCaseEvaluator.evalTriangle(currentCase));
		}
		System.out.println("");
		
		cases = TestCaseGenerator.genROBWC(triInputs);
		System.out.println("=====Triangle Robust Worst Case=======");
		System.out.println("============SIDE A    SIDE B   SIDE C=======");
		TestCaseGenerator.printCases(cases);
		
		System.out.println("===CASE===============Observed=================Expected=======");
		for(int i=0; i < cases.length;i++){
			currentCase[0] = cases[i][0];
			currentCase[1] = cases[i][1];
			currentCase[2] = cases[i][2];
			System.out.println("Case:  "+ (i+1) + "\t   "+ TestCaseEvaluator.evalTriangle(currentCase) + "\t\t"+ TestCaseEvaluator.evalTriangle(currentCase));
		}
		System.out.println("");
		
	}

}
