import java.util.ArrayList;

public class Egalitarianism3Easy {

    public int maxCities(int n, int[] a, int[] b, int[] len) {

	ArrayList<Node> nodes = new ArrayList<Node>();
	nodes.add(null);
	for (int i = 1; i <= n; i++)
	    nodes.add(new Node(i));

	for (int i = 0; i < a.length; i++) {
	    nodes.get(b[i]).parent = nodes.get(a[i]);
	    nodes.get(a[i]).children.add(nodes.get(b[i]));
	    nodes.get(b[i]).distFromParent = len[i];
	}
	print(nodes.get(1));

	ArrayList<ArrayList<Integer>> big = new ArrayList<ArrayList<Integer>>();

	for (int i = 1; i < nodes.size(); i++)
	    big.add(getDistsAllNodes(nodes.get(i)));

	int result = findMostCommon(big);
	return result;
    }

    int findMostCommon(ArrayList<ArrayList<Integer>> a) {

	return 0;
    }

    ArrayList<Integer> getDistsAllNodes(Node n) {

    }

    void print(Node n) {
	System.out.println("id: " + n.id + " di: " + n.distFromParent);
	for (Node child : n.children) {
	    print(child);
	}
    }

    public static void main(String[] args) {
	Egalitarianism3Easy e = new Egalitarianism3Easy();
	int[] a = { 1, 1, 1 };
	int[] b = { 2, 3, 4 };
	int[] len = { 1, 1, 1 };
	System.out.println(e.maxCities(4, a, b, len));

    }

    class Node {
	public int id;
	public Node parent;
	public int distFromParent;
	public ArrayList<Node> children;

	Node() {
	    id = 1;
	    parent = null;
	    distFromParent = -1;
	    children = new ArrayList<Node>();
	}

	Node(int i) {
	    id = i;
	    parent = null;
	    distFromParent = -1;
	    children = new ArrayList<Node>();
	}

	Node(int id, Node p, int dist) {
	    this.id = id;
	    parent = p;
	    distFromParent = dist;
	    children = new ArrayList<Node>();
	}

	void addChild(Node n, int dist) {
	    children.add(n);
	}

    }
}
