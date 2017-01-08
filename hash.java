class Hash{
	private long hash;
	private Hash next;
	private String dataFirst;
	private String dataLast;
	private String dataEmail;
	private String dataPhone;


	public Hash(){
		this.setHash(0);
		this.setNext(null);
		this.setDataFirst( null);
		this.setDataLast( null);
		this.setDataEmail( null);
		this.setDataPhone( null);

	}

	public Hash(Hash h){
		this.setThis(h.getHash(), h.getNext(), h.getDataFirst(), h.getDataLast(), h.getDataPhone(), h.getDataEmail());
	}

	public Hash( String firstName, String lastName,  String phone, String email){
		this.setThis(0, null, firstName,lastName, phone, email);
	}

	public Hash( long hash, String firstName, String lastName, String phone, String email){
		this.setThis(hash, null,  firstName,lastName, phone, email);
	}


	public void setThis( long hash, Hash next, String firstName, String lastName, String phone, String email){
		this.setHash(hash);
		this.setNext(next);
		this.setDataFirst( firstName);
		this.setDataLast( lastName);
		this.setDataEmail( email);
		this.setDataPhone( phone);
		
	}

	public void setHash(long hash){
		this.hash = hash;
	}

	public long getHash(){
		return this.hash;
	}


	public void setDataFirst(String dataFirst){
		this.dataFirst = dataFirst;
	}

	public String getDataFirst(){
		return this.dataFirst;
	}

	public void setDataLast(String dataLast){
		this.dataLast = dataLast;
	}

	public String getDataLast(){
		return this.dataLast;
	}

	public void setDataEmail(String dataEmail){
		this.dataEmail = dataEmail;
	}

	public String getDataEmail(){
		return this.dataEmail;
	}

	public void setDataPhone(String dataPhone){
		this.dataPhone = dataPhone;
	}

	public String getDataPhone(){
		return this.dataPhone;
	}

	public void setNext(Hash next){
		this.next = next;
	}

	public Hash getNext(){
		return this.next;
	}

	public Hash returnLastNode(){
		/*Helper method to traverse linked list */
		//System.out.println("return last node code");
		if(this.getNext() == null){
			return this;
		}
		else{
			//System.out.println("Trying next ndoe");
			return this.getNext().returnLastNode();
		}
	}

	public void print(){
	System.out.println("Hash: " + this.getHash() );
		System.out.println("First Name: " + this.getDataFirst() );
		System.out.println("Last Name: " + this.getDataLast() );
		System.out.println("Email: "  + this.getDataEmail() );
		System.out.println("Phone: "  + this.getDataPhone() );
	}

	public String getName(){
		return this.dataFirst+ " "+this.dataLast;
	}

	public void printAll(){
		if (this.getNext() == null)
			this.print();
		
		else{
			this.print();
			this.getNext().printAll();
		}
	}

	public boolean add(Hash h){
		/* Links the bucket list together by appending the new hashes to the last node in the bucket.*/
		if(this.getHash() == 0 && this.getNext() == null){
			this.setThis(h.getHash(), h.getNext(), h.getDataFirst(), h.getDataLast(), h.getDataPhone(), h.getDataEmail());
			return true;

		}
		if(this.getNext() == null){
			this.setNext(h);
			return true;
		}
		else{
			this.getNext().add(h);
		}

		return false;
	}
}	