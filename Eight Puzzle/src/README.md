All the source codes are in src folder.
Run main.java, which is stored in /src.
This project is run with Eclipse IDE(Windows) and jdk-8.0.282.8-hotspot, JDK-14.0.1, and JRE1.8.0_251
Under linux environments, the program tested with openjdk-11. Run the following commandst to compile and run:
	javac Main.java
	java Main

Then, the program will ask for inputs to create a puzzle and run a search algorithm.
	First, the user selects whether the default puzzle is used or customized puzzle is used.
		Default puzzle is hardcoded.
		Customized puzzle requires inputting each row with 3 elements. Total of 3 rows is asked.
	Second, the user selects which algorithms to be used to search the solution.
	Process will be printed.
	The result includes:
		1. Sequence of actions 
		2. # of expanded nodes
		3. # of maximum queue size
		4. # of steps taken
	Otherwise, the program will cease to run.
		If there exists a no solution to the given problem.
	
