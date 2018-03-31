/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class SmallestGreaterElements {
  // https://practice.geeksforgeeks.org/problems/smallest-greater-elements-in-whole-array/0/
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int numTestCases = sc.nextInt();

		for(int i = 0; i < numTestCases; i++){
		    int numInputs = sc.nextInt();
		    List<Integer> inputs = new LinkedList<Integer>();
		    for( int j = 0; j < numInputs; j++) {
			inputs.add(sc.nextInt());
		    }
		    System.out.println(nextGreatest(inputs));
		}
	}
	
	public static String nextGreatest(List<Integer> in) {
		StringBuilder retval = new StringBuilder();

		List<Integer> sorted = new LinkedList<Integer>();
		sorted.addAll(in);
		Collections.sort(sorted);

		HashMap<Integer,Integer> nextMap = new HashMap<Integer,Integer>();

		Integer prev = null;
		for( Integer val : sorted ){
			if( prev != null && val.intValue() != prev.intValue() ) {
				nextMap.put(prev,val);
			}
			prev = val;
		}

		for( Integer val : in ){
			Integer next = nextMap.get(val);
			if( next != null ){
				retval.append(next).append(' ');
			} else {
				retval.append("_ ");
			}
		}

		return retval.toString().trim();
	}
}
