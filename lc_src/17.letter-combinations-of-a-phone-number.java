class Solution {
	private static final String[] PAD = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if (digits == null || digits.isEmpty()) return result;	
		StringBuilder sb = new StringBuilder();
		bt(digits.toCharArray(), 0, sb, result);
		return result;
    }

	private void bt(char[] digits, int k, StringBuilder sol, List<String> result) {
		if (k == digits.length) {
			result.add(sol.toString());
			return;
		}
		int digit = digits[k] - '0';
		for (int i = 0; i < PAD[digit].length(); i++) {
			char ch = PAD[digit].charAt(i);
			sol.append(ch);
			bt(digits, k+1, sol, result);
			sol.deleteCharAt(sol.length()-1);
		}
	}
}
