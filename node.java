package TreePackage;
class Node<T> implements TreeInterface<T> {
	private String dataFirst;
	private String dataLast;
	private String dataEmail;
	private String dataPhone;
	private Tree childLeft;
	private Tree childRight;

	public Tree(){
		this.setThis(null, null, null, null, null, null);

	}

	public Tree(String firstName, String lastName){
		this.setThis(firstName, lastName, null, null, null, null);

	}


	public Tree(String firstName, String lastName, String email, String phoneNum){
		this.setThis(firstName, lastName, email, phoneNum, null, null);

	}

	public Tree(String firstName, String lastName, String email, String phoneNum, 
		Tree leftTree, Tree rightTree){
		this.setThis(firstName, lastName, email, phoneNum, leftTree, rightTree);

	}

	private void setThis(String firstName, String lastName, String email, String phoneNum, 
		Tree leftTree, Tree rightTree){
		this.dataFirst = firstName;
		this.dataLast = lastName;
		this.dataEmail = email;
		this.dataPhone = phoneNum;
		this.childLeft = leftTree;
		this.childRight = rightTree;


	}


}