
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
		
		for(String val:vals ){
			if ( !val.isEmpty())
				hash = hash + val.toUpperCase();
			
		}
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
			//RN Interate through smallest string and check for precedence
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
		
		//RN Check to see if node exists
		boolean result = this.insert(new Tree(firstName, lastName, email, phoneNum) );
		if( result ) {

			//RN Node doesn't exist
			System.out.println("Added new node for: "+ firstName);
			return true;

		}
		else{
			
			return false;
		}
	}

	public boolean nameDelete(String firstname, String lastName){
	/* Function to delete a given node in the the current tree
	@param: Tree t be a valid tree
	@returns: Boolean signifying sucessful insertion
	*/
		Tree t= this.lookUp(new Tree(firstname, lastName));
		if ( t!= null){
			//RN Node doesn't exist
			System.out.println("Deleting node for "+ firstname + " "+lastName);
			return this.remove(t);
		}
		else{
			System.out.println("Node not deleted for "+ firstname + " "+lastName );
			return false;

		}
	}


	public boolean remove(Tree t){
		String compareHash = this.hash();
		String checkHash = t.hash();
		

		//RN Case 1: root node needs to be removed
		//RN Case 2:
		//RN Case 3
				
		if( compareHash.startsWith( checkHash) ){

			if(this.getLeftNode() != null && this.getRightNode() !=null){
				//RN If 2 children
				//RN Do a comlplicated shifteroo
				//RN have to get parent and set it to null
				this.setThis( this.lastLeftNode().getFirstName(), this.lastLeftNode().getLastName(), 
					this.lastLeftNode().getEmail(), this.lastLeftNode().getPhoneNum(), this.lastLeftNode().getRightNode(),
					this.lastLeftNode().getRightNode());
				this.lastLeftNode().setThis("", "", "", "", null, null);
				return true;
			}

			else if(this.getLeftNode() != null && this.getRightNode() == null){
				//RN If only left child ;
				//RN replace this w/ left node
				this.setThis( this.getLeftNode().getFirstName(), this.getLeftNode().getLastName(), 
					this.getLeftNode().getEmail(), this.getLeftNode().getPhoneNum(), this.getLeftNode().getLeftNode(),
					null);

				this.setLeftNode(null);
				return true;
			}

			else if(this.getLeftNode() == null && this.getRightNode() != null){
				//RN If only right child ;
				//RN replace this w/  right node
				this.setThis( this.getRightNode().lastLeftNode().getFirstName(), this.getRightNode().lastLeftNode().getLastName(), 
					this.getRightNode().lastLeftNode().getEmail(), this.getRightNode().lastLeftNode().getPhoneNum(), this.getRightNode(),
					this.getRightNode().lastLeftNode().getRightNode());

				this.getRightNode().setRightNode(null);
				return true;
				
			}

			else if(this.getRightNode() == null & this.getLeftNode() == null){
				//RN If no children;
				//RN just kill this node, it'll get overwritten when inserting
				this.setThis("","","","", null, null);
				return true;
			
			}

		}

		String thisHash, tHash;
		thisHash = this.hash();
		tHash = t.hash();

			
		int checkLength = thisHash.length();
		//RN Interate through smallest string and check for precedence
		if( checkLength > tHash.length() )
				checkLength = tHash.length();

		
		for ( int i=0; i<checkLength; i++){
			if(thisHash.charAt(i) < tHash.charAt(i) && this.getRightNode() != null ){
				return this.getRightNode().remove(t);				
			}			
			else if(thisHash.charAt(i) > tHash.charAt(i) && this.getLeftNode() != null ){
				return this.getLeftNode().remove(t);				
			}
		}
		System.out.println("Coulnd't find for delete: "+t.getName());
		return false;
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
		if (this.childRight == null){
			this.childRight = rNode;
			return true;
		}
		else {
			return false;
			}
	}
	
	public boolean setLeftNode(Tree lNode){
		if (this.childLeft == null){
			this.childLeft = lNode;
			return true;
		}
		else{
			return false;
		}
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

		int checkLength = thisHash.length();
		if( checkLength > tHash.length() )
				checkLength = tHash.length();

		//RN Full hash match
		if(thisHash == tHash){
				return this;
			}
		
		//RN Have to allow a partial string serach to accomodate first naem lookups 
		else if(thisHash.startsWith(tHash) ){
			return this;
		}
		else if(thisHash.isEmpty() || tHash.isEmpty()){
			return null;
		}
		
		for ( int i=0; i<=checkLength; i++){
			if( thisHash.charAt(i) < tHash.charAt(i) && !thisHash.isEmpty() && !tHash.isEmpty() &&   this.getRightNode() != null ){
				return this.childRight.lookUp(t);
				
			}

			else if( thisHash.charAt(i) > tHash.charAt(i) && !thisHash.isEmpty() && !tHash.isEmpty() &&  this.getLeftNode() != null){
				return this.childLeft.lookUp(t);
				
			}
			
			if( thisHash.charAt(i) < tHash.charAt(i) &&  this.getRightNode() == null){
				return null;
			}

			else if( thisHash.charAt(i) > tHash.charAt(i) &&  this.getLeftNode() == null ){
				return null;
			} 
		}

			
		
		return null;
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
}