package _601_700;

public class _603_consecutiveAvailableSeats {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
		Several friends at a cinema ticket office would like to reserve consecutive available seats.
		Can you help to query all the consecutive available seats order by the seat_id using the following cinema table?
	
		| seat_id | free |
		|---------|------|
		| 1       | 1    |
		| 2       | 0    |
		| 3       | 1    |
		| 4       | 1    |
		| 5       | 1    |
		Your query should return the following result for the sample case above.
		| seat_id |
		|---------|
		| 3       |
		| 4       |
		| 5       |
		Note:
		The seat_id is an auto increment int, and free is bool ('1' means free, and '0' means occupied.).
		Consecutive available seats are more than 2(inclusive) seats consecutively available.
	*/
	
	/*
		Create table If Not Exists cinema (seat_id int primary key auto_increment, free bool);
		Truncate table cinema;
		insert into cinema (seat_id, free) values ('1', '1');
		insert into cinema (seat_id, free) values ('2', '0');
		insert into cinema (seat_id, free) values ('3', '1');
		insert into cinema (seat_id, free) values ('4', '1');
		insert into cinema (seat_id, free) values ('5', '1');
	*/
	
	/*
		select C1.seat_id from cinema C1  where 
		C1.free=1 
		and 
		(
		    C1.seat_id+1 in (select seat_id from cinema where free=1) 
		    or 
		    C1.seat_id-1 in (select seat_id from cinema where free=1) 
		) 
		order by C1.seat_id
	*/
}
