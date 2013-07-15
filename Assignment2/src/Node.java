
public class Node {
	
	private char value;
	private Node link;
	
	public Node(char value){
		this.value = value;
		link = null;
	}
	
	public Node(char value, Node link){
		this.value = value;
		this.link = link;
	}
	
	public char getValue() {
		return value;
	}
	
	public void setValue(char value) {
		this.value = value;
	}
	
	public Node next() {
		return link;
	}
	
	public void setLink(Node link) {
		this.link = link;
	}
}
