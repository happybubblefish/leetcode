package _501_600;

public class _569_medianEmployeeSalary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
		The Employee table holds all employees. The employee table has three columns: Employee Id, Company Name, and Salary.
	
		+-----+------------+--------+
		|Id   | Company    | Salary |
		+-----+------------+--------+
		|1    | A          | 2341   |
		|2    | A          | 341    |
		|3    | A          | 15     |
		|4    | A          | 15314  |
		|5    | A          | 451    |
		|6    | A          | 513    |
		|7    | B          | 15     |
		|8    | B          | 13     |
		|9    | B          | 1154   |
		|10   | B          | 1345   |
		|11   | B          | 1221   |
		|12   | B          | 234    |
		|13   | C          | 2345   |
		|14   | C          | 2645   |
		|15   | C          | 2645   |
		|16   | C          | 2652   |
		|17   | C          | 65     |
		+-----+------------+--------+
		Write a SQL query to find the median salary of each company. Bonus points if you can solve it without using any built-in SQL functions.
	
		+-----+------------+--------+
		|Id   | Company    | Salary |
		+-----+------------+--------+
		|5    | A          | 451    |
		|6    | A          | 513    |
		|12   | B          | 234    |
		|9    | B          | 1154   |
		|14   | C          | 2645   |
		+-----+------------+--------+
	*/
	
	/*
		Create table If Not Exists Employee (Id int, Company varchar(255), Salary int);
		Truncate table Employee;
		insert into Employee (Id, Company, Salary) values ('1', 'A', '2341');
		insert into Employee (Id, Company, Salary) values ('2', 'A', '341');
		insert into Employee (Id, Company, Salary) values ('3', 'A', '15');
		insert into Employee (Id, Company, Salary) values ('4', 'A', '15314');
		insert into Employee (Id, Company, Salary) values ('5', 'A', '451');
		insert into Employee (Id, Company, Salary) values ('6', 'A', '513');
		insert into Employee (Id, Company, Salary) values ('7', 'B', '15');
		insert into Employee (Id, Company, Salary) values ('8', 'B', '13');
		insert into Employee (Id, Company, Salary) values ('9', 'B', '1154');
		insert into Employee (Id, Company, Salary) values ('10', 'B', '1345');
		insert into Employee (Id, Company, Salary) values ('11', 'B', '1221');
		insert into Employee (Id, Company, Salary) values ('12', 'B', '234');
		insert into Employee (Id, Company, Salary) values ('13', 'C', '2345');
		insert into Employee (Id, Company, Salary) values ('14', 'C', '2645');
		insert into Employee (Id, Company, Salary) values ('15', 'C', '2645');
		insert into Employee (Id, Company, Salary) values ('16', 'C', '2652');
		insert into Employee (Id, Company, Salary) values ('17', 'C', '65');
	*/
	
	/*
		select Id, Company, Salary from
		(
		select e.Id, e.Salary, e.Company,  if( @prev = e.Company , @Rank := @Rank + 1, @Rank := 1) as rank, @prev := e.Company
		from Employee e , (select @Rank := 0, @prev := 0) as temp order by e.Company, e.Salary, e.Id
		) Ranking
		INNER JOIN
		(
		select count(*) as totalcount, Company as name from Employee e2 group by e2.Company
		) companycount
		on companycount.name = Ranking.Company
		where Rank = floor((totalcount+1)/2) or Rank = floor((totalcount+2)/2)
		At this time(6/28/2017) the second one in editorial solution seems to have problem as it didn't declare the temp variable, which cause the rank to be always one, this code is the improvement to the editorial solution, which solve the problem and pass the test case.
	*/
}
