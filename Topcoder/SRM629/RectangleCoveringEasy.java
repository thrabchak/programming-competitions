public class RectangleCoveringEasy{
  
  public int solve(int holeH, int holeW, int boardH, int boardW){

    if(boardH > holeH && boardW >= holeW || boardH >= holeH && boardW > holeW)
      return 1;
    if(boardW > holeH && boardH >= holeW || boardW >= holeH && boardH > holeW)
      return 1;

    return -1;
  }


}