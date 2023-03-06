# my-first-java-project
simple HRS system to manage the hiring process of a group of qualified cleaning-workers and drivers on an hourly basis.
Details of the functions in the menu of the HRS system to manage the hiring process for all the employees:
1. Add a new employee:
Reads the employee’s (id) from the user, and validates that it does not already exist otherwise displays an 
appropriate message and goes back to the menu. After validating the id, it reads from the user the employee's info.
2. Start a hiring contract: (used when a customer requests an employee)
Reads the employee’s (id) from the user. Makes sure the employee exists and is not yet hired, then reads 
the contract’s information. The program then displays the employee’s information and state that he/she is now ready 
for starting the assigned job. In case if the employee is not existed or he/she is already hired, then displays 
appropriate messages and goes back to the menu.
3. End a hiring contract: (used when the employee is done and checks back into the company)
Reads the employee’s (id) from the user. Makes sure the employee exists and is hired, then display
the employee’s information and contract’s total duration. To end this hiring contract, it resets the
employee’s values so that he/she can be hired again: assigns the value “N/A” to contractDate,
startTime, and endTime. Then, assigns the hired attribute’s value back to false. In case if the
employee is not existed or he/she is not hired, then displays appropriate messages and goes back to
the menu.
4. Display an employee’s info:
Reads the employee’s (id) from the user. If the employee does not exist, then displays an appropriate
message and goes back to the menu. Otherwise, displays the employee’s information.
5. Display HRS system status:
Displays a summarized report of the HRS system, that includes:
• The total number of employees who are currently registered in the system.
• The current number of hired employees, and the number of available employees.
• The id of the employee with the highest hiring frequency in the system.
• A listing of all the employees in a table with a proper header.


