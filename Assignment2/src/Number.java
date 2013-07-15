
public class Number{

	private LinkedListString number;
	
	public Number(String s) {
		number = new LinkedListString(s);
		// TODO Auto-generated constructor stub
	}
	
	public Number(int i) {
		number = new LinkedListString("" + i);
		// TODO Auto-generated constructor stub
	}
	
	public Number(Number n) {
		number = new LinkedListString(n.getNumber());
	}
	public LinkedListString getNumber() {
		return number;
	}
	
	public void setNumber(LinkedListString number) {
		this.number = number;
	}
	
	
	public static Number addNumber(Number n1, Number n2) {
		//copy first and second
		Number first = new Number(n1);
		Number second = new Number(n2);
		//create a result number and set it to a string of zeroes one larger than the largest added number's length
		Number bigger = (first.getNumber().size() > second.getNumber().size()) ? first : second;
		Number result = new Number(0);
		for (int i = 0; i < bigger.getNumber().size(); ++i)
			result.getNumber().add('0');
		
		int placeIndex = 1;
		boolean carry = false;
		while (placeIndex <= first.getNumber().size() && placeIndex <= second.getNumber().size()) {
			int firstInt = Integer.parseInt("" + first.getNumber().get(first.getNumber().size() - placeIndex).getValue());
			int secondInt = Integer.parseInt("" + second.getNumber().get(second.getNumber().size() - placeIndex).getValue());
			if (carry) {
				if (firstInt + secondInt + 1 >= 10) {
					carry = true;
					result.getNumber().get(result.getNumber().size() - placeIndex).setValue((char)(((int)'0')+((firstInt + secondInt + 1) % 10)));
				}
				else {
					carry = false;
					result.getNumber().get(result.getNumber().size() - placeIndex).setValue((char)(((int)'0')+((firstInt + secondInt + 1))));
				}
			}
			else {
				if (firstInt + secondInt >= 10) {
					carry = true;
					result.getNumber().get(result.getNumber().size() - placeIndex).setValue((char)(((int)'0')+((firstInt + secondInt) % 10)));
				}
				else {
					carry = false;
					result.getNumber().get(result.getNumber().size() - placeIndex).setValue((char)(((int)'0')+((firstInt + secondInt))));
				}
			}
			++placeIndex;
		}
		if (placeIndex <= first.getNumber().size()) {
			while (placeIndex <= first.getNumber().size()) {
				int firstInt = Integer.parseInt("" + first.getNumber().get(first.getNumber().size() - placeIndex).getValue());
				if (carry) {
					if (firstInt + 1 >= 10) {
						carry = true;
						result.getNumber().get(result.getNumber().size() - placeIndex).setValue((char)(((int)'0')+((firstInt + 1) % 10)));
					}
					else {
						carry = false;
						result.getNumber().get(result.getNumber().size() - placeIndex).setValue((char)(((int)'0')+((firstInt + 1))));
					}
				}
				else {
					result.getNumber().get(result.getNumber().size() - placeIndex).setValue((char)(((int)'0')+((firstInt))));
				}
				++placeIndex;
			}
		}
		if (placeIndex <= second.getNumber().size()) {
			while (placeIndex <= second.getNumber().size()) {
				int secondInt = Integer.parseInt("" + second.getNumber().get(second.getNumber().size() - placeIndex).getValue());
				if (carry) {
					if (secondInt + 1 >= 10) {
						carry = true;
						result.getNumber().get(result.getNumber().size() - placeIndex).setValue((char)(((int)'0')+((secondInt + 1) % 10)));
					}
					else {
						carry = false;
						result.getNumber().get(result.getNumber().size() - placeIndex).setValue((char)(((int)'0')+((secondInt + 1))));
					}
				}
				else {
					result.getNumber().get(result.getNumber().size() - placeIndex).setValue((char)(((int)'0')+((secondInt))));
				}
				++placeIndex;
			}
		}
		if (carry)
			result.getNumber().get(0).setValue('1');
		else
			result.getNumber().setFirstNode(result.getNumber().get(1));
		return result;
	}
	
	static public Number subtractNumber(Number n1, Number n2) {
		//copy first and second
		Number first = new Number(n1);
		Number second = new Number(n2);
		//create a result number and set it to a string of zeroes one larger than the largest added number's length
		Number bigger = (first.getNumber().size() > second.getNumber().size()) ? first : second;
		Number result = new Number(0);
		for (int i = 1; i < bigger.getNumber().size(); ++i)
			result.getNumber().add('0');
		
		int placeIndex = 1;
		boolean carry = false;
		while (placeIndex <= first.getNumber().size() && placeIndex <= second.getNumber().size()) {
			int firstInt = Integer.parseInt("" + first.getNumber().get(first.getNumber().size() - placeIndex).getValue());
			int secondInt = Integer.parseInt("" + second.getNumber().get(second.getNumber().size() - placeIndex).getValue());
			if (carry) {
				--firstInt;
				if (firstInt - secondInt  < 0) {
					carry = true;
					result.getNumber().get(result.getNumber().size() - placeIndex).setValue((char)(((int)'0')+((firstInt + 10 - secondInt))));
				}
				else {
					carry = false;
					result.getNumber().get(result.getNumber().size() - placeIndex).setValue((char)(((int)'0')+((firstInt - secondInt))));
				}
			}
			else {
				if (firstInt - secondInt  < 0) {
					carry = true;
					result.getNumber().get(result.getNumber().size() - placeIndex).setValue((char)(((int)'0')+((firstInt + 10 - secondInt))));
				}
				else {
					carry = false;
					result.getNumber().get(result.getNumber().size() - placeIndex).setValue((char)(((int)'0')+((firstInt - secondInt))));
				}
			}
			++placeIndex;
		}
		if (placeIndex <= first.getNumber().size()) {
			while (placeIndex <= first.getNumber().size()) {
				int firstInt = Integer.parseInt("" + first.getNumber().get(first.getNumber().size() - placeIndex).getValue());
				if (carry) {
					--firstInt;
					if (firstInt < 0) {
						carry = true;
						result.getNumber().get(result.getNumber().size() - placeIndex).setValue((char)(((int)'0')+((firstInt + 10))));
					}
					else {
						carry = false;
						result.getNumber().get(result.getNumber().size() - placeIndex).setValue((char)(((int)'0')+((firstInt))));
					}
				}
				else {
					result.getNumber().get(result.getNumber().size() - placeIndex).setValue((char)(((int)'0')+((firstInt))));
				}
				++placeIndex;
			}
		}
		if (carry)
			result.getNumber().setFirstNode(result.getNumber().get(1));
		if (result.getNumber().get(0).getValue() == '0')
			result.getNumber().setFirstNode(result.getNumber().get(1));
		return result;
		
	}
	
	public String toString(){
		return number.toString();
	}
}
