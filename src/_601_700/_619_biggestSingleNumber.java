package _601_700;

public class _619_biggestSingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
		Table number contains many numbers in column num including duplicated ones.
		Can you write a SQL query to find the biggest number, which only appears once.
		+---+
		|num|
		+---+
		| 8 |
		| 8 |
		| 3 |
		| 3 |
		| 1 |
		| 4 |
		| 5 |
		| 6 | 
		For the sample data above, your query should return the following result:
		+---+
		|num|
		+---+
		| 6 |
		Note:
		If there is no such number, just output null.
	*/
	
	/*
		Create table If Not Exists number (num int);
		Truncate table number;
		insert into number (num) values ('8');
		insert into number (num) values ('8');
		insert into number (num) values ('3');
		insert into number (num) values ('3');
		insert into number (num) values ('1');
		insert into number (num) values ('4');
		insert into number (num) values ('5');
		insert into number (num) values ('6');
	*/
	
	/*
	# Refer to: https://stackoverflow.com/questions/17250243/how-to-return-null-when-result-is-empty
		select(
		  select num
		  from number
		  group by num
		  having count(*) = 1
		  order by num desc limit 1
		) as num;
	*/
}
