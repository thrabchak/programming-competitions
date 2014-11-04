public class PathGameDiv2{
  private int TOP = 0;
  private int BOT = 1;

  public int calc(String[] board){

    //init
    int numColoredBlack = 0;
    boolean onTop;
    int initLengthTop = 0;
    int initLengthBot = 0;

    //determine starting location
    for(int i = 0; i < board[TOP].length(); i++){
      if(board[TOP].charAt(i) == '.')
        initLengthTop++;
      if(board[BOT].charAt(i) == '.')
        initLengthBot++;

      if(board[TOP].charAt(i) == '#' || board[BOT].charAt(i) == '#')
        break;
    }
    if(initLengthTop > initLengthBot)
      onTop=true;
    else
      onTop = false;


    System.out.println("Starting onTop: " + onTop);

    boolean repeat = false;
    //iterate through board
    for(int i = 0; i < board[TOP].length()-1; i++){
      System.out.println("i : " + i);

      if(onTop){
        if(board[TOP].charAt(i+1) == '.'){
          if(board[BOT].charAt(i) == '.'){
            System.out.println("incr");
            if(!repeat)
              numColoredBlack++;
            repeat = false;
          }
        }else{
          if(board[BOT].charAt(i) == '.'){
            System.out.println("change sides");
            onTop = false;
            i--;
            repeat = true;
          }
          else
            System.out.println("Error condition");
        }  

      }else{ //onTop = false;

        if(board[BOT].charAt(i+1) == '.'){
          if(board[TOP].charAt(i) == '.'){
            if(!repeat)
              numColoredBlack++;
            repeat = false;
            System.out.println("incr");
          }
        } else {
          if(board[TOP].charAt(i) == '.'){
            onTop = true;
            i--;
            repeat = true;
            System.out.println("change sides");
          }
          else
            System.out.println("Error condition");
        }
      }
    }

    //last index case
    int i = board[TOP].length()-1;
    if(onTop && board[BOT].charAt(i) == '.')
      numColoredBlack++;
    else if(!onTop && board[TOP].charAt(i) == '.')
      numColoredBlack++;

    return numColoredBlack;

  }

}