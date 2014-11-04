public class GreaterGameDiv2{

  public int calc(int[] snuke, int[] sothe){
    int snukeScore = 0; 
    for(int i = 0; i < snuke.length; i++){
      if(snuke[i] > sothe[i])
        snukeScore++;
    }
    return snukeScore;
  }

}