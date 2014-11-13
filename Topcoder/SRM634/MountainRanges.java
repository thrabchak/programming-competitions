package SRM634;
//634
public class MountainRanges {
	
	public int countPeaks(int[] input){
		int numPeaks = 0;
		int prevVal = 0;
		int nextVal = 0;
	
		//single number
		if(input.length == 1)
			return 1;
		
		for(int i = 0; i < input.length-1; i++){
			int curVal = input[i];
			nextVal = input[i+1];
			if(curVal > prevVal && curVal > nextVal)
				numPeaks++;
			prevVal = input[i];
		}
		
		//last number
		if(input[input.length-1] > input[input.length-2])
			numPeaks++;
			
		return numPeaks;
	}

	public static void main(String[] args) {
		MountainRanges m = new MountainRanges();
		
		int[] a = {1,2,3,4,4,3,2,1};
		System.out.println(m.countPeaks(a));

	}

}
