## 2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

The key point here is to list edge cases:

() + () = 0
() + (1->2->3) => 1->2->3
(1) + (9->9->9) => (0->0->0->1)


```java
public ListNode addTwoNumbers(ListNode h1, ListNode h2) {
	if (h1 == null && h2 == null) return null;
	ListNode h3 = new ListNode(0); //dummy head;
	ListNode p1 = h1;
	ListNode p2 = h2;
	ListNode p3 = h3;
	int carry = 0;
	while (p1 != null && p2 != null) {
		int sum = p1.val + p2.val + carry;
		carry = sum/10;
		ListNode node = new ListNode(sum%10);
		p3.next = node;
		p3 = p3.next;

		//updated
		p1 = p1.next;
		p2 = p2.next;
	}
	if (p1 != null || p2 != null) {
		ListNode rest = p1 != null ? p1 : p2;
		while (rest != null) {
			int sum = rest.val + carry;
			carry = sum/10;
			ListNode node = new ListNode(sum%10);
			p3.next = node;
			p3 = p3.next;
			//updated
			rest = rest.next;
		}
	}
	if (carry == 1) {
		ListNode node = new ListNode(1);
		p3.next = node;
		p3 = p3.next;
	}	
	//add carry
	return h3.next;
}

```

###### failed cases:
[2,4,3]
[5,6,4]
Memory limit exceed.

###### error:
* forget to advance pointers p1, p2 and rest

###### A shorter code:

```java
public ListNode addTwoNumbers(ListNode h1, ListNode h2) {
	if (h1 == null && h2 == null) return null;
	ListNode h3 = new ListNode(0); //dummy head;
	ListNode p1 = h1;
	ListNode p2 = h2;
	ListNode p3 = h3;
	int carry = 0;
	while (p1 != null || p2 != null) {
		int x = p1 != null ? p1.val : 0;
		int y = p2 != null ? p2.val : 0;
		int sum = x + y + carry;
		carry = sum/10;
		p3.next = new ListNode(sum%10);
		p3 = p3.next;
		if (p1 != null) {
			p1 = p1.next;
		}
		if (p2 != null) {
			p2 = p2.next;
		}
	}
	//add carry
	if (carry > 0) {
		p3.next = new ListNode(carry);
		p3 = p3.next;
	}	
	return h3.next;
}

```
