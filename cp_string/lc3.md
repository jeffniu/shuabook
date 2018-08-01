## 3. Longest Substring Without Repeating Characters

Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


###### Two pointer techniques, 尺曲法

test cases:

"a" -> 1
"aa" -> 1
"abcdbef"->5

use a hashmap to record character index

```java

public int maxLength(String str) {
	if (str == null || str.length == 0) return 0; //compile error. should be str.length()
	int start = 0;
	int end = 0;
	int max = 1;
	Map<Character, Integer> chloc = new HashMap<>();
	chloc.put(str.charAt(start), start);
	while (end < str.length()) {
		if (start == end) {
			end++;
			continue;
		}
		char ch = str.charAt(end);
		if (chloc.containsKey(ch) && chloc.get(ch) >= start) {
			start = chloc.get(ch)+1;
		} 
		max = Math.max(max, end-start+1);
		chloc.put(ch, end);
		end++;
	}
	return max;
}

```

###### error:
Compile error: str.length -> str.length()