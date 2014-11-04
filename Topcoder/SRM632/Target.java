import java.util.ArrayList;

public class Target{

  public String[] draw(int  n){
    ArrayList<String> output = new ArrayList<String>();
    output.add("#");
    boolean blanks = true;
    for(int i = 1; i < n; i += 2){
      if(blanks)
        output = surroundWithBlanks(output);
      else
        output = surroundWithMarks(output);
      blanks = !blanks;
    } 
    String[] s = new String[n];
    ;
    return output.toArray(s);
  }

  private ArrayList<String> surroundWithMarks(ArrayList<String> output){
    int startSize = output.size();

    String cap = "";
    for (int i = 0; i < startSize+2; i++)
      cap += "#";
    output.add(0,cap);
    output.add(cap);

    for(int i = 1; i < startSize+1; i++){
      String currentString = output.get(i);
      output.remove(i);
      output.add(i, "#" + currentString + "#");
    }

    return output;
  }

  private ArrayList<String> surroundWithBlanks(ArrayList<String> output){
    int startSize = output.size();

    String cap = "";
    for (int i = 0; i < startSize+2; i++)
      cap += " ";
    output.add(0,cap);
    output.add(cap);

    for(int i = 1; i < startSize+1; i++){
      String currentString = output.get(i);
      output.remove(i);
      output.add(i, " " + currentString + " ");
    }

    return output;
  }
}