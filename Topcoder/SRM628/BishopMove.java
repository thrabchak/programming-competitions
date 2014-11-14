public class BishopMove {

    private boolean onDifferentColor(int r1, int c1, int r2, int c2) {

	boolean a = onBlack(r1, c1);
	boolean b = onBlack(r2, c2);

	if (a == b)
	    return false;
	else
	    return true;
    }

    private boolean onBlack(int r, int c) {
	int a = r % 2;
	int b = c % 2;

	if (a == 0)
	    if (b == 0)
		return true;
	    else
		return false;
	else if (b == 0)
	    return false;
	else
	    return true;
    }

    private boolean inX(int r1, int c1, int r2, int c2) {
	int r, c;

	r = r1 + 1;
	c = c1 + 1;
	while (r < 8 && c < 8) {
	    if (r == r2 && c == c2)
		return true;
	    r++;
	    c++;
	}

	r = r1 - 1;
	c = c1 + 1;
	while (r > 0 && c < 8) {
	    if (r == r2 && c == c2)
		return true;
	    r--;
	    c++;
	}

	r = r1 - 1;
	c = c1 - 1;
	while (r > 0 && c > 0) {
	    if (r == r2 && c == c2)
		return true;
	    r--;
	    c--;
	}

	r = r1 + 1;
	c = c1 - 1;
	while (r < 8 && c > 0) {
	    if (r == r2 && c == c2)
		return true;
	    r++;
	    c--;
	}

	return false;
    }

    public int howManyMoves(int r1, int c1, int r2, int c2) {
	// invalid cell
	if (r1 > 7 || r1 < 0 || r2 > 7 || r2 < 0 || c1 > 7 || c1 < 0 || c2 > 7
		|| c2 < 0)
	    return -1;
	if (r1 == r2 && c1 == c2) // equality
	    return 0;
	if (onDifferentColor(r1, c1, r2, c2))
	    return -1;
	if (inX(r1, c1, r2, c2))
	    return 1;
	else
	    return 2;
    }
    //
    // public static void main(String[] args) {
    //
    // BishopMove bm = new BishopMove();
    // System.out.println(bm.onBlack(2, 3));
    // }
}
