package SRM638;

import java.util.ArrayList;

public class CandleTimerEasy {
	
	public boolean allBurnt(int[] burning, int[] a, int[] b, int[] len){
		
		int numElements = 0;
		for(int i = 0; i < a.length; i++){
			if(a[i] > numElements)
				numElements = a[i];
			if(b[i] > numElements)
				numElements = b[i];			
		}
		if(burning.length == numElements+1)
			return true;
		return false;
	}
	
	public int burn(int[] burning, int time, int[] a, int[] b, int[] len){
		if(allBurnt(burning, a,b,len)){
			return time;
		}
		
		int longestTime = 0;
		for(int i = 0; i < burning.length; i++){
			for(int j = 0; j < a.length; j++){
				if(burning[i] == a[j]){
					if()
				}
			}
		}
		return longestTime + time;
	}
	
	public int differentTime(int[] a, int[] b, int[] len){
		ArrayList<int[]> possibilities = new ArrayList<int[]>();
		//make possibilities
		int numElements = 0;
		for(int i = 0; i < a.length; i++){
			if(a[i] > numElements)
				numElements = a[i];
			if(b[i] > numElements)
				numElements = b[i];			
		}
		numElements++;
		
		
		
		ArrayList<Integer> times = new ArrayList<Integer>();
		for(int i = 0; i < possibilities.size(); i++){
			
			int newTime = burn(possibilities.get(i), 0, a, b, len);
			boolean isNew = true;
			for(int j = 0; j < times.size(); j++){
				if(times.get(j) == newTime)
					isNew = false;				
			}
			if(isNew)
				times.add(newTime);
		}
		
		return times.size();		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
