class Hash{
	private long hash;
	private Hash next;
	private String dataFirst;
	private String dataLast;
	private String dataEmail;
	private String dataPhone;


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
		if(this.next == null){
			return this;
		}
		else{
			return this.next.returnLastNode();
		}
	}

}