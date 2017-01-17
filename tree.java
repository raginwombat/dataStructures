
class Tree{
	private String dataFirst;
	private String dataLast;
	private String dataEmail;
	private String dataPhone;
	private Tree childLeft;
	private Tree childRight;



	public Tree(){
		this.setThis("", "", "", "", null, null);

	}

	public Tree(String firstName, String lastName){
		this.setThis(firstName, lastName, "", "", null, null);

	}


	public Tree(String firstName, String lastName, String email, String phoneNum){
		this.setThis(firstName, lastName, email, phoneNum, null, null);

	}

	public Tree(String firstName, String lastName, String email, String phoneNum, 
		Tree leftTree, Tree rightTree){
		this.setThis(firstName, lastName, email, phoneNum, leftTree, rightTree);

	}

	public Tree(Tree t){

		this.setThis(t.getFirstName(), t.getLastName(), t.getEmail(), t.getPhoneNum(), t.getRightNode(), t.getLeftNode());
	}

	private void setThis(String firstName, String lastName, String email, String phoneNum, 
		Tree leftTree, Tree rightTree){
		/* Object warppers for params needs to be parsed before throwing to wrapper
		this.dataFirst = new String( firstName);
		this.dataLast = new String( lastName);
		this.dataEmail= new String( email);
		this.dataPhone = new String( phoneNum);
		this.childLeft = new Tree(leftTree);
		this.childRight = new Tree(rightTree);
		*/
		this.dataFirst =  firstName;
		this.dataLast = lastName;
		this.dataEmail= email;
		this.dataPhone = phoneNum;
		this.childLeft = leftTree;
		this.childRight = rightTree;


	}

	private String hash(){
		String hash = new String(""); 
		String[] vals = new String[4] ;
		vals[0] = this.getLastName();
		vals[1] = this.getFirstName();
		vals[2] = this.getPhoneNum();
		vals[3] = this.getEmail();
		//hash =  (String) (this.getLastName() + this.getFirstName() + this.getPhoneNum()+this.getEmail()).toUpperCase() ;
		for(String val:vals ){
			//System.out.println("Hash sub val" + val);

			if ( !val.isEmpty())
				hash = hash + val.toUpperCase();
			
		}
		//System.out.println("Hash val" + hash);
		return hash;
	}

	public boolean insert(Tree t){
	/* Function to add a given tree to the current tree
	@param: Tree t be a valid tree
	@returns: Boolean signifying sucessful insertion
	*/
		String thisHash, tHash;
		thisHash = this.hash();
		tHash = t.hash();

		int checkLength = thisHash.length();
		if( checkLength > tHash.length() )
				checkLength = tHash.length();
			//Interate through smallest string and check for precedence
		if(thisHash.isEmpty()){
				this.setThis(t.getFirstName(), t.getLastName(), t.getEmail(), t.getPhoneNum(), t.getRightNode(), t.getLeftNode());
				return true;
			}
		else if(thisHash == tHash){
				System.out.println("Duplicate node");
				return false;
			}

		for ( int i=0; i<checkLength; i++){
			if(thisHash.charAt(i) < tHash.charAt(i) && this.getRightNode() == null ){
				return this.setRightNode(t);
				
			}
			else if(thisHash.charAt(i) < tHash.charAt(i) && this.getRightNode() != null ){
				return this.getRightNode().insert(t);
			}

			else if(thisHash.charAt(i) > tHash.charAt(i) && this.getLeftNode() == null ){
				return   this.setLeftNode(t); 
				
			}
			else if(thisHash.charAt(i) > tHash.charAt(i) && this.getLeftNode() != null ){
				return this.getLeftNode().insert(t);
				
			}

		}

		System.out.println("Didnt insert node failed tests ");
		System.out.println("In method for: " + this.getName());
		System.out.println("checkLength: " + checkLength);
		System.out.println("thisHash: " + thisHash + " thash: "+tHash);

		
		return false;
	}

