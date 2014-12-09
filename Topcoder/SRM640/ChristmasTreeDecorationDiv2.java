public class ChristmasTreeDecorationDiv2{
  
  public int solve(int[] col, int[] x, int[] y){
    int sum = 0;
    for(int i = 0; i < x.length; i++){
      int starA = x[i];
      int starB = y[i];

      int colA = col[starA-1];
      int colB = col[starB-1];

      if(colA != colB)
        sum++;
    }


    return sum;


  }

}