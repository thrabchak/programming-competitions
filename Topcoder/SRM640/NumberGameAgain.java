import java.lang.Math.*;
import java.util.ArrayList;

public class NumberGameAgain{

  long[] table;
  
  public long solve(int k, long[] table){
    long total = new Double((Math.pow(2,k))-2).longValue();
    System.out.println("max val: " + total);

    this.table = new long[table.length];
    for(int i = 0; i < table.length; i++)
      this.table[i] = table[i];

    for(int i = 0; i < table.length; i++){
      if(!alreadyConsidered(table[i]/2))
        total -= (new Double(Math.pow(2, k-depth(table[i]))-1).longValue());
    }

    return total;
  }

  public int depth(long x){
    double ans = Math.log(x) / Math.log(2);
    return new Double(ans).intValue();
  }

  public boolean alreadyConsidered(long x){
    if(x <= 1)
      return false;
    else if(existsInTable(x))
      return true;
    else
      return alreadyConsidered(x/2);
  }

  public boolean existsInTable(long x){
    for(int i = 0; i < table.length; i++)
      if(table[i] == x)
        return true;
    return false;
  }

}