This is a project I did for a software testing course in the fall of 2015. It is a white box test suite for a simulated ATM machine. The source code and more information about the ATM project can be found here:

http://www.cs.gordon.edu/courses/cs211/ATMExample/index.html



./ATMExample (source code) contains:
./source - contains all the original source modified with API methods and also contains new white box test suite
	
./Emma - Emma generated code coverage
 
ATM_test_cases.pdf - All the test cases with actual outcomes, pass/fail status and rates, and commentary the coverage of the functional tests
	
WhiteBoxTest.pdf - A description of the test suite

-----------------------------------------------------------------

How To Run: 
	Launch Emma:
		In Eclipse click LaunchTestSuite
	Run Test Suite:
	Compile and run TestRunner.java
			- Will print failures to the console
			- Will print true to console if all tests are successful
	Or
	Right click on /source/tests package in Eclipse and select Run As > Junit Test
			- Works the same as TestRunner.java but shows the progress of the tests
		
