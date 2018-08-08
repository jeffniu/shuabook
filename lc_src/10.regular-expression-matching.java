class Solution {
	public boolean isMatch(String s, String p) {
		boolean[] pre = new boolean[p.length()+1];
		boolean[] cur = new boolean[p.length()+1];
		int ls = s.length();
		int lp = p.length();
		for (int i = 0; i <= ls; i++) {
			for (int j = 0; j <= lp; j++) {
				if (i == 0 && j == 0) {
					cur[j] = true;
					continue;
				}
				int si = i-1;
				int pi = j-1;
				boolean isMatch = false;
				if (si >= 0 && pi >= 0 && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.')) {
					isMatch = pre[j-1];
				}
				if (pi >= 1 && p.charAt(pi) == '*') {
					if (si >= 0 && (s.charAt(si) == p.charAt(pi-1) || p.charAt(pi-1) == '.')) {
						isMatch = isMatch || pre[j-2] || pre[j];
					} 
					isMatch = isMatch || cur[j-2];
				}
				cur[j] = isMatch;
			}
			boolean[] temp = pre;
			pre = cur;
			cur = temp;
		}
		return pre[lp];
	}
}
