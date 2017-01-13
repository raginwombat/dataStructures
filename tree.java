class Tree{
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

	private String hash(){

		return  (String) (this.getLastName() + this.getFirstName() + this.getPhoneNum()+this.getEmail()).toUpperCase() ;
	}

	public Boolean insert(Tree t){
	/* Function to add a given tree to the current tree
	@param: Tree t be a valid tree
	@returns: Boolean signifying sucessful insertion
	*/
		System.out.println("Hit Insert for: "+t.getFirstName());
		//Store hashes so not recalled
		String thisHash, tHash;
		thisHash = this.hash();
		tHash = t.hash();

		
		int checkLength = thisHash.length();
		if( checkLength > tHash.length() )
				checkLength = tHash.length();
			//Interate through smallest string and check for precedence
		for ( int i=0; i<checkLength; i++){
			System.out.println("Hit Insert for loop");

			//Check for duplicate node
			if(thisHash == tHash){
				System.out.println("Passsed Check 1");
				System.out.println("thishash: "+thisHash.charAt(i) + " thash: "+tHash.charAt(i));
				System.out.println("Duplicate node");
				return false;
			}

			else if(thisHash.charAt(i) < tHash.charAt(i) ){
				// Go down Right Tree
				System.out.println("Passsed Check 2");
				System.out.println("thishash: "+thisHash.charAt(i) + " thash: "+tHash.charAt(i));
				if(this.getRightNode() == null){
						System.out.println("Inserting node for rigt node: "+t.getName());
						this.setRightNode(t);
						return true;
					}
				else{
					this.childRight.insert(t);
					
				}
			}


			else if(thisHash.charAt(i) > tHash.charAt(i) ){
			// Go down left Tree
				System.out.println("Passsed Check 3");
				System.out.println("thishash: "+thisHash.charAt(i) + " thash: "+tHash.charAt(i));
				if(this.getLeftNode() == null){
						System.out.println("Inserting node for left node : "+t.getName());
						this.setLeftNode(t);
						return true;

				}
				else{
					this.childLeft.insert(t);
					
				}
			}
		
			//If haven't exited then  dealing with a simlar node with diff vals, like same nmae diff number
			// shouldn't need since hash is full string
			/*
			else if(i == checkLength-1){
				if(thisHash.length() > tHash.length()){
					if(this.getRightNode() == null){
						System.out.println("Inserting node for : "+t.getName());
						this.setRightNode(t);
						return true;
					}
				else{
					this.getRightNode().insert(t);
					
				}

				}
				else if(thisHash.length() <  tHash.length()){
					if(this.getLeftNode() == null){
						System.out.println("Inserting node for : "+t.getName());
						this.setLeftNode(t);
						return true;
					}
					else{
						this.getLeftNode().insert(t);
						
					}
				}

			}*/
			

		}

		

		/*

		//Just append to the last note
		this.lastRightNode().setRightNode(t);
		this.preOrderSort();
		System.out.println("Node added for "+this.lastRightNode().getName());
		return true; */

		//if the code is getting this far something went wrong
		return false;
	}

	public Boolean add(String firstName, String lastName, String email, String phoneNum){
	/* Function to add a given tree to the current tree, allows a param argument instead 
			of  a tree object
	@param: Tree t be a valid tree
	@returns: Boolean signifying sucessful insertion
	*/
		System.out.println("Hit add node for: "+firstName);
		//Check to see if node exists
		if (this.lookUp(new Tree(firstName,lastName) ) != null){
			//Node doesn't exist
			this.insert(new Tree(firstName, lastName, email, phoneNum));

			return true;

		}
		else
			return false;
	}

	public Boolean delete(Tree t){
	/* Function to delete a given node in the the current tree
	@param: Tree t be a valid tree
	@returns: Boolean signifying sucessful insertion
	*/
		if (this.lookUp(new Tree(t.getFirstName(), t.getLastName()) ) != null){
			//Node doesn't exist
			this.insert(new Tree(t.getFirstName(), t.getLastName(), t.getEmail(), t.getPhoneNum()));
			return true;

		}
		else
			return false;
	}

	public Boolean remove(Tree t){

		return true;
	} 

	public void printAll(){


	}

	public Tree getRightNode(){
		return this.childRight;
	}
	
	public Tree getLeftNode(){
		return this.childLeft;
	}

	public boolean setRightNode(Tree rNode){
		if (this.childRight == null){
			this.childRight = rNode;
			return true;
		}
		else
			return false;
	}
	
	public boolean setLeftNode(Tree lNode){
		if (this.childLeft == null){
			this.childLeft = lNode;
			return true;
		}
		else
			return false;
	}


	public void preOrderSort(){


	}

	public void postOrderSort(){


	}

	public void preSort(){


	}


	public void nameLookUp(String firstName, String lastName){
		

	}

	public Tree lookUp(Tree t){
		return t;
	}

	public void nameDelete(String firstName, String lastName){

	}

	private Tree lastRightNode(){
		if( this.getRightNode() == null)
			return this;
		else
			return this.getRightNode().lastRightNode();

	}

	private Tree lastLeftNode(){
		if( this.getLeftNode() == null)
			return this;
		else

			return this.getLeftNode().lastLeftNode();
	}

	public String getFirstName(){
		return this.dataFirst;
	}


	public String getLastName(){
		return this.dataLast;
	}

	public String getName(){
		return this.dataFirst+" "+ this.dataLast;
	}

	public String getPhoneNum(){
		return this.dataPhone;
	}
	public String getEmail(){
		return this.dataEmail;
	}


/*
	public Tree traverse(){
		if( this = this.lastLeftNode() )
			return this;
		else
			return this.leftNode().traverse();

		if(this = this.lastRightNode())
			return this;
		else
			return this.rightNode.traverse();
		if( this != this.lastRightNode || this !=lastLeftNode)
			return this;


	}  */
}