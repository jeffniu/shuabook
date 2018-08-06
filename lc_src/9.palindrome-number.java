/**
solve it without convert to string
need to find a way to quickly get ith and (n-i)th digits
*/
/**
class Solution {
    public boolean isPalindrome(int x) {
		if (x < 0) return false;
		//reverse number and compare with origin	 
		int result = 0;
		int origin = x;
		while (origin != 0) {
			result = result * 10 + origin % 10;
			if (result == origin) return true;
			origin /= 10;
		}
		return result != origin;
    }
}
failed test case:
10
*/

class Solution {
    public boolean isPalindrome(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0)) return false;
		//reverse number and compare with origin	 
		int result = 0;
		int origin = x;
		while (origin != 0) {
			result = result * 10 + origin % 10;
			if (result == origin) return true;
			origin /= 10;
		}
		return result == x;
    }
}
