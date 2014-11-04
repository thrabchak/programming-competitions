public class HappyLetterDiv2{
  
  public char getHappyLetter(String letters){
    char happyChar = '.';

    Result result = determineResult(letters);

    if(result.a > result.b)
      return result.c;
    else
      return '.';
  }

  public Result determineResult(String letters){

    int[] values = new int[26];
    for(int i = 0; i < values.length; i++){
      values[i] = 0; 
    }

    int temp;
    for(int i = 0; i < letters.length(); i++){
      temp = letters.charAt(i) - 'a';
      values[temp]++;
    }

    int mostPopularChar = 0;
    for(int i = 1; i < values.length; i++){
      if (values[i] > values[mostPopularChar] )
        mostPopularChar = values[i];
    }

    int others = 0;
    for(int i = 0; i < values.length; i++){
      if(i != mostPopularChar){
        others += values[i];
      }
    }

    Result result = new Result((char)(mostPopularChar + 'a'), values[mostPopularChar], others);
    System.out.println(result.c + " " + result.a + " " + result.b);


    return result;

  }

  public class Result{

    public char c;
    public int a;
    public int b;

    public Result(char c, int a, int b){
      this.c = c;
      this.a = a;
      this.b = b;
    }
  }

}