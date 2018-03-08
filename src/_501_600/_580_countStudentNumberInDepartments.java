package _501_600;

public class _580_countStudentNumberInDepartments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
		A university uses 2 data tables, student and department, to store data about its students and the departments associated with each major.
	
		Write a query to print the respective department name and number of students majoring in each department for all departments in the department table (even ones with no current students).
	
		Sort your results by descending number of students; if two or more departments have the same number of students, then sort those departments alphabetically by department name.
	
		The student is described as follow:
	
		| Column Name  | Type      |
		|--------------|-----------|
		| student_id   | Integer   |
		| student_name | String    |
		| gender       | Character |
		| dept_id      | Integer   |
		where student_id is the student's ID number, student_name is the student's name, gender is their gender, and dept_id is the department ID associated with their declared major.
	
		And the department table is described as below:
	
		| Column Name | Type    |
		|-------------|---------|
		| dept_id     | Integer |
		| dept_name   | String  |
		where dept_id is the department's ID number and dept_name is the department name.
	
		Here is an example input:
		student table:
	
		| student_id | student_name | gender | dept_id |
		|------------|--------------|--------|---------|
		| 1          | Jack         | M      | 1       |
		| 2          | Jane         | F      | 1       |
		| 3          | Mark         | M      | 2       |
		department table:
	
		| dept_id | dept_name   |
		|---------|-------------|
		| 1       | Engineering |
		| 2       | Science     |
		| 3       | Law         |
		The Output should be:
	
		| dept_name   | student_number |
		|-------------|----------------|
		| Engineering | 2              |
		| Science     | 1              |
		| Law         | 0              |
	*/
	
	/*
		SELECT d.dept_name, COUNT(s.student_id) AS student_number
		FROM student s RIGHT JOIN department d ON s.dept_id = d.dept_id
		GROUP BY d.dept_name 
		ORDER BY student_number DESC, d.dept_name;
	
		"ORDER BY d.dept_name" is needed as well (according to the problem description), otherwise you will get a wrong answer.
	*/
	
	/*
		SELECT dept_name, COUNT(student_id) AS student_number
		FROM department LEFT JOIN student ON department.dept_id=student.dept_id
		GROUP BY department.dept_id
		ORDER BY student_number DESC, dept_name
	*/
	
	/*
		select dept_name,count(s.dept_id) as student_number
		from student as s
		right join department as d
		on s.dept_id=d.dept_id
		group by d.dept_id
		order by student_number desc, dept_name asc
	*/
}
