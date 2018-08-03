## 5. Longest Palindromic Substring

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:

Input: "cbbd"
Output: "bb"

###### Bottom-up DP
*Recursive relationship*
Define the problem as LPS(i, j) = longest palindromic substring for str[i,j).
ISPAL(i, j): bool to denote the problem to determin if substring str[i,j) is palindromic.
ISPAL(i, j) = ISPAL(i+1,j-1) && str[i] == str[j]

LPS(i, j) =	LPS(i+1, j-1) + 1 if ISPAL(i+1, j-1) && str[i] == str[j]
		  = LPS(i+1, j-1) if !ISPAL(i+1, j-1) || str[i] != str[j]

notice that 
* problem of (i, j) depends on a smaller problem (i-1, j+1)
* ISPAL(i, j) = true  when i > j
* LPS(i, j) = 0 when i > j

In this problem LPS is not needed, we can record a max value when we compute the result.

Time complexity: O(N^2). Space complexity O(N^2);

```java
	public int lps(String s) { // wrong return param
		if (s == null || s.isEmpty()) return 0;
		boolean[][] dp = new int[s.length()][s.length()];
		int max = 0;	
		Arrays.fill(dp, new int[s.length()]);
		for (int len = 1; len <= s.length(); len++) {//loop through all substring length
			boolean hasValid = false;
			for (int i = 0; i <= s.length()-len; i++) { //loop through all substring with length len
				int j = i+len-1;
				boolean isInnerValid = i+1 > j-1 ? true : dp[i+1][j-1];
				if (isInnerValid && s.charAt(i) == s.charAt(j)) {
					dp[i][j] = true;
					hasValid = true;
				}
			}
			if (hasValid) max = len;
		}
		return max;
	}		
```
above code is not fulfill the requirement

```java
	public String lps(String s) { 
		if (s == null || s.isEmpty()) return s; // return type wrong
		boolean[][] dp = new boolean[s.length()][s.length()]; // array initiate to wrong type
		String max = ""; // error if not initialised
		Arrays.fill(dp, new boolean[s.length()]);
		for (int len = 1; len <= s.length(); len++) {//loop through all substring length
			for (int i = 0; i <= s.length()-len; i++) { //loop through all substring with length len
				int j = i+len-1;
				boolean isInnerValid = i+1 > j-1 ? true : dp[i+1][j-1];
				if (isInnerValid && s.charAt(i) == s.charAt(j)) {
					dp[i][j] = true;
					max = s.substring(i, j+1); 
				} else { //forget to handle else case
					dp[i][j] = false;			
				}
			}
		}
		return max; // error if max not initialized
	}		
```

*error*
* return type wrong in first line
* array init to wrong type
* return value may not be initialized
* forget to handle else case