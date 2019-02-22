package com.star;

public class App {
	static final String USAGE = "Usage:ntjava App server port";
    static final String MSG_TOO_FEW_ARGUMENTS  = "too few arguments";
    static final String MSG_TOO_MANY_ARGUMENTS = "too many arguments";
    static final String MSG_MUST_BE_NUMBER = "arg not numeric";
	   
	public static void main(String... args) {
		if (args.length < 1) {
	         System.out.println(MSG_TOO_FEW_ARGUMENTS);
	    } else if (args.length > 1)
	         System.out.println(MSG_TOO_MANY_ARGUMENTS);
	    else {
	    	int number=0;
	    	try {
	    		number=Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				System.out.println(MSG_MUST_BE_NUMBER);
			}
	    	for (int i = 0; i <= number; i++) {
	    		for (int k = 0; k < number - i; k++) {
	    			System.out.print(" ");
	    		}
	    		for (int j = 0; j < 2 * i - 1; j++) {
	    			System.out.print("*");
	    		}
	    		System.out.print("n");
	    	}
		}

	}
}
