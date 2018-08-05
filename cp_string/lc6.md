## 6. ZigZag Conversion


The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I

###### solution

The first idea is to find a way to convert index of original string to
the line number in the result string.

P    |  I   | N
A   L|  S  I| G
Y A  |  H R |
P    |  I   |

notice that a zigzag shape is consists of multiple of tick shape.

1. convert origin index to index in each tick shape. which is from 0 to 2K-3
1. convert tick index to line number
1. contatenate each line result together.


```java
    public String convert(String s, int numRows) {
    	if (s == null || s.isEmpty()) return s;
    	StringBuffer[] result = new StringBuffer[numRows];
    	for (int i = 0; i < s.length(); i++) {
    		int indexInTick = i % (2*numRows-2);	
    		int lineIndex = convertTickIndexToLineNumber(indexInTick, numRows);
    		result[lineIndex].append(s.charAt(i));
    	}
    	StringBuffer finalResult = new StringBuffer();
    	for (StringBuffer sb : result) {
    		finalResult.append(sb.toString());
    	}
    	return finalResult.toString();
    }
    private int convertTickIndexToLineNumber(int tickIndex, int numRows) {
    	if (tickIndex < numRows) {
    		return tickIndex;
    	} else {
    		return numRows-2-(tickIndex-numRows);
    	}
    }
```

*error*:
runtime error: null pointer exception
divide by 0

*correction*:
initialize StringBuffer array with:

```java
        for (int i = 0; i < result.length; i++) {
            result[i] = new StringBuffer();
        }
```

solve the divide by zero error:
```java
	int indexInTick = numRows == 1 ? 0 : i % (2 * numRows - 2);
```




