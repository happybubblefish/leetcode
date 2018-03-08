package _601_700;

public class _618_studentsReportByGeography {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
		A U.S graduate school has students from Asia, Europe and America. The students' location information are stored in table student as below.
	
		| name   | continent |
		|--------|-----------|
		| Jack   | America   |
		| Pascal | Europe    |
		| Xi     | Asia      |
		| Jane   | America   |
		Pivot the continent column in this table so that each name is sorted alphabetically and displayed underneath its corresponding continent. The output headers should be America, Asia and Europe respectively. It is guaranteed that the student number from America is no less than either Asia or Europe.
		For the sample input, the output is:
		| America | Asia | Europe |
		|---------|------|--------|
		| Jack    | Xi   | Pascal |
		| Jane    |      |        |
		Follow-up: If it is unknown which continent has the most students, can you write a query to generate the student report?
	*/
	
	/*
		Create table If Not Exists student (name varchar(50), continent varchar(7));
		Truncate table student;
		insert into student (name, continent) values ('Jane', 'America');
		insert into student (name, continent) values ('Pascal', 'Europe');
		insert into student (name, continent) values ('Xi', 'Asia');
		insert into student (name, continent) values ('Jack', 'America');
	*/
	
	/*
		set @r1 = 0, @r2 = 0, @r3 = 0;
		select min(America) America, min(Asia) Asia, min(Europe) Europe
		from (select case when continent='America' then @r1 :=@r1+1
		                  when continent='Asia' then @r2 :=@r2+1
		                  when continent='Europe' then @r3 :=@r3+1 end RowNum,
		             case when continent='America' then name end America,
		             case when continent='Asia' then name end Asia,
		             case when continent='Europe' then name end Europe
		      from student
		      order by name) T
		group by RowNum
	*/
}
