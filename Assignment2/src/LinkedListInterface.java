
public interface LinkedListInterface {

	public void add(char c);
	
	public int indexOf(String key);
	
	public int indexOf(String key, int startIndex);
	
	public char charAt(int index);
	
	public String subString(int startIndex);
	
	public String subString(int startIndex, int endIndex);
	
	public void insert(String s, int index);
	
	public String toString();
	
	public Node getLastNode();
	
	public Node getFirstNode();

	public void setFirstNode(Node firstNode);
	
	public Node get(int index);
	
	public int size();
}

