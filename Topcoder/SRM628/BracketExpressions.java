import java.util.Stack;

public class BracketExpressions {

    public String ifPossible(String expression) {
	StringBuffer sb = new StringBuffer();
	int numXs = 0;
	Stack<Character> stack = new Stack<Character>();

	for (int i = 0; i < expression.length(); i++) {
	    char c = expression.charAt(i);
	    if (c == '[' || c == '(' || c == '{') {
		stack.push(c);
		sb.append(c);
	    } else if ((c == ']' || c == ')' || c == '}') && stack.peek() == c) {
		stack.pop();
		sb.append(c);
	    } else if (c == 'X' && stack.size() > 0) {

	    }
	}

	return "impossible";
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