	public boolean add(String firstName, String lastName, String email, String phoneNum){
	/* Function to add a given tree to the current tree, allows a param argument instead 
			of  a tree object
	@param: Tree t be a valid tree
	@returns: Boolean signifying sucessful insertion
	*/
		
		//Check to see if node exists
		//if (this.lookUp(new Tree(firstName,lastName) ) == null){
		boolean result = this.insert(new Tree(firstName, lastName, email, phoneNum) );
		if( result ) {

			//Node doesn't exist
			System.out.println("Added new node for: "+ firstName);
			//this.insert(new Tree(firstName, lastName, email, phoneNum));

			return true;

		}
		else{
			
			return false;
		}
	}

	public boolean delete(Tree t){
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

	public boolean remove(Tree t){

		return true;
	} 

	public void print(){
		System.out.println("First: "+ this.getFirstName() );
		System.out.println("Last: "+ this.getLastName() );
		System.out.println("Email: "+ this.getEmail() );
		System.out.println("Phone: "+ this.getPhoneNum() );

	}

	public Tree getRightNode(){
		return this.childRight;
	}
	
	public Tree getLeftNode(){
		return this.childLeft;
	}

	public boolean setRightNode(Tree rNode){
		//System.out.println("Right node =:" + this.childRight);
		if (this.childRight == null){
			this.childRight = rNode;
			return true;
		}
		else {
			return false;
			}
	}
	
	public boolean setLeftNode(Tree lNode){
		//System.out.println("left node =:" + this.childLeft);
		if (this.childLeft == null){
			this.childLeft = lNode;
			return true;
		}
		else{
			return false;
		}
	}


	public void preOrderSort(){


	}

	public void postOrderSort(){


	}

	public void preSort(){


	}


	public void nameLookUp(String firstName, String lastName){
		Tree result = this.lookUp ( new Tree( firstName, lastName) );
		if( result !=null){
			System.out.println("Found Match for: "+ firstName);
			result.print();
		}
		else
			System.out.println("No match found for : " + firstName);
		

	}

	public Tree lookUp(Tree t){
		String thisHash, tHash;
		thisHash = this.hash();
		tHash = t.hash();

		//System.out.println("Lookup function hit for: "+t.getName());
		int checkLength = thisHash.length();
		if( checkLength > tHash.length() )
				checkLength = tHash.length();
			//Interate through smallest string and check for precedence
		//System.out.println("Check length:" +checkLength);

		//Full hash match
		if(thisHash == tHash){
				return this;
			}
		
		//Have to allow a partial string serach to accomodate first naem lookups 
		else if(thisHash.startsWith(tHash) ){
			//System.out.println("Partial match");
			return this;
		}
		else if(thisHash.isEmpty() || tHash.isEmpty()){
			return null;
		}
		
		for ( int i=0; i<=checkLength; i++){
			if( thisHash.charAt(i) < tHash.charAt(i) && !thisHash.isEmpty() && !tHash.isEmpty() &&   this.getRightNode() != null ){
				//System.out.println("tHash: " + tHash);
				//System.out.println("thisHash: " + thisHash);
				return this.childRight.lookUp(t);
				
			}

			else if( thisHash.charAt(i) > tHash.charAt(i) && !thisHash.isEmpty() && !tHash.isEmpty() &&  this.getLeftNode() != null){
				return this.childLeft.lookUp(t);
				
			}
			
			if( thisHash.charAt(i) < tHash.charAt(i) &&  this.getRightNode() == null){
				//System.out.println("tHash: " + tHash);
				//System.out.println("thisHash: " + thisHash);
				return null;
			}

			else if( thisHash.charAt(i) > tHash.charAt(i) &&  this.getLeftNode() == null ){
				//this.childLeft.lookUp(t);
				return null;
			} 
		}

			
		
		return null;
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

	public void printAll(){

		if(this.getLeftNode() != null){
			this.getLeftNode().printAll();
		}
		this.print();
		if(this.getRightNode()!=null){
			this.getRightNode().printAll();
		}


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