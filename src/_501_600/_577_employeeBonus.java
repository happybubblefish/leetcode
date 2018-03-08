package _501_600;

public class _577_employeeBonus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
		Select all employee's name and bonus whose bonus is < 1000.
	
		Table:Employee
	
		+-------+--------+-----------+--------+
		| empId |  name  | supervisor| salary |
		+-------+--------+-----------+--------+
		|   1   | John   |  3        | 1000   |
		|   2   | Dan    |  3        | 2000   |
		|   3   | Brad   |  null     | 4000   |
		|   4   | Thomas |  3        | 4000   |
		+-------+--------+-----------+--------+
		empId is the primary key column for this table.
		Table: Bonus
	
		+-------+-------+
		| empId | bonus |
		+-------+-------+
		| 2     | 500   |
		| 4     | 2000  |
		+-------+-------+
		empId is the primary key column for this table.
		Example ouput:
	
		+-------+-------+
		| name  | bonus |
		+-------+-------+
		| John  | null  |
		| Dan   | 500   |
		| Brad  | null  |
		+-------+-------+
	*/
	
	/*
		SELECT name, bonus
		FROM Employee LEFT JOIN Bonus
		ON Employee.empID=Bonus.empID
		WHERE bonus<1000 OR bonus IS NULL
	*/
}
