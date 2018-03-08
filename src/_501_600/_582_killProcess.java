package _501_600;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class _582_killProcess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
		Given n processes, each process has a unique PID (process id) and its PPID (parent process id).
	
		Each process only has one parent process, but may have one or more children processes. This is just like a tree structure. Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be distinct positive integers.
	
		We use two list of integers to represent a list of processes, where the first list contains PID for each process and the second list contains the corresponding PPID.
	
		Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes that will be killed in the end. You should assume that when a process is killed, all its children processes will be killed. No order is required for the final answer.
	
		Example 1:
		Input: 
		pid =  [1, 3, 10, 5]
		ppid = [3, 0, 5, 3]
		kill = 5
		Output: [5,10]
		Explanation: 
		           3
		         /   \
		        1     5
		             /
		            10
		Kill 5 will also kill 10.
		Note:
		The given kill id is guaranteed to be one of the given PIDs.
		n >= 1.
	*/
	
	/*
		Java DFS O(n) Time O(n) Space
	*/
	
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
	    
	    // Store process tree as an adjacency list
	    Map<Integer, List<Integer>> adjacencyLists = new HashMap<>();
	    for (int i=0;i<ppid.size();i++) {
	        adjacencyLists.putIfAbsent(ppid.get(i), new LinkedList<>());
	        adjacencyLists.get(ppid.get(i)).add(pid.get(i));
	    }
	    
	    // Kill all processes in the subtree rooted at process "kill"
	    List<Integer> res = new LinkedList<>();
	    Stack<Integer> stack = new Stack<>();
	    stack.add(kill);
	    while (!stack.isEmpty()) {
	        int cur = stack.pop();
	        res.add(cur);
	        List<Integer> adjacencyList = adjacencyLists.get(cur);
	        if (adjacencyList == null) continue;
	        stack.addAll(adjacencyList);
	    }
	    return res;   
	}
}

/*
public List< Integer > killProcess( List<Integer> pid, List<Integer> ppid, int kill )
{
    if ( ppid.get( pid.indexOf( kill ) ) == 0 )
        return pid;

    HashMap< Integer, ArrayList< Integer > > map = new HashMap<>();
    for ( int i = 0; i < ppid.size(); i++ )
    {
        if ( map.containsKey( ppid.get( i ) ) )
        {
            map.get( ppid.get( i ) ).add( pid.get( i ) );
        }
        else
        {
            ArrayList< Integer > pidList = new ArrayList<>();
            pidList.add( pid.get( i )  );
            map.put( ppid.get( i ), pidList );
        }
    }

    Stack< Integer > pidStack = new Stack<>();
    List< Integer > killedPid = new ArrayList<>();
    pidStack.push( kill );
    killedPid.add( kill );
    
    int nextPid;
    while ( !pidStack.isEmpty() )
    {
        nextPid = pidStack.pop();
        if ( map.containsKey( nextPid ) )
        {
            ArrayList< Integer > list = map.get( nextPid );
            killedPid.addAll( list );
            pidStack.addAll( list );
        }
    }
    
    return killedPid;
}
*/