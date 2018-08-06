
/*
class Solution {
    public int reverse(int x) {
        int sign = x >= 0 ? 1 : -1;
		long result = 0;
		while (x > 0) {
			int digit = x % 10;
			result = result * 10 + sign * digit;
			if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
				result = 0;
				break;
			}
			x /= 10;
		}
    }
	return result; //error type wrong
}
*/
/*
class Solution {
    public int reverse(int x) {
        int sign = x >= 0 ? 1 : -1;
		long result = 0;
		while (x > 0) {
			int digit = x % 10;
			result = result * 10 + sign * digit;
			if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
				result = 0;
				break;
			}
			x /= 10;
		}
		return (int)result; 
	}
}

failed test case:
-123
*/

/*
class Solution {
    public int reverse(int x) {
        int sign = x >= 0 ? 1 : -1;
		long result = 0;
		while (x != 0) {
			int digit = x % 10;
			result = result * 10 + sign * digit;
			if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
				result = 0;
				break;
			}
			x /= 10;
		}
		return (int)result; 
	}
}
failed test case:
-123
*/
/**
correct solution with long

class Solution {
    public int reverse(int x) {
		long result = 0;
		while (x != 0) {
			int digit = x % 10;
			result = result * 10 + digit;
			if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
				result = 0;
				break;
			}
			x /= 10;
		}
		return (int)result; 
	}
}
*/

/**
solution without using long
*/

class Solution {
	public int reverse(int x) {
		int result = 0;
		while (x != 0) {
			int digit = x%10;
			int temp = result * 10 + digit;
			if ((temp-digit)/10 != result) return 0;
			result = temp;
			x /= 10;
		}	
		return result;
	}
}
