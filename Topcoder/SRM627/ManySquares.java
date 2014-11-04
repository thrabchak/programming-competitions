 public class ManySquares{

  public int howManySquares(int[] sticks){
    int numSquares = 0;

    //create values array and initialize it
    int[] values = new int[1001];
    for(int i = 0; i < values.length; i++){
      values[i] = 0;
    }

    //fill values array
    for(int i = 0; i < sticks.length; i++){
      values[sticks[i]]++;
    }

    //go through values array
    for(int i = 0; i < values.length; i++){
      numSquares += values[i]/4;
    }

    return numSquares;
  }

 }