public class DoubleLetter {
    public String ableToSolve(String input) {

	while (hasConsecutiveLetters(input)) {
	    input = removeConsecutiveLetters(input);
	    System.out.println(input);
	}
	if (input.equals(""))
	    return "Possible";
	else
	    return "Impossible";
    }

    boolean hasConsecutiveLetters(String s) {
	for (int i = 0; i < s.length() - 1; i++) {
	    if (s.charAt(i) == s.charAt(i + 1))
		return true;
	}

	return false;
    }

    String removeConsecutiveLetters(String s) {

	for (int i = 0; i < s.length() - 1; i++) {
	    if (s.charAt(i) == s.charAt(i + 1)) {
		{
		    System.out.println(i);
		    String out = "";
		    if (i - 1 >= 0)
			out += s.substring(0, i);
		    if (i + 2 < s.length())
			out += s.substring(i + 2, s.length());
		    System.out.println("out: " + out);
		    return out;
		}
	    }
	}
	System.err.println("Error!:(");
	return "";
    }

    public static void main(String[] args) {
	DoubleLetter d = new DoubleLetter();
	System.out.println(d.ableToSolve("zzxzxxzxxzzx"));
    }
}
