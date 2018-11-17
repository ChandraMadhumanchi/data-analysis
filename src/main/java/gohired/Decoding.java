package gohired;
//http://www.gohired.in/tag/dynamic-programming/
public class Decoding {

	// Given a digit sequence of length n,
	// returns count of possible decodings by
	// replacing 1 with A, 2 with B, .... 26 with Z
	
	public static void main(String[] args) {

		String str = "123";
		char[] digits = str.toCharArray();
		int n = digits.length;
		System.out.println("Count is "+ countDecoding(digits,n));
	}

	public static int countDecoding(char[] digits,int n){
		
		// base cases
		if (n == 0 || n == 1)
			return 1;
		
		// Initialize count
		int count = 0;
		
		// if the last digit is not 0, then
		// last digit must add to
		// the number of words
		if(digits[n-1] > '0')
			count = countDecoding(digits, n-1);
		
		// if the last two digits form a number
		// smaller than or equal to 26,
		// then consider last two digits and recur
		if (digits[n - 2] == '1' || (digits[n - 2] == '2' && digits[n - 1] < '7') )
				count += countDecoding(digits, n-2);
		
		return count;
	}
}
