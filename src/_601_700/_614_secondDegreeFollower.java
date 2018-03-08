package _601_700;

public class _614_secondDegreeFollower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
		In facebook, there is a follow table with two columns: followee, follower.
	
		Please write a sql query to get the amount of each follower’s follower if he/she has one.
	
		For example:
	
		+-------------+------------+
		| followee    | follower   |
		+-------------+------------+
		|     A       |     B      |
		|     B       |     C      |
		|     B       |     D      |
		|     D       |     E      |
		+-------------+------------+
		should output:
		+-------------+------------+
		| follower    | num        |
		+-------------+------------+
		|     B       |  2         |
		|     D       |  1         |
		+-------------+------------+
		Explaination:
		Both B and D exist in the follower list, when as a followee, B's follower is C and D, and D's follower is E. A does not exist in follower list.
		Note:
		Followee would not follow himself/herself in all cases.
		Please display the result in follower's alphabet order.
	*/
	
	/*
		Create table If Not Exists follow (followee varchar(255), follower varchar(255));
		Truncate table follow;
		insert into follow (followee, follower) values ('A', 'B');
		insert into follow (followee, follower) values ('B', 'C');
		insert into follow (followee, follower) values ('B', 'D');
		insert into follow (followee, follower) values ('D', 'E');
	*/
	
	/*
		Select f1.follower, count(distinct f2.follower) as num
		from follow f1
		inner join follow f2 on f1.follower = f2.followee
		Group by f1.follower
	*/
}

/*
	select distinct o.follower, t.num as num from follow o
	join (select followee, count(distinct followee,follower) as num from follow group by followee) t
	on o.follower = t.followee
	order by o.follower ASC
*/