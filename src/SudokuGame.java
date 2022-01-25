

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SudokuGame {
	
	private static int[][][][] sud = new int[3][3][3][3];
	private static int[][] tester = new int[9][9]; 
    private static int[][] tester2 = new int[9][9];
	
	//testing suduku answer this one sudu answer for testing 
//	 private static int[][][][] sud = {{{{1,2,3},{4,5,6},{7,8,9}},{{7,8,9},{1,2,3},{4,5,6}},{{4,5,6},{7,8,9},{1,2,3}}}
//		,{{{3,1,2},{8,4,5},{9,6,7}},{{6,9,7},{3,1,2},{8,4,5}},{{8,4,5},{6,9,7},{3,1,2}}}
//		,{{{2,3,1},{5,7,4},{6,9,8}},{{9,6,8},{2,3,1},{5,7,4}},{{5,7,4},{9,6,8},{2,3,1}}}};
	
	
	
	
	
	private static Scanner sc = new Scanner(System.in);
		
	    public static void main(String[] args)  {
	    	
	    	System.out.println(
	    	" r is big box row \n"+
	    	" j is big box column \n"+ 
	    	" i small box row \n" + 
	    	" z is small box column \n");
	    	

	    	userInput();
	    	
	    	
	    	//System.out.println(check());
	    	//printSuduku(sud);

	       
	    }
	    
	    // printing suduku 4d array 
	    public static void printSuduku(int[][][][] sud) {

	    	for(int r=0; r<sud.length; r++) {
	    		for(int i=0; i<sud[r].length; i++) {
		    		for(int j=0; j<sud[r][i].length; j++) {
		    			for(int z=0; z<sud[r][i][j].length; z++) {
		    				System.out.print(sud[r][i][j][z] + " ");
		    			}
		    			System.out.print("  ");
		    		}
		    		System.out.println();
		    	}
	    		System.out.println();
	    	}
	    }
	    
	    
	    public static void userInput() {
	    	int count = 0;
	    	while(count<81) {
	    		
	    		printSuduku(sud);
	    		try {
	    			System.out.println("Enter position and set your num");
	    			System.out.println("***************************************************");
		    		System.out.println("Enter r (Enter 1-3) (r is big box row)");
		    		int r = sc.nextInt();
		    		System.out.println("Enter j (Enter 1-3) (j is big box column )");
		    		int j = sc.nextInt();
		    		System.out.println("Enter i (Enter 1-3) (i small box row)");
		    		int i = sc.nextInt();
		    		System.out.println("Enter z (Enter 1-3) (z is small box column)");
		    		int z = sc.nextInt();
		    		System.out.println("Enter your value 1 -9 ");
		    		int value = sc.nextInt();
		    		
		    		if(value>0 && value<10) {
		    			sud[r-1][i-1][j-1][z-1] = value;
		    		}else {
		    			System.out.println("enter valid number");
		    			userInput();
		    		}
		    		
		    		
		    		printSuduku(sud);
	    		}catch(ArrayIndexOutOfBoundsException e) {
	    			System.out.println("-------enter valid number for all----------- ");
	    			userInput();
	    		}
	    		
	    		System.out.println("Enter your value \n"+ 
	    											"11- countinue game \n"+ 
	    											"12- if finihed check your answer \n");
	    		int val = sc.nextInt();
	    		if(val ==11 || val==12) {
	    			if(val ==12) {
	    				boolean isCheck = check();
	    				if(isCheck) {
	    					System.out.println("Your Answer is correct you win!!!!!!!!!");
	    					break;
	    				}else {
	    					System.out.println("Your Answer is wrong you lost!!!!!!!");
	    					break;
	    				}
	    			}
	    			
	    		}else {
	    			System.out.println("Enter correct Number");
	    		}
	    		
	    	}
	    }
	    
	    //full big box into convert 2d array
	    public static void A4dArrayto2dArrayConvert() {
	    	
	    	int r=0,i= 0, j=0, z=0;
	    	for (int a =0 ; a<tester.length; a++) {
	    		for(int b=0; b<tester[a].length; b++) {
	    			
	    				tester[a][b] = sud[r][i][j][z];
	    				z++;
	    				if(z==3) {
	    					z=0;
	    					j++;
	    					if(j == 3) {
	    						j=0;
	    					}
	    				}
	    			
	    			
	    		}
	    		
	    		i++;
	    		if(i==3) {
	    			i=0;
	    			r++;
	    		}
	    	}
	    	

	    }
	    
	    
	    
	    // small box wise convert into 2d array
	    public static void A4dArrayInto2DConvertBox() {
	    	
	    	int r=0, i=0, j=0, z=0;
	    	for(int a = 0 ; a< tester2.length; a++) {
	    		for(int b=0; b< tester2[a].length; b++) {
	    			tester2[a][b] = sud[r][i][j][z];
	    			z++;
	    			if(z==3) {
	    				z=0;
	    				i++;
	    				if(i==3) {
	    					i=0;
	    				}
	    			}
	    		}
	    		
	    		j++;
	    		if(j==3) {
	    			j=0;
	    			r++;
	    		}
	    	}
	    }
	    
	    // testing for convertion not neet for suduku game 
	   public static void randonm() {
	    	
	    	Random rand = new Random();
	    	
	    	for(int r=0; r<sud.length; r++) {
	    		for(int i=0; i<sud[r].length; i++) {
		    		for(int j=0; j<sud[r][i].length; j++) {
		    			for(int z=0; z<sud[r][i][j].length; z++) {
		    				sud[r][i][j][z] = rand.nextInt(10);
		    			}
		    			
		    		}
		    		
		    	}
	    		
	    	}
	    	
	    }
	   
	   
	   
	   //testing for 2d array how will print not need to suduku
	   public static void twoDArrayPrint() {
		   for (int i=0; i<tester.length; i++) {
			   for(int j=0; j<tester[i].length; j++) {
				   System.out.print(tester[i][j]);
			   }
			   System.out.println();
		   }
	   }
	   
	   
	   
	   
	   // checking suduku game rules when you finishing the game
	   public static boolean check() {
		   
		   // changing 4d to 2d and checking susuku rules
		   A4dArrayto2dArrayConvert();
		   A4dArrayInto2DConvertBox();
		   
		   
		   // each row check
		   for(int i=0; i<tester.length; i++) { // taking each array in side applying linear search
			   for(int j = 0; j<tester[i].length-1; j++) {
				   int temp = tester[i][j];
				   for(int a =j+1 ; a<tester[i].length; a++ ) {
					   if(temp == tester[i][a]) {
						   System.out.println("your answer wrong try again .............");
						   return false;
						   
					   }
				   }
				   
			   }
		   }
		   
		   // column check 
		   for(int i=0; i<tester.length; i++) { 
			   for(int j = 0; j<tester[i].length-1; j++) {
				   int temp = tester[j][i];
				   for(int a =j+1 ; a<tester[i].length; a++ ) {
					   if(temp == tester[a][i]) {
						   System.out.println("your answer wrong try again .............");
						   return false;
					   }
				   }
				   
			   }
		   }
		   
		   
		   //each box want to check
		   
		   for(int i=0; i<tester2.length; i++) { // taking each array in side applying linear search
			   for(int j = 0; j<tester2[i].length-1; j++) {
				   int temp = tester2[i][j];
				   for(int a =j+1 ; a<tester2[i].length; a++ ) {
					   if(temp == tester2[i][a]) {
						   System.out.println("your answer wrong try again .............");
						   return false;
						   
					   }
				   }
				   
			   }
		   }
		   
		   
		   return true;
		   
		   
	   }
	

}
