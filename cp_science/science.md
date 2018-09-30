## The development of programs

(14.4) **Principle**: Programming is a *goal-oriented activity*

(14.5) **Principle**: Before attempting to solve a problem, make absolutely sure you know what the problem is.

(14.6) **Principle**: Before developing a program, make precise and refine the pre- and postconditions

**Theorem 10.5**. Consider command IF. Suppose a predicate Q satisfies
		(1) Q => BB 
		(2) Q && Bi => wp(Si, R), for all i, 1 <= i <= n.
		Then (and only then) Q => wp(IF, R).

		*(BB denotes disjunction of Bi, Bi denote the condition expression for each condition branch.)*

(14.7) **Strategy for developing an alternative command**: To invent a guarded command, find a command C whose
		execution will establish postcondition R in at least some cases; find a Boolean B satisfying *B => wp(C, R)*;
		and put them together to form B -> C (see assumption 2 of theorem 10.5). Continue to invent guarded commands
		until the precondition of construct implies that at least one guard is true (see assumption 1 of theorem 10.5) 

