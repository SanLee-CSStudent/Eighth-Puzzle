package Puzzle;

/*
Puzzle should include the puzzle itself and its components
	1. EightPuzzle
		Will be a wrapper for state and operators
		Will compare states in sequence of String
		
	2. State
		Has to parse input string
		Store location of each number separately?
			Separate object named number containing location?
			
	3. Operator(s)
		Move blank spaces to shift numbers
		Move up = find column num and switch element at 1 row above. if row is already 0, rejct
		
	4. Search Algorithms
		Uniform Cost
		A* with Misplaced Tile Heuristics
		A* with Euclidean Distance Heuristics
*/