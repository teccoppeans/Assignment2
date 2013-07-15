
import java.io.*;
import java.util.*;

public class LinkedListString implements LinkedListInterface {

	private Node firstNode;

	public LinkedListString(String s) {
		//set the first node to the first character in the string
		if(s != null && !s.equals(""))
			firstNode = new Node(s.charAt(0));
		else
			firstNode = null;
		Node currentNode = firstNode;
		Node nextNode = null;
		//add characters to the linked list
		for (int i = 1; i < s.length(); ++i){
			nextNode = new Node(s.charAt(i));
			currentNode.setLink(nextNode);
			currentNode = currentNode.next();
		}
	}
	
	public LinkedListString(File f) {
		//attempt to read in the file
		try {
			Scanner fInput = new Scanner(f);
			while(fInput.hasNextLine()){
				String s = fInput.nextLine();
				if (firstNode != null)
					insert(s, this.size());
				else {
					//set the first node to the first character in the string
					firstNode = new Node(s.charAt(0));
					Node currentNode = firstNode;
					Node nextNode = null;
					//add characters to the linked list
					for (int i = 1; i < s.length(); ++i){
						nextNode = new Node(s.charAt(i));
						currentNode.setLink(nextNode);
						currentNode = currentNode.next();
					}
				}
			}
			fInput.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public LinkedListString(LinkedListString other) {
		this(other.toString());
	}
	

	public void add(char c) {
		Node temp = new Node(c);
		getLastNode().setLink(temp);
	}
	
	public void addAll(LinkedListString lls) {
		if (this.size() == 0)
			firstNode = lls.getFirstNode();
		getLastNode().setLink(lls.getFirstNode());
	}
	
	public int indexOf(String key) {
		for (int start = 0; start < size() - key.length(); ++start)
			if (this.subString(start, start + key.length()).equals(key))
				return start;
		return -1;
	}
	
	public int indexOf(String key, int startIndex) {
		for (int start = startIndex; start < size() - key.length(); ++start)
			if (this.subString(start, start + key.length()).equals(key))
				return start;
		return -1;
	}
	
	public char charAt(int index) {
		return this.get(index).getValue();
	}
	
	public String subString(int startIndex) {
		String s = "";
		Node currentNode = get(startIndex);
		while (currentNode != null){
			s += currentNode.getValue();
			currentNode = currentNode.next();
		}
		return s;
	}
	
	public String subString(int startIndex, int endIndex) {
		String s = "";
		if (startIndex < endIndex) {
			Node currentNode = get(startIndex);
			while (currentNode != get(endIndex)){
				s += currentNode.getValue();
				currentNode = currentNode.next();
			}
		}
		return s;
	}
	
	public void insert(String s, int index) {
		if (index < 0 || index > this.size())
			throw new IndexOutOfBoundsException();
		LinkedListString temp = new LinkedListString(s);
		if (index != 0){
			temp.getLastNode().setLink(this.get(index - 1).next());
			this.get(index - 1).setLink(temp.getFirstNode());
		}
		else {
			temp.getLastNode().setLink(this.getFirstNode());
			firstNode = temp.getFirstNode();
		}
	}
	
	public String toString() {
		String s = "";
		Node currentNode = firstNode;
		while (currentNode != null){
			s += currentNode.getValue();
			currentNode = currentNode.next();
		}
		return s;
	}
	
	public Node getLastNode() {
		Node currentNode = firstNode;
		while (currentNode.next() != null)
			currentNode = currentNode.next();
		return currentNode;
	}
	
	public Node getFirstNode() {
		return firstNode;
	}

	public void setFirstNode(Node firstNode) {
		this.firstNode = firstNode;
	}
	
	public Node get(int index) {
		if (index < 0 || index > this.size())
			throw new IndexOutOfBoundsException();
		Node currentNode = firstNode;
		for (int i = 0; i < index; ++i){
			currentNode = currentNode.next();
		}
		return currentNode;
	}
	
	public int size() {
		int size = 0;
		Node currentNode = firstNode;
		while (currentNode != null){
			currentNode = currentNode.next();
			++size;
		}
		return size;
	}
	
}
