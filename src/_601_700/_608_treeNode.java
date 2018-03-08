package _601_700;

public class _608_treeNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
		Given a table tree, id is identifier of the tree node and p_id is its parent node's id.
	
		+----+------+
		| id | p_id |
		+----+------+
		| 1  | null |
		| 2  | 1    |
		| 3  | 1    |
		| 4  | 2    |
		| 5  | 2    |
		+----+------+
		Each node in the tree can be one of three types:
		Leaf: if the node is a leaf node.
		Root: if the node is the root of the tree.
		Inner: If the node is neither a leaf node nor a root node.
		Write a query to print the node id and the type of the node. Sort your output by the node id. The result for the above sample is:
		+----+------+
		| id | Type |
		+----+------+
		| 1  | Root |
		| 2  | Inner|
		| 3  | Leaf |
		| 4  | Leaf |
		| 5  | Leaf |
		+----+------+
		Explanation
	
		Node '1' is root node, because its parent node is NULL and it has child node '2' and '3'.
		Node '2' is inner node, because it has parent node '1' and child node '4' and '5'.
		Node '3', '4' and '5' is Leaf node, because they have parent node and they don't have child node.
	
		And here is the image of the sample tree as below:
					  1
					/   \
		                      2       3
		                    /   \
		                  4       5
		Note
	
		If there is only one node on the tree, you only need to output its root attributes.
	*/
	
	/*
		Create table If Not Exists tree (id int, p_id int);
		Truncate table tree;
		insert into tree (id, p_id) values ('1', 'None');
		insert into tree (id, p_id) values ('2', '1');
		insert into tree (id, p_id) values ('3', '1');
		insert into tree (id, p_id) values ('4', '2');
		insert into tree (id, p_id) values ('5', '2');
	*/
	
	/*
		select T.id, 
		IF(isnull(T.p_id), 'Root', IF(T.id in (select p_id from tree), 'Inner', 'Leaf')) Type 
		from tree T
	*/
}

/*
	select id, if(isnull(p_id), "Root", if(id in (select distinct p_id from tree), "Inner", "Leaf")) as Type from tree
*/
