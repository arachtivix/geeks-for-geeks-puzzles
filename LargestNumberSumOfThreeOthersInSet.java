/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.lang.*;

class LargestNumberSumOfThreeOthersInSet {
	//https://www.geeksforgeeks.org/find-largest-d-in-array-such-that-a-b-c-d/
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> in = new LinkedList<Integer>();
		while(true){
    		try{
    		    in.add(sc.nextInt());
    		} catch( NoSuchElementException e ){
    		    break;
    		}
		}
	    
	    Collections.sort(in);
	    Collections.reverse(in);
		
		Integer result = GFG.getLargestElementSumOfThreeOthersInSet(in);
		System.out.println(result == null ? "No solution" : result);
	}
	
	public static Integer getLargestElementSumOfThreeOthersInSet(List<Integer> in){
	    
	    int size = in.size();
	    if(size < 4) return null;
	    
	    if( size == 4 ){
	        int largest = in.remove(0);
	        int sum = 0;
	        for( Integer num : in ) sum += num;
	        
	        return sum == largest ? largest : null;
	    } else {
	        for(int i = 0; i < in.size(); i++){
	            List<Integer> subset = new LinkedList<Integer>();
	            subset.addAll(in);
	            subset.remove(i);
	            Integer result = GFG.getLargestElementSumOfThreeOthersInSet(subset);
	            if( result != null ) return result;
	        }
	        return null;
	    }
	}
}
